package com.model;

/**
 * @author vshadmin
 *
 */
public class Details {
private String name;
private String gender;
private int contact;
private Login login;
private AddressLine Address;

public Details(Login l, AddressLine a) {
	this.login=l;
	this.Address=a;
}
public String getAddressLine() {
	return Address.getAddressLine();
}
public void setAddressLine(String addressLine) {
	Address.setAddressLine(addressLine);
}
public String getCity() {
	return Address.getCity();
}
public void setCity(String city) {
	Address.setCity(city);
}
public String getState() {
	return Address.getState();
}
public void setState(String state) {
	Address.setState(state);
}
public String getCountry() {
	return Address.getCountry();
}
public void setCountry(String country) {
	Address.setCountry(country);
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public int getContact() {
	return contact;
}
public void setContact(int contact) {
	this.contact = contact;
}
public Login getLogin() {
	return login;
}
public void setLogin(Login login) {
	this.login = login;
}
public String getEmail() {
	return login.getEmail();
}
public void setEmail(String email) {
	login.setEmail(email);
}
public String getPassword() {
	return login.getPassword();
}
public void setPassword(String password) {
	login.setPassword(password);
}
public AddressLine getAddress() {
	return Address;
}
public void setAddress(AddressLine address) {
	Address = address;
}


}


