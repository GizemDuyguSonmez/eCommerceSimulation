package business.concretes;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import business.abstracts.UserValidationService;
import entities.concretes.User;

public class UserValidationManager implements UserValidationService {

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = 
		    Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	
	@Override
	public boolean validate(User user) {
		return (checkFirstName(user.getFirstName()) &&
				checkLastName(user.getLastName()) &&
				checkEmail(user.getEmail()) &&
				checkPassword(user.getPassword()));
			
	}
	private boolean checkPassword(String password) {
		return password.length() > 6;
	}
	private boolean checkFirstName(String firstName) {
		return firstName.length() > 2;
	}
	private boolean checkLastName (String lastName) {
		return lastName.length() > 2;
	}
	private boolean checkEmail(String email) {
		 Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
	        return matcher.find();
	}
	
}
