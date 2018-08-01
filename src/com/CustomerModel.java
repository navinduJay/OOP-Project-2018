package com;

public class CustomerModel implements RegisterBean {

	private String name,email,password,phone,address;

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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public boolean checkNullPass() {
	
		if(!(password.isEmpty())) {
			
			return true;
		}
		else {
			return false;
		}
	 }
	
	@Override
	public boolean checkNullUserID(){
	
		if(!(name.isEmpty())) {
			
			return true;
		}
		else {
			return false;
		}
	
	
	
 	}
	@Override
	public boolean validatePassword(){
		if(password.equals(password)){
			return true;
		}
		else{
			return false;
		}

	
	
	}

	@Override
	public boolean validateUsername(){
	if(name.equals(name)){
		return true;
	}
	else{
		return false;
	}
	}

}
