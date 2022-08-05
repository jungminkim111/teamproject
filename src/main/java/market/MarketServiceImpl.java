package market;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("mybatisservice")
public class MarketServiceImpl implements MarketService {
	

	@Autowired
	@Qualifier("mybatisdao")
	MarketDAO dao;
	
	
	
	public void updatemember(MarketDTO dto) {
		dao.updatemember(dto);
	};
	public int insertproduct(MarketDTO dto) {
		return dao.insertproduct(dto);
	};
	
	public List<MarketDTO> productlist (String id){
		List<MarketDTO> marketList = dao.productlist(id);
		
		for (MarketDTO marketDTO : marketList) {
			System.out.println(marketDTO);
		}
		return marketList;
	};
	
	public List<MarketDTO> marketproduct (String market){
		List<MarketDTO> marketproductList = dao.marketproduct(market);
		for (MarketDTO marketDTO : marketproductList) {
			System.out.println("marketproductList:"+marketDTO);
		}
		return marketproductList;
	}
	
	
	public MarketDTO nameregister(String name) {
		MarketDTO dto =dao.nameregister(name);
		return dto;
	};
	
	public void deletepro(String name) {
		dao.deletepro(name);
		
		
	}
	public void insertbasket(MarketDTO dto) {
		dao.insertbasket(dto);
	}
	public List<MarketDTO> basketlist (String id){
		List<MarketDTO> list = dao.basketlist(id);
		return list;
	}
	
	public void deletebasket(String name) {
	
		dao.deletebasket(name);
		
		System.out.println("장바구니에서" + name + "삭제완료");
	}
	
	public MarketDTO updateinfo(MarketDTO dto) {
		MarketDTO dto1 =  dao.updateinfo(dto);
		
		return dto1 ;
		
	}
	
	public List<MarketDTO> marketlist() {
		
		List<MarketDTO> marketlist = dao.marketlist();
		

			
		return marketlist;
		
	};
	//마켓관리자 등록
	public void insertmarketadmin(MarketDTO dto) {
		dao.insertmarketadmin(dto);
		
	};
	
	public MarketDTO marketadminlist(String id){
		MarketDTO marketadminlist = dao.marketadminlist(id);
		return marketadminlist;
	};
	
	
}
