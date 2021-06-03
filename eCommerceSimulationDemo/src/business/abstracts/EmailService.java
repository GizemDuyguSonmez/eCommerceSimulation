package business.abstracts;

import entities.concretes.User;

public interface EmailService {

	void send(String message, User user);
}
