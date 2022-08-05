package market;

import java.util.List;

public interface MarketService {
	public int insertproduct(MarketDTO dto);
	public List<MarketDTO> productlist (String id);
	public List<MarketDTO> marketproduct (String market);
	public void deletepro(String name);
	public MarketDTO nameregister(String name);
	public void updatemember(MarketDTO dto);
	public void insertbasket(MarketDTO dto);
	public List<MarketDTO> basketlist (String id);
	public void deletebasket(String name);
	public MarketDTO updateinfo(MarketDTO dto);
	public List<MarketDTO> marketlist();
	public void insertmarketadmin(MarketDTO dto);
	public MarketDTO marketadminlist(String id);
}
