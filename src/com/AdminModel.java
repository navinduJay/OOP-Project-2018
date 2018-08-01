package com;

public class AdminModel implements AdminLoginModel {
	
	private String admin_username,admin_pass;

	public String getAdmin_username() {
		return admin_username;
	}

	public void setAdmin_username(String admin_username) {
		this.admin_username = admin_username;
	}

	public String getAdmin_pass() {
		return admin_pass;
	}

	public void setAdmin_pass(String admin_pass) {
		this.admin_pass = admin_pass;
	}

	@Override
	public boolean validatePassword(){
		if(admin_pass.equals("admin123")){
			return true;
		}
		else{
			return false;
		}
	
	}
	
	@Override
	public boolean validateUsername(){
		if(admin_username.equals("admin")){
			return true;
		}
		else{
			return false;
		}
	
	
	
	
	
}
	
	

}
