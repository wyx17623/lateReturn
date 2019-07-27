package com.gxuwz.bean.vo;

public class listdorm {
 private String dormID;
 private String dormName;
 private String dormBuildingID;
public String getDormID() {
	return dormID;
}
public void setDormID(String dormID) {
	this.dormID = dormID;
}
public String getDormName() {
	return dormName;
}
public void setDormName(String dormName) {
	this.dormName = dormName;
}
public String getDormBuildingID() {
	return dormBuildingID;
}
public void setDormBuildingID(String dormBuildingID) {
	this.dormBuildingID = dormBuildingID;
}
public listdorm(String dormID, String dormName, String dormBuildingID) {
	super();
	this.dormID = dormID;
	this.dormName = dormName;
	this.dormBuildingID = dormBuildingID;
}
public listdorm() {
	super();
}
 
}
