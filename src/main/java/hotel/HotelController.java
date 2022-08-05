package hotel;



import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;

import javax.annotation.CheckForSigned;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.datetime.DateFormatter;
import org.springframework.format.datetime.joda.LocalDateTimeParser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;
import com.fasterxml.jackson.databind.JsonNode;



@Controller
public class HotelController {
	
	@Autowired
	@Qualifier("hotelservice")
	HotelService hotelservice;
	
	@Autowired
	@Qualifier("mservice")
	MessageService mservice;
	 
	@Autowired
	@Qualifier("mapservice")
	NaverMapService mapservice;
	
	@RequestMapping("/Hotel")
	public String main(){ 
		return "Hotel"; 
	}
	@RequestMapping("/hotel")
	public String main2(){ 
		return "Hotel"; 
	}
	
	@RequestMapping("/hotel/search")
	public ModelAndView search(@RequestParam(required = true, defaultValue = " ")String text,@RequestParam(defaultValue = "1",required = true) int page){ 
		ModelAndView mv= new ModelAndView();
		System.out.println(text);
		System.err.println(page);
		mv.setViewName("/hotel/search");
		return mv; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/search" ,method=RequestMethod.POST)
	public ArrayList<HotelPostDTO> searchs(String text,int page){ 
		
		System.out.println(text);
		String[] new_str = text.split(" ");
		int new_page = (page-1)*15;
		for(int i=0; i<new_str.length;i++) {
			new_str[i] = "%"+new_str[i]+"%";
			System.out.println(new_str[i]);
		}
		ArrayList<HotelPostDTO> alist=null;
		try {
			alist= hotelservice.selecthotelsearch(new_str,new_page);
//			for (Iterator iterator = alist.iterator(); iterator.hasNext();) {
//				HotelPostDTO hotelPostDTO = (HotelPostDTO) iterator.next();
//				System.out.println(hotelPostDTO);
//			}
		}catch (Exception e) {
			e.printStackTrace();
		}

		return alist; 
	}
	@RequestMapping("/reservation")
	public ModelAndView reservation(HttpSession session){ 
		ModelAndView mv= new ModelAndView();
		String loginid=(String)session.getAttribute("userId");

		mv.setViewName("/hotel/reservation");

		return mv; 
	}
	@ResponseBody
	@RequestMapping(value="/reservation",method=RequestMethod.POST)
	public ArrayList<HotelReservationDTO> reservationpost(String user_id,HttpSession session){ 
		System.out.println("s");
		String loginid=(String)session.getAttribute("userId");
		ArrayList<HotelReservationDTO> hrdtos= hotelservice.selectReservationsbyuids(loginid);

		return hrdtos; 
	}
	@ResponseBody
	@RequestMapping(value="/reservation/confirm",method=RequestMethod.POST)
	public String reservationconfirm(String reservation_id,HttpSession session){ 
		System.out.println(reservation_id);
		String user_id=(String)session.getAttribute("userId");
		int result=0;
		String res=null;
		try {
			result= hotelservice.updateReservationConfirm(reservation_id);
			System.out.println(result);
			res =hotelservice.selectReservationsbybids(user_id).get(0).getConfirm();
			System.out.println(res);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return  "{\"result\":\""+res+"\"}"; 
	}
	@ResponseBody
	@RequestMapping(value="/reservation/cancel",method=RequestMethod.POST)
	public String reservationcancel(String reservation_id,HttpSession session){ 
		System.out.println(reservation_id);
		String user_id=(String)session.getAttribute("userId");
		int result=0;
		String res=null;
		try {
			result= hotelservice.updateReservationCancle(reservation_id);
			System.out.println(result);
			res =hotelservice.selectReservationsbyuids(user_id).get(0).getConfirm();
			System.out.println(res);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"result\":\""+res+"\"}"; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel",method=RequestMethod.POST)
	public ArrayList<HotelPostDTO> hotellist(String page){ 
		int new_page= (Integer.parseInt(page)-1)*15;
		System.out.println(page);
		ArrayList<HotelPostDTO> hotel_list=null;
		try {
		hotel_list=hotelservice.selectHotelpagelist(new_page);
		hotel_list.get(0).setPage(Integer.parseInt( page));
		System.out.println(hotel_list.get(0).getPage());
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return hotel_list; 
	}
	
	@RequestMapping("/hotel/{id}")
	public ModelAndView hoteldetail(
			@PathVariable(required=false)String id,HttpSession session, HttpServletResponse response){ 
		hoteldetailidcheker(response, id);

		ArrayList<HotelPostDTO> hdto = hotelservice.selectHotelbyhids(id);
		String business_id =hdto.get(0).getBusiness_id();
		String hotel_name =hdto.get(0).getHotel_name();
		String hotel_phone =hdto.get(0).getHotel_phone();
		String hotel_detail =hdto.get(0).getHotel_detail_account();
		String hotel_category =hdto.get(0).getHotel_category();
		String hotel_address =hdto.get(0).getHotel_address1()+" "+hdto.get(0).getHotel_address2();
		String hotel_animal =hdto.get(0).getHotel_animal()==1? "가능":"불가능";
		String[] convenience = hdto.get(0).getHotel_convenience().split(",");
		String hotel_rule=hdto.get(0).getHotel_rule();
		ModelAndView mv= new ModelAndView();
		JsonNode address= mapservice.get(hotel_address);

		String x=address.get("addresses").get(0).get("x").toPrettyString();
		String y=address.get("addresses").get(0).get("y").toPrettyString();
		x = x.replaceAll("\"", "");
		y = y.replaceAll("\"", "");
		ArrayList<HotelceoDTO> hcdtos= hotelservice.selectHotelceobyhids(business_id);
		String profile_picture =hcdtos.get(0).getProfile_picture();
		String profile_text =hcdtos.get(0).getProfile_text();
		SimpleDateFormat sdf1=new SimpleDateFormat("YYYY-MM-dd");
		Date date= new Date();
		String today= sdf1.format(date);
		Calendar cal=null;

		Date date2= new Date ( date.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
		
		String tomorrow= sdf1.format(date2);
		mv.addObject("today", today);
		mv.addObject("tomorrow", tomorrow);
		mv.addObject("business_id", business_id);
		mv.addObject("profile_picture", profile_picture);
		mv.addObject("profile_text", profile_text);
		mv.addObject("hotel_phone", hotel_phone);
		mv.addObject("hotel_category", hotel_category);
		mv.addObject("hotel_address", hotel_address);
		mv.addObject("hotel_animal", hotel_animal);
		mv.addObject("convenience", convenience);
		mv.addObject("hotel_rule", hotel_rule);
		mv.addObject("hoteldetail",hotel_detail);
		mv.addObject("title", hotel_name); 
		mv.addObject("x", x); 
		mv.addObject("y", y); 
		mv.setViewName("/hotel/hotels");
		return mv; 
	
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getAddress",method = RequestMethod.POST )
	public JsonNode hoteldetail2(HotelPostDTO dto){ 
		JsonNode address= mapservice.get("서울시 송파구 방이동 159-13");
		
		return address; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getpictures",method = RequestMethod.POST )
	public String[] hotelpictures(String hotelId){ 
		ArrayList<HotelPictureDTO> hpdto = hotelservice.selectHotelPicturebyhids(hotelId);
		String[] picurls= new String[hpdto.size()];
		for (int i = 0; i < hpdto.size(); i++) {
			picurls[i] = hpdto.get(i).getPicture_path();
		}
		return picurls; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getconvenience",method = RequestMethod.POST )
	public String[] hotelconvenince(String hotelId){ 
		ArrayList<HotelPostDTO> hdto = hotelservice.selectHotelbyhids(hotelId);
		String[] convenience = hdto.get(0).getHotel_convenience().split(",");
		for (int i = 0; i < convenience.length; i++) {
			System.out.println(convenience[i]);
		}
		return convenience; 
	}
	
	@ResponseBody
	@RequestMapping(value="/hotel/gettoday",method = RequestMethod.POST )
	public String today( 
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")String date,
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")String endday){ 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Date enddate=null;
		String end=null;
		try {
		Date today= new Date();
		Date date1 = sdf.parse(date);
		enddate= sdf.parse(endday);
		end=sdf.format(enddate);
//		date=sdf.format( today);
		if(date1.before(today)) {
			date=sdf.format( today);
			Date endd=  new Date ( today.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
			end= sdf.format(endd);
		}
		else if(enddate.before(date1)) {
			System.out.println(date1);
			System.out.println(enddate);
			Date endd=  new Date ( date1.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
			date=sdf.format( date1);
			end= sdf.format(endd);
			System.out.println(end);
		}
		 
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return "{\"date\":\""+date+"\",\"enddate\":\""+end+"\"}"; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/gettomorrow",method = RequestMethod.POST )
	public String today1( 
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")String date,
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")String startday){ 
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(date);
		
		try {
			Date date1 = sdf.parse(date);
			Date startdate= sdf.parse(startday);
			Date tomorrow= new Date ( startdate.getTime ( ) + (long) ( 1000 * 60 * 60 * 24 ) );
			if(startdate.before(date1)) {
				System.out.println(startdate.before(date1));
				date=sdf.format(date1);
			}
			if(date1.before(startdate)) {
				date=sdf.format( tomorrow);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return "{\"date\":\""+date+"\"}"; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getroomdata",method = RequestMethod.POST )
	public ArrayList<HotelRoomDTO>hotelroomdata(String hotelId){ 
		ArrayList<HotelRoomDTO> hrdtos= hotelservice.selectHotelRoombyhids(hotelId);
		System.out.println(	hrdtos.get(0));
	
		
		return hrdtos; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/getpay",method = RequestMethod.POST )
	public String hotelpay( HttpServletResponse response,
			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
			HotelReservationDTO dto, HttpSession session){ 
		String login_id= (String)session.getAttribute("userId");
		try {
		if(login_id==null) {
			return "{\"pay\": 0 }"; 
		}
		}catch (Exception e) {}
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date now_date=	new Date();
		String now= sdf.format(now_date);
		System.out.println(now);
		dto.setUser_id(login_id);
		dto.setRegist_time(now);
		System.out.println(dto.getHotel_name());
		System.out.println(dto.getHotel_id());
		System.out.println(dto.getBusiness_id());
		System.out.println(dto.getUser_id());
		System.out.println(dto.getStart_date());
		System.out.println(dto.getEnd_date());
		System.out.println(dto.getPayment());
		String s="1";
		try {
		System.out.println(hotelservice.postReservation(dto));
		}catch (Exception e) {
			e.printStackTrace();
		}			
		
		return "{\"pay\":"+s+"}"; 
	}
//	@ResponseBody
//	@RequestMapping(value="/hotel/getpay",method = RequestMethod.POST )
//	public String hotelpay(
//			@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
//			HotelReservationDTO dto, HttpSession session){ 
//		String login_id= (String)session.getAttribute("loginid");
//		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
//		String now=sdf.format(new Date());
//		dto.setUser_id(login_id);
//		dto.setRegist_time(now);
//		System.out.println(dto.getHotel_name());
//		System.out.println(dto.getHotel_id());
//		System.out.println(dto.getBusiness_id());
//		System.out.println(dto.getUser_id());
//		System.out.println(dto.getStart_date());
//		System.out.println(dto.getEnd_date());
//		System.out.println(dto.getPayment());
//		String s="";
//		try {
//		System.out.println(hotelservice.postReservation(dto));
//		}catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "{\"pay\":"+s+"}"; 
//	}
	
	

	@RequestMapping(value="/hotel/manage", method= RequestMethod.GET)
	public ModelAndView hotelmanage( 
			@RequestParam(value = "page", required = false, defaultValue = "1")int page,HttpSession session, HttpServletResponse response ){
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		int abd=businesscheker(loginid, session, response);
		if(abd==0) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사업자등록 후 이용 바랍니다.'); location.href='/hotel/manage/agree';</script>");
				out.flush();
			}catch (Exception e) {}
			
		}else {}
	
		ModelAndView mv= new ModelAndView(); 		
		HotelPostDTO dto= new HotelPostDTO();
		dto.setBusiness_id(loginid);
		dto.setPage(page);
		ArrayList<HotelPostDTO> list = hotelservice.selectHotelManageList(dto);

		mv.addObject("list", list);
		mv.setViewName("/hotel/manage");
		return mv; 
		
	}	
	
	@ResponseBody
	@RequestMapping(value="/hotel/manage", method= RequestMethod.POST)
	public ArrayList< hotelmanagelistDTO> hotelmanagelist(HttpSession session, HotelPostDTO dto){ 
		System.out.println("hotel/manage  -  post요청");
		String loginid = (String)session.getAttribute("userId");
		dto.setBusiness_id(loginid);
		ArrayList<HotelPostDTO> hpdtos=hotelservice.selectHotelManageList(dto);
		ArrayList<hotelmanagelistDTO> hmdtos= new ArrayList<hotelmanagelistDTO>();
		for (int i = 0; i < hpdtos.size(); i++) {
			String hotelName=hpdtos.get(i).getHotel_name();
			String pic_url=hpdtos.get(i).getHotel_picture();
			System.out.println(pic_url);
			String contents=hpdtos.get(i).getHotel_address1()+" "+hpdtos.get(i).getHotel_address2();
			String location=contents;
			String hotel_id = hpdtos.get(i).getHotel_id();
			System.out.println(hotel_id);
			hotelmanagelistDTO hmdto= new hotelmanagelistDTO(hotelName, pic_url, contents, location,hotel_id);
			hmdtos.add(hmdto);
		}
		return hmdtos; 
		
	}	
	@RequestMapping(value="/hotel/manage/reservation", method= RequestMethod.GET)
	public ModelAndView hotelreservation( 
			@RequestParam(value = "page", required = false, defaultValue = "1")int page,HttpSession session, HttpServletResponse response ){
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		int abd=businesscheker(loginid, session, response);
		if(abd==0) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사업자등록 후 이용 바랍니다.'); location.href='/hotel/manage/agree';</script>");
				out.flush();
			}catch (Exception e) {}
			
		}else {}
		ModelAndView mv= new ModelAndView();
//		String loginid=(String)session.getAttribute("loginid");
//		ArrayList<HotelReservationDTO> hrdtos= hotelservice.selectReservationsbyuids(loginid);
//		System.out.println(hrdtos.get(0).getReservation_id());
//		mv.addObject("list", hrdtos);
		mv.setViewName("/hotel/manage/reservation");
		return mv; 
		
	}	
	@ResponseBody
	@RequestMapping(value="/hotel/manage/reservation",method=RequestMethod.POST)
	public ArrayList<HotelReservationDTO> managereservation(String user_id,HttpSession session){ 
		System.out.println("s");
		String loginid=(String)session.getAttribute("userId");
		ArrayList<HotelReservationDTO> hrdtos= hotelservice.selectReservationsbybids(loginid);

		return hrdtos; 
	}
	@RequestMapping("/hotel/manage/post")
	public ModelAndView add(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		businesscheker(loginid, session, response);
		ModelAndView mv= new ModelAndView();
		mv.addObject("id", session.getAttribute("userId"));
		System.out.println(session.getAttribute("userId"));
		mv.setViewName("/hotel/manage/post");
		return mv; 
	}
	
	@ResponseBody
	@RequestMapping(value="/hotel/manage/post", method=RequestMethod.POST)	
	public String post(HotelPostDTO dto, HttpSession session){
		System.out.println(dto.getBusiness_id());
		String loginid= (String)session.getAttribute("userId");
		if(loginid==null) {
			loginconsist(dto.getBusiness_id(), session);
		}
		System.out.println(loginid);
		int result=0;
		try {
			result=hotelservice.postHotel(dto);
			ArrayList<HotelPostDTO>  x=hotelservice.selectHotelid(dto);
			System.out.println(x.get(0).getHotel_id());
			System.out.println(dto.getHotel_room());
			String hotel_id =x.get(0).getHotel_id();
			JSONArray jarr;
			try {
				jarr = new JSONArray(dto.getHotel_room());
				for (int i = 0; i <jarr.length(); i++) {
					JSONObject tmp=(JSONObject)jarr.get(i);
					String room_name = (String)tmp.get("room_name");
					String room_bed_size = (String)tmp.get("room_bed_size");
					String room_bed_qty =  (String)tmp.get("room_bed_qty");
					int room_price = Integer.parseInt( (String)tmp.get("room_price"));
					String room_etc = (String)tmp.get("room_etc");
					HotelRoomDTO hrdto = new HotelRoomDTO(hotel_id,room_name, room_bed_size, room_bed_qty, room_price, room_etc);
					int hrres = hotelservice.postHotelRoom(hrdto);
					System.out.println(hrres);
					System.out.println(jarr.length());
				}
			} catch (NullPointerException e) {}
			JSONArray picarr = new JSONArray(dto.getHotel_picture());
			for (int i = 0; i <picarr.length(); i++) {
				JSONObject tmp=(JSONObject)picarr.get(i);
				String pathtmp = (String)tmp.get("path");
				System.out.println(pathtmp);
				String pathtmp2 = pathtmp.substring(18, pathtmp.length());
				System.out.println(pathtmp2);
				String path = pathtmp2.replaceAll("\\\\","/");
				System.out.println(path);
				HotelPictureDTO hpdto= new HotelPictureDTO(hotel_id,path);
				int hpres = hotelservice.postHotelPicture(hpdto);
				System.out.println(hpres);
			}
			JSONObject tmp=(JSONObject)picarr.get(picarr.length()-1);
			String pathtmp = (String)tmp.get("path");
			String pathtmp2 = pathtmp.substring(18, pathtmp.length());
			String path = pathtmp2.replaceAll("\\\\","/");
			System.out.println(path);
			dto.setHotel_picture(path);
			dto.setHotel_id(hotel_id);
			System.out.println(dto.getHotel_id());
			System.out.println(dto.getHotel_picture());
			int picture_update=hotelservice.updateHotelPicture(dto);
			System.out.println(picture_update);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result+""; 

	}
	
	@RequestMapping(value="/hotel/manage/edit/{id}", method=RequestMethod.GET)
	public ModelAndView edit(
			@PathVariable(required=false)Integer id, HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		businesscheker(loginid, session, response);
		ModelAndView mv= new ModelAndView();
		HotelPostDTO dto= new HotelPostDTO();
		dto.setHotel_id(id.toString());
		ArrayList<HotelPostDTO> dtos = hotelservice.selectHotelhid(dto);
		HotelPostDTO hpdto=dtos.get(0);
		String writer=hpdto.getBusiness_id();
		writercheker(writer, session, response);
		System.out.println(hpdto.toString());
		String[] sarr=(hpdto.getHotel_phone()).split("-");
		mv.addObject("hotelid",hpdto.getHotel_id());
		mv.addObject("hotel_name",hpdto.getHotel_name());
		mv.addObject("hotel_category",hpdto.getHotel_category());
		mv.addObject("hotel_address1",hpdto.getHotel_address1());
		mv.addObject("hotel_address2",hpdto.getHotel_address2());
		mv.addObject("hotel_phone1",sarr[0]);
		mv.addObject("hotel_phone2",sarr[1]);
		mv.addObject("hotel_phone3",sarr[2]);
		mv.addObject("hotel_animal",hpdto.getHotel_animal());
		mv.addObject("hotel_rule",hpdto.getHotel_rule());
		mv.addObject("hotel_detail_account",hpdto.getHotel_detail_account());
		mv.addObject("id", loginid);
		mv.setViewName("/hotel/manage/edit");
		return mv; 
	}
	
	@ResponseBody
	@RequestMapping(value="/hotel/manage/editpost" , method = RequestMethod.POST)
	public String editpost(HotelPostDTO dto, HttpSession session, HttpServletResponse response){ 
		System.out.println(dto.getBusiness_id());
		String loginid= (String)session.getAttribute("userId");
		String hotel_id=dto.getHotel_id();
		if(loginid==null) {
			loginconsist(dto.getBusiness_id(), session);
		}
		System.out.println(loginid);
		int result=0;
		try {
			//result=hotelservice.postHotel(dto);
			int  x=hotelservice.updateHotel(dto);
			System.out.println("수정1차성공");
			JSONArray jarr;
			int x2=hotelservice.deleteHotelROOM(dto);
			System.out.println("룸삭제성공");
			try {
				jarr = new JSONArray(dto.getHotel_room());
				for (int i = 0; i <jarr.length(); i++) {
					JSONObject tmp=(JSONObject)jarr.get(i);
					String room_name = (String)tmp.get("room_name");
					String room_bed_size = (String)tmp.get("room_bed_size");
					String room_bed_qty =  (String)tmp.get("room_bed_qty");
					int room_price = Integer.parseInt( (String)tmp.get("room_price"));
					String room_etc = (String)tmp.get("room_etc");
					HotelRoomDTO hrdto = new HotelRoomDTO(hotel_id, room_name, room_bed_size, room_bed_qty, room_price, room_etc);
					int hrres = hotelservice.postHotelRoom(hrdto);
					System.out.println(hrres);
					System.out.println(jarr.length());
				}
				System.out.println("룸수정성공");
			} catch (NullPointerException e) {}
				int x3= hotelservice.deleteHotelPicture(dto);
				System.out.println("호텔사진삭제성공");
			try {
			JSONArray picarr = new JSONArray(dto.getHotel_picture());
			for (int i = 0; i <picarr.length(); i++) {
				JSONObject tmp=(JSONObject)picarr.get(i);
				String pathtmp = (String)tmp.get("path");
				System.out.println(pathtmp);
				String pathtmp2 = pathtmp.substring(2, pathtmp.length());
				System.out.println(pathtmp2);
				String path = pathtmp2.replaceAll("\\\\","/");
				System.out.println(path);
				HotelPictureDTO hpdto= new HotelPictureDTO(hotel_id,path);
				int hpres = hotelservice.postHotelPicture(hpdto);
				System.out.println(hpres);
			}
			JSONObject tmp=(JSONObject)picarr.get(picarr.length()-1);
			String pathtmp = (String)tmp.get("path");
			String pathtmp2 = pathtmp.substring(2, pathtmp.length());
			String path = pathtmp2.replaceAll("\\\\","/");
			System.out.println(path);
			dto.setHotel_picture(path);
			dto.setHotel_id(hotel_id);
			System.out.println(dto.getHotel_id());
			System.out.println(dto.getHotel_picture());
			}catch (Exception e) {
				System.out.println("사진없음");
				dto.setHotel_picture("/images/barogo_logo1.png");
//				HotelPictureDTO hpdto= new HotelPictureDTO(hotel_id,"/images/noimage.png");
//				int hpres = hotelservice.postHotelPicture(hpdto);
			}finally {
				int picture_update=hotelservice.updateHotelPicture(dto);
				System.out.println(picture_update);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("수정성공");
		return result+""; 

	}
	@ResponseBody
	@RequestMapping(value="/hotel/manage/editinfor" , method = RequestMethod.POST)
	public HotelInforDTO editinfor(HotelPostDTO dto, HttpSession session, HttpServletResponse response){ 
		System.out.println("editinfor");
		ArrayList<HotelPostDTO> dtos = hotelservice.selectHotelhid(dto);
		HotelPostDTO hpdto=dtos.get(0);
		String hotel_category=hpdto.getHotel_category();
		int hotel_animal=hpdto.getHotel_animal();
		String[] hotel_convenience= hpdto.getHotel_convenience().split(",");
		ArrayList<HotelRoomDTO> rdtos = hotelservice.selectHotelRoombyhid(dto);
		ArrayList<HotelPictureDTO> pdtos = hotelservice.selectHotelPicturebyhid(dto);
		HotelInforDTO result= new HotelInforDTO(hotel_category,hotel_animal, hotel_convenience, rdtos, pdtos);
		return result; 
	}
	@RequestMapping("/hotel/manage/delete")
	public ModelAndView delete(@RequestParam(value = "page", required = false, defaultValue = "1")int page,HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
	//	businesscheker((String)session.getAttribute("loginid"), session, response);
		String loginid=(String)session.getAttribute("userId");
		int abd=businesscheker(loginid, session, response);
		if(abd==0) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사업자등록 후 이용 바랍니다.'); location.href='/hotel/manage/agree';</script>");
				out.flush();
			}catch (Exception e) {}
			
		}else {}
		ModelAndView mv= new ModelAndView();
		HotelPostDTO dto= new HotelPostDTO();
		dto.setBusiness_id(loginid);
		dto.setPage(page);
		ArrayList<HotelPostDTO> list = hotelservice.selectHotelManageList(dto);

		mv.addObject("list", list);
		mv.setViewName( "/hotel/manage/delete");
		return mv; 
	}
	@ResponseBody
	@RequestMapping(value = "/hotel/manage/delete",method = RequestMethod.POST )
	public String delete(String delete_id,HttpSession session, HttpServletResponse response){ 
		System.out.println(delete_id);
		String[] arr= delete_id.split(",");
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
			try {
			int x=hotelservice.deleteHotelPicturebyString(arr[i]);
			System.out.println("deleteHotelPicturebyString : "+ x);
			int x2=hotelservice.deleteHotelROOMbyString(arr[i]);
			System.out.println("deleteHotelRoombyString : "+x2);
			int x3=hotelservice.deleteHotel(arr[i]);
			System.out.println("deleteHotel : "+x3);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return "{\"success\":200}"; 
	}
	@RequestMapping("/hotel/manage/agree")
	public String agree(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		int b=businesscheker(loginid, session, response);
		if(b==1) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>location.href='/hotel/manage';</script>");
				out.flush();
			}catch (Exception e) {}
			
		}
//		int x= businesscheker(loginid, session, response);
//		if(x==1) {
//			try {
//			response.setContentType("text/html; charset=utf-8");
//			PrintWriter out = response.getWriter();
//			out.println("<script>location.href='/hotel/manage';</script>");
//			out.flush();
//			}catch (Exception e) {}
//		}
		
		return "/hotel/manage/agree"; 
	}
	@RequestMapping("/hotel/manage/joinceo")
	public ModelAndView joinceo1(HttpSession session, HttpServletResponse response){ 
		logincheker(session, response);
		String loginid=(String)session.getAttribute("userId");
		int x= businesscheker(loginid, session, response);
		if(x==1) {
			try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='/hotel/manage';</script>");
			out.flush();
			}catch (Exception e) {}
		}
		ModelAndView mv= new ModelAndView();
		mv.addObject("id", session.getAttribute("userId"));
		System.out.println(session.getAttribute("userId"));
		mv.setViewName("/hotel/manage/joinceo");
		return mv; 
	}
	@ResponseBody
	@RequestMapping(value="/hotel/manage/joinceo",method=RequestMethod.POST)
	public String joinceobtn(HotelceoDTO dto, HttpSession session, HttpServletResponse response){ 
		String pathtmp = (String)dto.getProfile_picture();
		System.out.println(pathtmp);
		String pathtmp2 = pathtmp.substring(2, pathtmp.length());
		System.out.println(pathtmp2);
		String path = pathtmp2.replaceAll("\\\\","/");
		dto.setProfile_picture(path);
		String pathtmp3 = (String)dto.getBusiness_registration();
		System.out.println(pathtmp3);
		String pathtmp4 = pathtmp3.substring(2, pathtmp3.length());
		System.out.println(pathtmp4);
		String path2 = pathtmp4.replaceAll("\\\\","/");
		dto.setBusiness_registration(path2);
		System.out.println(dto.toString());
		System.out.println(dto.getProfile_picture());
		System.out.println(dto.getProfile_text());
		int result=hotelservice.addceo(dto);
		return "{\"response\":\""+result+"\"}"; 
	}
	@RequestMapping("/hotel/manage/jusoPopup")
	public String jusoPopup(){ 
		return "jusoPopup"; 
	}

	
	 @ResponseBody
	 @RequestMapping(value="/hotel/manage/phonecert", method= RequestMethod.POST)
	 public MessageDTO sendmessage(MessageDTO dto){ 
		 MessageDTO result = new MessageDTO();
		 try {
		 System.out.println(dto.getPhone_number()); 
		 DecimalFormat df= new DecimalFormat("0000");
		 String randomNumber = df.format((int)(Math.random()*9999));
		 	result.setRandomNumber(randomNumber);
		 	mservice.sendMessage(dto.getPhone_number(), randomNumber);
		 }catch (Exception e) {
			 e.printStackTrace(); 
		 } 
		 return result;
	 }


	@RequestMapping("/hotellogin")
	public String sss2(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("userId", "example"  );
		return "hotellogin"; 
	}
	@RequestMapping("/hotellogin2")
	public String hotellogin(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("userId", "example2"  );
		return "hotellogin"; 
	}
	@RequestMapping("/hotellogin3")
	public String hotellogin3(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("userId", "example3"  );
		return "hotellogin"; 
	}
	@RequestMapping("/hotellogin4")
	public String hotellogin4(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("userId", "hotelKing"  );
		return "hotellogin"; 
	}
	@RequestMapping("/testjsp")
	public String testjsp(HttpSession session){ 
		session.setMaxInactiveInterval(1800);
		session.setAttribute("userId", "example3"  );
		return "boot"; 
	}

	private void logincheker(HttpSession session, HttpServletResponse response){
		if(session.getAttribute("userId")==null) {
			try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
			out.flush();
			}catch (Exception e) {}
			
		}else {
			session.setAttribute("userId", session.getAttribute("userId"));
		}
	}
	private int businesscheker(String business_id,HttpSession session, HttpServletResponse response){
		int check= hotelservice.isBusinessId(business_id);
		if(check==0) {
			return 0;
			
		}else {return 1;}
	}
	private int addbusinessdeny(int checkResult,HttpSession session, HttpServletResponse response){
		if(checkResult==0) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('사업자등록 후 이용 바랍니다.'); location.href='/hotel/manage/agree';</script>");
				out.flush();
			}catch (Exception e) {}
			return 0;
			
		}else {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>location.href='/hotel/manage';</script>");
				out.flush();
			}catch (Exception e) {}
			return 1;}
	}
	private void writercheker(String writer,HttpSession session, HttpServletResponse response){
		String loginid=(String)session.getAttribute("userId");
		if(!writer.equals(loginid)) {
			try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
			out.flush();
			}catch (Exception e) {}
		}
	}
	private void hoteldetailidcheker(HttpServletResponse response, String id) {
		if(id==null) {
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못된 접근입니다.'); location.href='/';</script>");
				out.flush();
			}catch(Exception e){}
			
		}
	}
	@ResponseBody
	@RequestMapping(value="/hotel/manage/getcount", method= RequestMethod.POST)
	public String hotelmanagelist(HttpSession session){ 
		System.out.println("hotel/manage/getcount  -  post요청");
		String loginid = (String)session.getAttribute("userId");
		HotelPostDTO dto = new HotelPostDTO();
		dto.setBusiness_id(loginid);
		int count = hotelservice.selectHotelcount(dto);
		return  "{\"count\":"+count+"}"; 
		
	}	
	@ResponseBody
	@RequestMapping(value="/loginconsist", method= RequestMethod.POST)
	public String loginconsist(String id,HttpSession session){ 
		session.setAttribute("userId", id);
		System.out.println("loginconsist:success");
		return "{\"result\":\"success\"}";
	}	

}


