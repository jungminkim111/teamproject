package market;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MarketAjaxController {
	@Autowired
	@Qualifier("mybatisservice")
	MarketService service;
	@PostMapping("basket")
	public List<MarketDTO> basket(MarketDTO dto){
		dto.setId("aaaa");
		dto.setMarket("하나로마트");
		service.insertbasket(dto);
		List<MarketDTO> list = service.basketlist(dto.getId());
		
		return list;
	}
	
	@PostMapping("deletebasket")	
	public List<MarketDTO> deletebasket(String[] name){
		MarketDTO dto =new MarketDTO();
		dto.setId("aaaa");
		for(int i =0 ; i<name.length;i++)
		{
			service.deletebasket(name[i]);
		}
		
		List<MarketDTO> list = service.basketlist(dto.getId());
		
		return list;
	}
	@PostMapping("changeoption")
	public List<MarketDTO> changeoption(MarketDTO dto){
		List<MarketDTO> changelist =  service.marketproduct(dto.market);
		
		return changelist;
	}
}
