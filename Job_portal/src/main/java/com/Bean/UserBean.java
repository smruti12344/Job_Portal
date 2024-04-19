package com.Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserBean implements Serializable {
private int id;
private String name;
private String email;
private String passWord;
private String qualification;
private String role;
public UserBean() {}
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
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPassWord() {
	return passWord;
}
public void setPassWord(String passWord) {
	this.passWord = passWord;
}
public String getQualification() {
	return qualification;
}
public void setQualification(String qualification) {
	this.qualification = qualification;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
}
