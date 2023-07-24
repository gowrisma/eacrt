package com.user;

public class UserDTO {
	// FirstName, LastName, Email_id, Password
	private int id;
	private String name;
	private String email_id;
	private String password;

	public UserDTO() {
		super();
	}

	public UserDTO(int id, String name, String email_id, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email_id = email_id;
		this.password = password;
	}

	public UserDTO(String name, String email_id, String password) {
		super();
		this.name = name;
		this.email_id = email_id;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
