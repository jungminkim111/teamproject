package hotel;

import java.util.ArrayList;
import java.util.HashMap;

public class HotelPostDTO {

	String hotel_id,business_id,hotel_name, hotel_category, hotel_address1, hotel_address2, hotel_phone;
	int hotel_animal;
	String hotel_convenience;
	String hotel_room;
	String hotel_rule, hotel_detail_account;
	String hotel_picture;
	int page;





	

	@Override
	public String toString() {
		return "HotelPostDTO [hotel_id=" + hotel_id + ", business_id=" + business_id + ", hotel_name=" + hotel_name
				+ ", hotel_category=" + hotel_category + ", hotel_address1=" + hotel_address1 + ", hotel_address2="
				+ hotel_address2 + ", hotel_phone=" + hotel_phone + ", hotel_animal=" + hotel_animal
				+ ", hotel_convenience=" + hotel_convenience + ", hotel_room=" + hotel_room + ", hotel_rule="
				+ hotel_rule + ", hotel_detail_account=" + hotel_detail_account + ", hotel_picture=" + hotel_picture
				+ ", page=" + page + "]";
	}




	public int getPage() {
		return page;
	}




	public void setPage(int page) {
		page = (page-1)*3;
		this.page = page;
	}




	public String getHotel_picture() {
		return hotel_picture;
	}




	public void setHotel_picture(String hotel_picture) {
		this.hotel_picture = hotel_picture;
	}




	public String getHotel_room() {
		return hotel_room;
	}




	public void setHotel_room(String hotel_room) {
		this.hotel_room = hotel_room;
	}




	public HotelPostDTO() {}
	



	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getBusiness_id() {
		return business_id;
	}

	public void setBusiness_id(String business_id) {
		this.business_id = business_id;
	}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}

	public String getHotel_category() {
		return hotel_category;
	}

	public void setHotel_category(String hotel_category) {
		this.hotel_category = hotel_category;
	}

	public String getHotel_address1() {
		return hotel_address1;
	}

	public void setHotel_address1(String hotel_address1) {
		this.hotel_address1 = hotel_address1;
	}

	public String getHotel_address2() {
		return hotel_address2;
	}

	public void setHotel_address2(String hotel_address2) {
		this.hotel_address2 = hotel_address2;
	}

	public String getHotel_phone() {
		return hotel_phone;
	}

	public void setHotel_phone(String hotel_phone) {
		this.hotel_phone = hotel_phone;
	}

	public int getHotel_animal() {
		return hotel_animal;
	}

	public void setHotel_animal(int hotel_animal) {
		this.hotel_animal = hotel_animal;
	}

	public String getHotel_convenience() {
		return hotel_convenience;
	}

	public void setHotel_convenience(String hotel_convenience) {
		this.hotel_convenience = hotel_convenience;
	}



	public String getHotel_rule() {
		return hotel_rule;
	}

	public void setHotel_rule(String hotel_rule) {
		this.hotel_rule = hotel_rule;
	}

	public String getHotel_detail_account() {
		return hotel_detail_account;
	}

	public void setHotel_detail_account(String hotel_detail_account) {
		this.hotel_detail_account = hotel_detail_account;
	}



	


}