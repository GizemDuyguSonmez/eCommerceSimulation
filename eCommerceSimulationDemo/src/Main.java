import business.abstracts.UserService;
import business.concretes.AuthManager;
import business.concretes.EmailManager;
import business.concretes.UserManager;
import business.concretes.UserValidationManager;
import core.AuthService;
import core.GoogleAuthManagerAdapter;
import dataAccess.concretes.HibernateUserDao;

public class Main {

	public static void main(String[] args) {
				
				UserService userService  = new UserManager(new HibernateUserDao());
				
				AuthService authService = new AuthManager(userService, new UserValidationManager(), new EmailManager());
				
				authService.register(1, "Gizem Duygu", "Sönmez" ,"gizemduygu@hotmail.com", "***********");
			
				userService.verifyUser(1);
				authService.login("gizemduygu@hotmail.com", "***********");
				userService.verifyUser(1);
				
				AuthService googleAuthService = new GoogleAuthManagerAdapter();
				googleAuthService.register(1, "Gizem Duygu", "Sönmez" ,"gizemduygu@hotmail.com", "***********");
				googleAuthService.login("gizemduygu@hotmail.com", "*************");	
				
			}

	}

