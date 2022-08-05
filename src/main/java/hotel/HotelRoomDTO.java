package hotel;

public class HotelRoomDTO {
	String hotel_id;
	int room_id;
	String room_name, room_bed_size; 
	String room_bed_qty;
	int room_price;
	String room_etc;
	public String getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(String hotel_id) {
		this.hotel_id = hotel_id;
	}
	public int getRoom_id() {
		return room_id;
	}
	public void setRoom_id(int room_id) {
		this.room_id = room_id;
	}
	public String getRoom_name() {
		return room_name;
	}
	public void setRoom_name(String room_name) {
		this.room_name = room_name;
	}
	public String getRoom_bed_size() {
		return room_bed_size;
	}
	public void setRoom_bed_size(String room_bed_size) {
		this.room_bed_size = room_bed_size;
	}
	public String getRoom_bed_qty() {
		return room_bed_qty;
	}
	public void setRoom_bed_qty(String room_bed_qty) {
		this.room_bed_qty = room_bed_qty;
	}
	public int getRoom_price() {
		return room_price;
	}
	public void setRoom_price(int room_price) {
		this.room_price = room_price;
	}
	public String getRoom_etc() {
		return room_etc;
	}
	public void setRoom_etc(String room_etc) {
		this.room_etc = room_etc;
	}
	@Override
	public String toString() {
		return "HotelRoomDTO [hotel_id=" + hotel_id + ", room_id=" + room_id + ", room_name=" + room_name
				+ ", room_bed_size=" + room_bed_size + ", room_bed_qty=" + room_bed_qty + ", room_price=" + room_price
				+ ", room_etc=" + room_etc + "]";
	}
	
	public HotelRoomDTO() {	}
	
	public HotelRoomDTO(String hotel_id, String room_name, String room_bed_size, String room_bed_qty, int room_price,
			String room_etc) {
		super();
		this.hotel_id = hotel_id;
		this.room_name = room_name;
		this.room_bed_size = room_bed_size;
		this.room_bed_qty = room_bed_qty;
		this.room_price = room_price;
		this.room_etc = room_etc;
	}
	public HotelRoomDTO(String hotel_id, String room_name, String room_bed_size, String room_bed_qty, int room_price) {
		super();
		this.hotel_id = hotel_id;
		this.room_name = room_name;
		this.room_bed_size = room_bed_size;
		this.room_bed_qty = room_bed_qty;
		this.room_price = room_price;
	}
	public HotelRoomDTO(String hotel_id, int room_id, String room_name, String room_bed_size, String room_bed_qty,
			int room_price, String room_etc) {
		this.hotel_id = hotel_id;
		this.room_id = room_id;
		this.room_name = room_name;
		this.room_bed_size = room_bed_size;
		this.room_bed_qty = room_bed_qty;
		this.room_price = room_price;
		this.room_etc = room_etc;
	}




}
