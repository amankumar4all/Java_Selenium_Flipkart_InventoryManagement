package com.selenium.work;

public class Form {
		
	private String emailId;
	private String password;
	
	public Form(String emailId, String Password){
		this.emailId=emailId;
		this.password=password;
	}
	
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
