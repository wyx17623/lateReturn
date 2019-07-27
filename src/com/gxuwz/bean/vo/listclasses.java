package com.gxuwz.bean.vo;

public class listclasses {
	String classID;
	String className;
	String grade;
	String depName;
	String teacherName;
	public listclasses(String classID, String className, String grade,
			String depName, String teacherName) {
		super();
		this.classID = classID;
		this.className = className;
		this.grade = grade;
		this.depName = depName;
		this.teacherName = teacherName;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public listclasses() {
		super();
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
	public void setClassName(String className) {
		this.className = className;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	

}
