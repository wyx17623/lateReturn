package com.gxuwz.bean.vo;

public class listhouseparent {
	private String houseparentID ;
	private String houseparentName ;
	private String sex ;
	private String houTel;
	private String dormBuildingName;
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
	public String getDormBuildingName() {
		return dormBuildingName;
	}
	public void setDormBuildingName(String dormBuildingName) {
		this.dormBuildingName = dormBuildingName;
	}
	public listhouseparent(String houseparentID, String houseparentName,
			String sex, String houTel, String dormBuildingName) {
		super();
		this.houseparentID = houseparentID;
		this.houseparentName = houseparentName;
		this.sex = sex;
		this.houTel = houTel;
		this.dormBuildingName = dormBuildingName;
	}
	public listhouseparent() {
		super();
	}
	
	
}
