package com.gxuwz.bean.entity;

public class sys_dormbuilding {
  private String dormBuildingID;
  private String dormBuildingName;
public sys_dormbuilding() {
	super();
}
public sys_dormbuilding(String dormBuildingID, String dormBuildingName) {
	super();
	this.dormBuildingID = dormBuildingID;
	this.dormBuildingName = dormBuildingName;
}
public String getDormBuildingID() {
	return dormBuildingID;
}
public void setDormBuildingID(String dormBuildingID) {
	this.dormBuildingID = dormBuildingID;
}
public String getDormBuildingName() {
	return dormBuildingName;
}
public void setDormBuildingName(String dormBuildingName) {
	this.dormBuildingName = dormBuildingName;
}
}
