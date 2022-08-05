package hotel;

public class MessageDTO {

	String phone_number, randomNumber;

	
	@Override
	public String toString() {
		return "MessageDTO [phone_number=" + phone_number + ", randomNumber=" + randomNumber + "]";
	}

	public MessageDTO() {}
	public MessageDTO(String phone_number, String randomNumber) {
		this.phone_number = phone_number;
		this.randomNumber = randomNumber;
	}

	public String getRandomNumber() {
		return randomNumber;
	}

	public void setRandomNumber(String randomNumber) {
		this.randomNumber = randomNumber;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
}
