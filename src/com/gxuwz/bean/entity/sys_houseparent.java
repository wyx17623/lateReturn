package com.gxuwz.bean.entity;

public class sys_houseparent {
	private String houseparentID ;
	private String houseparentName ;
	private String sex ;
	private String houTel;
	private String dormBuildingID;
	public String getHouseparentID() {
		return houseparentID;
	}
	public void setHouseparentID(String houseparentID) {
		this.houseparentID = houseparentID;
	}
	public String getHouseparentName() {
		return houseparentName;
	}
	public void setHouseparentName(String houseparentName) {
		this.houseparentName = houseparentName;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getHouTel() {
		return houTel;
	}
	public void setHouTel(String houTel) {
		this.houTel = houTel;
	}
	public String getDormBuildingID() {
		return dormBuildingID;
	}
	public void setDormBuildingID(String dormBuildingID) {
		this.dormBuildingID = dormBuildingID;
	}
	public sys_houseparent(String houseparentID, String houseparentName,
			String sex, String houTel, String dormBuildingID) {
		super();
		this.houseparentID = houseparentID;
		this.houseparentName = houseparentName;
		this.sex = sex;
		this.houTel = houTel;
		this.dormBuildingID = dormBuildingID;
	}
	public sys_houseparent() {
		super();
	}
	
}
