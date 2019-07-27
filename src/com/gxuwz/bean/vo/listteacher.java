package com.gxuwz.bean.vo;

public class listteacher {
  private  String teacherID;
  private  String teacherName;
  private  String  sex;
  private  String teaTel;
public listteacher(String teacherID, String teacherName, String sex,
		String teaTel) {
	super();
	this.teacherID = teacherID;
	this.teacherName = teacherName;
	this.sex = sex;
	this.teaTel = teaTel;
	
}
public String getTeacherID() {
	return teacherID;
}
public void setTeacherID(String teacherID) {
	this.teacherID = teacherID;
}
public String getTeacherName() {
	return teacherName;
}
public void setTeacherName(String teacherName) {
	this.teacherName = teacherName;
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getTeaTel() {
	return teaTel;
}
public void setTeaTel(String teaTel) {
	this.teaTel = teaTel;
}

}
