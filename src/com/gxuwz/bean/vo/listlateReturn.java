package com.gxuwz.bean.vo;

public class listlateReturn {
    private String lateReturnID;
    private String stuID;
    private String stuName;
    private String dormID;
    private String dormName;
    private String bedID;
    private String lateReturnTime;
    private String lateReturnReason;
	public String getlateReturnID() {
		return lateReturnID;
	}
	public void setlateReturnID(String lateReturnID) {
		this.lateReturnID = lateReturnID;
	}
	public String getStuName() {
		return stuName;
	}
	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	public String getDormName() {
		return dormName;
	}
	public void setDormName(String dormName) {
		this.dormName = dormName;
	}
	public String getBedID() {
		return bedID;
	}
	public void setBedID(String bedID) {
		this.bedID = bedID;
	}
	public String getlateReturnTime() {
		return lateReturnTime;
	}
	public void setlateReturnTime(String lateReturnTime) {
		this.lateReturnTime = lateReturnTime;
	}
	public String getlateReturnReason() {
		return lateReturnReason;
	}
	public void setlateReturnReason(String lateReturnReason) {
		this.lateReturnReason = lateReturnReason;
	}
	
	public String getLateReturnID() {
		return lateReturnID;
	}
	public void setLateReturnID(String lateReturnID) {
		this.lateReturnID = lateReturnID;
	}
	public String getStuID() {
		return stuID;
	}
	public void setStuID(String stuID) {
		this.stuID = stuID;
	}
	public String getLateReturnTime() {
		return lateReturnTime;
	}
	public void setLateReturnTime(String lateReturnTime) {
		this.lateReturnTime = lateReturnTime;
	}
	public String getLateReturnReason() {
		return lateReturnReason;
	}
	public void setLateReturnReason(String lateReturnReason) {
		this.lateReturnReason = lateReturnReason;
	}
	
	public String getDormID() {
		return dormID;
	}
	public void setDormID(String dormID) {
		this.dormID = dormID;
	}
	
	public listlateReturn(String lateReturnID, String stuID, String stuName,
			String dormID, String dormName, String bedID,
			String lateReturnTime, String lateReturnReason) {
		super();
		this.lateReturnID = lateReturnID;
		this.stuID = stuID;
		this.stuName = stuName;
		this.dormID = dormID;
		this.dormName = dormName;
		this.bedID = bedID;
		this.lateReturnTime = lateReturnTime;
		this.lateReturnReason = lateReturnReason;
	}
	public listlateReturn() {
		super();
	}
    
	
	
}
