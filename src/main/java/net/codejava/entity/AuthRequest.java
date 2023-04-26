package net.codejava.entity;

public class AuthRequest {
	private String username;
	private String password;

	// need default constructor for JSON Parsing
	public AuthRequest() {
	}

	public AuthRequest(String email, String password) {
		this.setUsername(email);
		this.setPassword(password);
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String email) {
		this.username = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
