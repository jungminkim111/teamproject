package market;

import java.util.List;

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
public class MybatisController {
//	상품등록

	@Autowired
	@Qualifier("mybatisservice")
	MarketService service;
	@RequestMapping(value="marketadmin" ,method=RequestMethod.GET)
	public ModelAndView protable(String id) {
		ModelAndView mv = new ModelAndView();
		List<MarketDTO> list = service.productlist(id);
		mv.addObject("list",list);
		mv.setViewName("marketadmin");
		return mv;
	}
	
	

	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
