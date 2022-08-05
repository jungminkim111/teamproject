package hotel;

public class HotelPictureDTO {
	
	String hotel_id,picture_id,picture_path;

	public String getHotel_id() {
		return hotel_id;
	}

	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}

	public String getPicture_id() {
		return picture_id;
	}

	public void setPicture_id(String picture_id) {
		this.picture_id = picture_id;
	}

	public String getPicture_path() {
		return picture_path;
	}

	public void setPicture_path(String picture_path) {
		this.picture_path = picture_path;
	}

	public HotelPictureDTO() {}
	public HotelPictureDTO(String hotel_id, String picture_path) {
		this.hotel_id = hotel_id;
		this.picture_path = picture_path;
	}
	public HotelPictureDTO(String hotel_id, String picture_id, String picture_path) {
		this.hotel_id = hotel_id;
		this.picture_id = picture_id;
		this.picture_path = picture_path;
	}

	@Override
	public String toString() {
		return "HotelPictureDTO [hotel_id=" + hotel_id + ", picture_id=" + picture_id + ", picture_path=" + picture_path
				+ "]";
	}
	
}
