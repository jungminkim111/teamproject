package market;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GeolocationController {
	@Autowired
	@Qualifier("mybatisservice")
	MarketService service;
	
	@GetMapping("geolocation")
	public ModelAndView marketlist() {
		System.out.println("컨트롤러1 ");
		List<MarketDTO> marketlistrepeat = service.marketlist();
	   ArrayList<MarketDTO> marketlist = new ArrayList<MarketDTO>();

		marketlist.add(marketlistrepeat.get(0));
	for(int i =1 ; i<marketlistrepeat.size();i++) {
	if(!marketlistrepeat.get(i).market.toString().equals( marketlistrepeat.get(i-1).market.toString())) {
		//1마켓이랑 0 마켓이랑 비교 후 같지않으면 marketlist에 추가
		marketlist.add(marketlistrepeat.get(i));//같으면추가됨 
			
			}
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("marketlist1",marketlist);
		mv.setViewName("geolocation");
		System.out.println("컨트롤러2 ");
		return mv;
		

		
		
	}
}
