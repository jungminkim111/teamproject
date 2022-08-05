package hotel;

import com.fasterxml.jackson.annotation.JsonFormat;

public class HotelReservationDTO {
	String reservation_id, hotel_id, business_id, user_id;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Asia/Seoul")
	String start_date,end_date;
	String confirm,payment,regist_time,hotel_name;

	public String getRegist_time() {
		return regist_time;
	}

	public void setRegist_time(String regist_time) {
		this.regist_time = regist_time;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(String reservation_id) {
		this.reservation_id = reservation_id;
	}

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

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public String getPayment() {
		return payment;
	}

	public void setPayment(String payment) {
		this.payment = payment;
	}




	@Override
	public String toString() {
		return "HotelReservationDTO [reservation_id=" + reservation_id + ", hotel_id=" + hotel_id + ", business_id="
				+ business_id + ", user_id=" + user_id + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", confirm=" + confirm + ", payment=" + payment + ", regist_time=" + regist_time + "]";
	}

	public HotelReservationDTO(String reservation_id, String hotel_id, String business_id, String user_id,
			String start_date, String end_date, String confirm, String payment, String regist_time) {
		super();
		this.reservation_id = reservation_id;
		this.hotel_id = hotel_id;
		this.business_id = business_id;
		this.user_id = user_id;
		this.start_date = start_date;
		this.end_date = end_date;
		this.confirm = confirm;
		this.payment = payment;
		this.regist_time = regist_time;
	}

	public HotelReservationDTO() {}

	public String getHotel_name() {
		return hotel_name;
	}

	public void setHotel_name(String hotel_name) {
		this.hotel_name = hotel_name;
	}


	
}
