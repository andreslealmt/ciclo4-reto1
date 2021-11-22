package com.restfull.app.pojos;

public class UserPojo {
	
	
	private String id = null;

	private String email;

	private String password;
	
	private String name = "NO DEFINIDO";
	
	
	// Setters and Getters

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
