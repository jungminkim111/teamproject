package upload;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UploadController {
	@ResponseBody
	@RequestMapping(value="/hotel/manage/upload", method = RequestMethod.POST)
	public ImageDTO uploadresult(MultipartFile file1, HttpSession session , HttpServletResponse response) throws Exception{
		System.out.println("upload");
		MultipartFile mf1 = file1;
		String loginid = (String)session.getAttribute("userId");
		try {
		System.out.println(mf1.getOriginalFilename());
		System.out.println(mf1.getSize()); 
		System.out.println(mf1.isEmpty());
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		String savePath = "/usr/mydir/upload/hotel/"+loginid;
		try {
		Path hotelPath = Paths.get("/usr/mydir/upload/hotel/");
		Files.createDirectory(hotelPath);
		}catch(Exception e) {}
		try {
		Path directoryPath = Paths.get(savePath);
		// 디렉토리 생성
		Files.createDirectory(directoryPath);
		System.out.println(directoryPath + " 디렉토리가 생성되었습니다.");
		} catch (FileAlreadyExistsException e) {
		System.out.println("디렉토리가 이미 존재합니다");
		} catch (NoSuchFileException e) {
		System.out.println("디렉토리 경로가 존재하지 않습니다");
		}catch (IOException e) {
		e.printStackTrace();
		}
		

		ImageDTO img=new ImageDTO();
		if(!mf1.isEmpty()) {
			String originname1 = mf1.getOriginalFilename();
			String beforeext1 = loginid+"+";
//			String beforeext1 = originname1.substring(0, originname1.indexOf("."));
			String ext1 = originname1.substring(originname1.indexOf("."));
			File serverfile1 = new File(savePath +"/"+ beforeext1+"("+UUID.randomUUID().toString()+")"+ext1); 
			System.out.println(serverfile1);
			mf1.transferTo(serverfile1);
			img.setPath(serverfile1.toString());
		}
		
		return img;
	}
	private void logincheker(HttpSession session, HttpServletResponse response){
		if(session.getAttribute("userId")==null) {
			try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.'); location.href='/main/';</script>");
			out.flush();
			}catch (Exception e) {}
			
		}else {
			session.setAttribute("loginid", session.getAttribute("userId"));
		}
	}
}
