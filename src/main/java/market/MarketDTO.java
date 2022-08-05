package market;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class MarketDTO {
	String id, market,explain1,name ,name1, address;
	String num,price,no;
	String imgname , state;
	MultipartFile img;
	
	public String getName1() {
		return name1;
	}


	public void setName1(String name1) {
		this.name1 = name1;
	}



	
	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	

	


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getImgname() {
		return imgname;
	}


	public void setImgname(String imgname) {
		this.imgname = imgname;
	}


	public String getNo() {
		return no;
	}


	public void setNo(String no) {
		this.no = no;
	}


	public MultipartFile getImg() {
		return img;
	}


	public void setImg(MultipartFile file1) {
		this.img = file1;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getMarket() {
		return market;
	}


	public void setMarket(String marketname) {
		this.market = marketname;
	}


	public String getExplain1() {
		return explain1;
	}


	public void setExplain1(String explain1) {
		this.explain1 = explain1;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getNum() {
		return num;
	}


	public void setNum(String num) {
		this.num = num;
	}


	public String getPrice() {
		return price;
	}


	public void setPrice(String price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "MarketDTO [id=" + id + ", marketname=" + market + ", explain1=" + explain1 + ", name=" + name
				+ ", num=" + num + ", price=" + price + "]";
	}


	
	
	
}
