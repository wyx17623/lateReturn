package com.gxuwz.bean.vo;
/*
 * 临时对象用来存储显示student_list
 */
public class liststudent {
	String stuID;
	String stuName;
	String sex;
	String className;
	String dormName;
	String stuTel;
	String dormBuildingName;
	String bedID;
	String dormID;
	String address;
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getStuTel() {
		return stuTel;
	}
	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}
	public String getDormBuildingName() {
		return dormBuildingName;
	}
	public void setDormBuildingName(String dormBuildingName) {
		this.dormBuildingName = dormBuildingName;
	}
	public String getBedID() {
		return bedID;
	}
	public void setBedID(String bedID) {
		this.bedID = bedID;
	}
	public String getDormID() {
		return dormID;
	}
	public void setDormID(String dormID) {
		this.dormID = dormID;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public liststudent(String stuID, String stuName, String sex,
			String className, String dormName, String stuTel,
			String dormBuildingName, String bedID, String dormID, String address) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.sex = sex;
		this.className = className;
		this.dormName = dormName;
		this.stuTel = stuTel;
		this.dormBuildingName = dormBuildingName;
		this.bedID = bedID;
		this.dormID = dormID;
		this.address = address;
	}
	public liststudent() {
		super();
	}
	
}
