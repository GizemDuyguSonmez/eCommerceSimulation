package business.concretes;

import business.abstracts.EmailService;
import entities.concretes.User;

public class EmailManager implements EmailService{

	@Override
	public void send(String message, User user) {
		System.out.println("Dogrulama e postasi " + user.getEmail() + " adli hesaba gonderilmistir.");
		
	}

	
}
