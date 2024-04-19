package com.Bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class JobBean implements Serializable {
private int id;
private String title;
private String descriPtion;
private String catagory;
private String status;
private String location;
private String pDate;
public JobBean() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getDescriPtion() {
	return descriPtion;
}
public void setDescriPtion(String descriPtion) {
	this.descriPtion = descriPtion;
}
public String getCatagory() {
	return catagory;
}
public void setCatagory(String catagory) {
	this.catagory = catagory;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getpDate() {
	return pDate;
}
public void setpDate(String pDate) {
	this.pDate = pDate;
}
}
