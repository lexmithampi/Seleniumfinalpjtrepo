package utilities;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;

public class FakerUtility {

	Faker faker = new Faker();

	public String createRandomUsername() {
		return faker.name().username();
	}

	public String createRandomPassword() {
		return faker.internet().password();
	}

	public String createRandomFullname() {
		return faker.name().fullName();
	}

	public String createRandomAddress() {
		return faker.address().fullAddress();
	}

	public String createRandomEmail() {
		return faker.internet().emailAddress();
	}

	public PhoneNumber createRandomPhoneNumber() {
		return faker.phoneNumber();
	}

}
