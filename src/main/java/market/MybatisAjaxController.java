package market;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisAjaxController {
	
	
	@Autowired
	@Qualifier("mybatisservice")
	MarketService service;
	
	
	
	@PostMapping("ajaxtable2")
	public List<MarketDTO> creattable(MarketDTO dto) {
		// 연계데이터부분
		dto.setId("bbbb");
		dto.setMarket("롯데마트");
		dto.setState("결제대기");
		try {
		String originfilename =dto.img.getOriginalFilename();
		String beforefilename =originfilename.substring(0, originfilename.indexOf("."));
		String afterfilename =originfilename.substring(originfilename.indexOf("."));
		String imgname1 = beforefilename+UUID.randomUUID().toString()+afterfilename;
		dto.setImgname(imgname1);
		
		String savePath="/usr/mydir/upload/";
		File serverfile = new File(savePath+imgname1);
		dto.getImg().transferTo(serverfile);
		service.insertproduct(dto);
		}catch(Exception e){}
		List<MarketDTO> list = service.productlist(dto.id);
		return list;
	}
	@PostMapping("ajaxdelete")
	public /*List<MarketDTO>*/MarketDTO deletetable(String name) {
		service.deletepro(name);
//		List<MarketDTO> list = service.productlist("aaaa");
		
		
		return new MarketDTO();
				}
	
	
	@PostMapping("updateinfo")
	public MarketDTO updateinfo(MarketDTO dto) {
		MarketDTO dto1 =  service.updateinfo(dto);
		
		return dto1;
	}
	
	@PostMapping("ajaxupdate")
	public MarketDTO ajaxupdate(MarketDTO dto){
		// 연계데이터부분
		dto.setId("aaaa");
		dto.setMarket("하나로마트");
		dto.setState("결제대기");
		try {
		String originfilename =dto.img.getOriginalFilename();
		String beforefilename =originfilename.substring(0, originfilename.indexOf("."));
		String afterfilename =originfilename.substring(originfilename.indexOf("."));
		String imgname1 = beforefilename+UUID.randomUUID().toString()+afterfilename;
		dto.setImgname(imgname1);
		
		String savePath="/usr/mydir/upload/";
		File serverfile = new File(savePath+imgname1);
		dto.getImg().transferTo(serverfile);
		service.updatemember(dto);
		}catch(Exception e){}
		return new MarketDTO();
	}
	
	
	
	
	

	
	
	
	
	
	
	
	
	
}
