package com.gxuwz.bean.entity;
/**
 * 
 * @author 
 * 时间  2019年6月10日下午11:22:21
 * Description:班级的实体类，
 */
public class sys_classes {
private String classID;
private String className;
private String  grade;
private String  depID;
private String teacherID;
public String getDepID() {
	return depID;
}
public void setDepID(String depID) {
	this.depID = depID;
}
public String getTeacherID() {
	return teacherID;
}
public void setTeacherID(String teacherID) {
	this.teacherID = teacherID;
}
public String getClassID() {
	return classID;
}
public void setClassID(String classID) {
	this.classID = classID;
}
public String getClassName() {
	return className;
}
public sys_classes(String classID, String className) {
	super();
	this.classID = classID;
	this.className = className;
}
public void setClassName(String className) {
	this.className = className;
}


public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}
public sys_classes(String classID, String className, String grade,
		String depID, String teacherID) {
	super();
	this.classID = classID;
	this.className = className;
	this.grade = grade;
	this.depID = depID;
	this.teacherID = teacherID;
}



}
