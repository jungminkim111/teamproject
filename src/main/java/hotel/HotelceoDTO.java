package hotel;

public class HotelceoDTO {
String business_id,profile_picture,profile_text,business_registration;

public String getBusiness_id() {
	return business_id;
}

public void setBusiness_id(String business_id) {
	this.business_id = business_id;
}

public String getProfile_picture() {
	return profile_picture;
}

public void setProfile_picture(String profile_picture) {
	this.profile_picture = profile_picture;
}

public String getProfile_text() {
	return profile_text;
}

public void setProfile_text(String profile_text) {
	this.profile_text = profile_text;
}

public String getBusiness_registration() {
	return business_registration;
}

public void setBusiness_registration(String business_registration) {
	this.business_registration = business_registration;
}

public HotelceoDTO() {}
public HotelceoDTO(String business_id, String profile_picture, String profile_text, String business_registration) {
	this.business_id = business_id;
	this.profile_picture = profile_picture;
	this.profile_text = profile_text;
	this.business_registration = business_registration;
}

@Override
public String toString() {
	return "hotelceodto [business_id=" + business_id + ", profile_picture=" + profile_picture + ", profile_text="
			+ profile_text + ", business_registration=" + business_registration + "]";
}

}
