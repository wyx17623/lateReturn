package com.gxuwz.bean.vo;

public class listmanager {
 private  String userID;
 private  String fullname;
 private  String telephone;
 private  String password;
public listmanager(String userID, String fullname, String telephone,
		String password) {
	super();
	this.userID = userID;
	this.fullname = fullname;
	this.telephone = telephone;
	this.password = password;
}
public String getuserID() {
	return userID;
}
public void setuserID(String userID) {
	this.userID = userID;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getTelephone() {
	return telephone;
}
public void setTelephone(String telephone) {
	this.telephone = telephone;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
}
