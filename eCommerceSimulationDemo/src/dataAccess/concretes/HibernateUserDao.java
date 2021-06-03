package dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import dataAccess.abstracts.UserDao;
import entities.concretes.User;

public class HibernateUserDao implements UserDao{
	
	List<User> users = new  ArrayList<User>() ;

	@Override
	public void add(User user) {
	    users.add(user);
		System.out.println(user.getFirstName() +" " + user.getLastName() + " adli kullanici bilgileri eklendi. ");
	}

	@Override
	public void delete(User user) {
		users.remove(user);
		System.out.println(user.getFirstName() +" " + user.getLastName() + " adli kullanici bilgileri silindi. ");
	}

	@Override
	public void update(User user) {
		System.out.println(user.getFirstName() +" " + user.getLastName() + " adli kullanici bilgileri guncellendi. ");
	}

	@Override
	public User get(int id) {
		for(User user: users) {
			if(user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByEmail(String email) {
		for(User user: users) {
			if(email.equals(user.getEmail())) {
				return user;
			}
		}
		return null;
	}

	@Override
	public User getByEmailAndPassword(String email, String password) {
		for(User user: users) {
			if(email.equals(user.getEmail()) && password.equals(user.getPassword())){
				return user;
			}
		}
		return null;
	}

	@Override
	public List<User> getAll() {
		return users;
	}
	
}
