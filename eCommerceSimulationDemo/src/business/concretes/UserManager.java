package business.concretes;

import java.util.List;

import business.abstracts.UserService;
import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}
	
	@Override
	public void add(User user) {
		this.userDao.add(user);
		
	}
	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

	@Override
	public void update(User user) {
	   this.userDao.update(user);
		
	}

	@Override
	public List<User> getAll() {
		return this.userDao.getAll();
	}

	@Override
	public User get(int id) {
		return this.userDao.get(id);
	}


	@Override
	public User getByEmail(String email) {
		return this.userDao.getByEmail(email);
	}


	@Override
	public User getByEmailAndPassword(String email, String password) {
		return this.userDao.getByEmailAndPassword(email, password);
	}

	@Override
	public void verifyUser(int id) {
		User user = userDao.get(id);
		user.setVerified(true);
		System.out.println("Kullanici basariyla dogrulandi.");
		
	}

}
