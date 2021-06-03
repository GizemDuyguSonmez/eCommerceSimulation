package business.concretes;

import business.abstracts.EmailService;
import business.abstracts.UserService;
import business.abstracts.UserValidationService;
import core.AuthService;
import entities.concretes.User;

public class AuthManager implements AuthService{

	UserService userService;
	UserValidationService userValidationService;
	EmailService emailService;
	
	public AuthManager(UserService userService, UserValidationService userValidationService, EmailService emailService) {
		super();
		this.userService = userService;
		this.userValidationService = userValidationService;
		this.emailService = emailService;
	}
	
	@Override
	public void register (int id, String firstName, String lastName,String email, String password) {
		
		User user = new User(id, firstName,lastName,email,password, false);
		
		if (! userValidationService.validate(user)) {
			System.out.println("Gecersiz kullanici. T�m alanlari dogru girdiginize emin olun...");
			return;
		}
		
		System.out.println("Basariyla kayit olundu. Uyeliginizi dogrulamak icin mail adresinizi kontrol ediniz.");
		emailService.send("Deneme do�rulama mesaj�d�r. Do�rulamak i�in kodlama.io/dogrula?id=xyz&token=abc adresine gidin.", user);
		userService.add(user);
		
	}
	@Override
	public void login(String email, String password) {
		
		User user = userService.getByEmailAndPassword(email, password);
		
		if(user == null) {
			System.out.println("Giri� ba�ar�s�z. E-posta adresiniz veya �ifreniz yanl��.");
			return;
		}
		
		if (!checkIfUserVerified(user)) {
			System.out.println("Giri� ba�ar�s�z. �yeli�inizi do�rulamad�n�z.");
			return;
		}
		System.out.println("Giri� ba�ar�l�. Ho�geldiniz : " + user.getFirstName() + " " + user.getLastName());
	}
	
	
	private boolean checkIfUserVerified(User user) {
		return user.isVerified();
	}
	
}
