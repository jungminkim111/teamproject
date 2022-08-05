package market;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MarketadminController {
//	상품등록

	@Autowired
	@Qualifier("mybatisservice")
	MarketService service;
	@RequestMapping(value="/marketadmin1" ,method=RequestMethod.GET)
	public ModelAndView protable(String id,HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		List<MarketDTO> list = service.productlist(id);
		mv.addObject("list",list);
		MarketDTO marketadminlist = service.marketadminlist(id);
		
		if(marketadminlist != null) {
				
				mv.setViewName("marketadmin");
		
		}else {
			try {
			
			mv.setViewName("marketadinsuccess");
			response.setContentType("text/html; charset=UTF-8");
			 
			PrintWriter out = response.getWriter();
			 
			out.println("<script>alert('마켓관리자 회원이아닙니다'); location.href='main';</script>");
			 
			out.flush();
			}catch (Exception e) {}

		
		}
		return mv;
	}
	@RequestMapping("/marketmypage")
	public ModelAndView marketadmininsert(MarketDTO dto ) {
		//address , id , market 인수
		dto.setId("aaaa");
		dto.setMarket("롯데마트");
		dto.setAddress("서울시 영등포구 영등포로");
		service.insertmarketadmin(dto);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("marketadminsuccess");
		return mv;
	}
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
