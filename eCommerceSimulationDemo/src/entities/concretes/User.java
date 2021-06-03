package entities.concretes;

import entities.abstracts.Entity;

public class User implements Entity {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private int id;
	private boolean verified;
	
	public User(){
		
	}
	
	public User(int id, String firtName, String lastName, String email, String password, boolean verified) {
		super();
		setId(id);
		setFirstName(firtName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setVerified(verified);
	
	}
	

	public boolean isVerified() {
		return verified;
	}

	public void setVerified(boolean verified) {
		this.verified = verified;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
