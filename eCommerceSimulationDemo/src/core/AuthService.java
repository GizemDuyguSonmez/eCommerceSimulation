package core;

public interface AuthService {

	void register(int id, String firStringstName,String lastName,String email, String password);
	void login(String email, String password);
	

}
