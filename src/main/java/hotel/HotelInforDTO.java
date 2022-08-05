package hotel;

import java.util.ArrayList;
import java.util.Arrays;

public class HotelInforDTO {
	String hotel_category;
	int hotel_animal;
	String[] hotel_convenience;
	ArrayList<HotelRoomDTO> hotel_room;
	ArrayList<HotelPictureDTO> hotel_picture;

	
	public HotelInforDTO() {}

	public int getHotel_animal() {
		return hotel_animal;
	}
	public void setHotel_animal(int hotel_animal) {
		this.hotel_animal = hotel_animal;
	}
	public String[] getHotel_convenience() {
		return hotel_convenience;
	}
	public void setHotel_convenience(String[] hotel_convenience) {
		this.hotel_convenience = hotel_convenience;
	}
	public ArrayList<HotelRoomDTO> getHotel_room() {
		return hotel_room;
	}
	public void setHotel_room(ArrayList<HotelRoomDTO> hotel_room) {
		this.hotel_room = hotel_room;
	}

	public ArrayList<HotelPictureDTO> getHotel_picture() {
		return hotel_picture;
	}

	public void setHotel_picture(ArrayList<HotelPictureDTO> hotel_picture) {
		this.hotel_picture = hotel_picture;
	}

	public String getHotel_category() {
		return hotel_category;
	}

	public void setHotel_category(String hotel_category) {
		this.hotel_category = hotel_category;
	}

	@Override
	public String toString() {
		return "HotelInforDTO [hotel_category=" + hotel_category + ", hotel_animal=" + hotel_animal
				+ ", hotel_convenience=" + Arrays.toString(hotel_convenience) + ", hotel_room=" + hotel_room
				+ ", hotel_picture=" + hotel_picture + "]";
	}

	public HotelInforDTO(String hotel_category, int hotel_animal, String[] hotel_convenience,
			ArrayList<HotelRoomDTO> hotel_room, ArrayList<HotelPictureDTO> hotel_picture) {
		super();
		this.hotel_category = hotel_category;
		this.hotel_animal = hotel_animal;
		this.hotel_convenience = hotel_convenience;
		this.hotel_room = hotel_room;
		this.hotel_picture = hotel_picture;
	}


	

}
