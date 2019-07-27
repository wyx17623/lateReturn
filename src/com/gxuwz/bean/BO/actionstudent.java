package com.gxuwz.bean.BO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.liststudent;

/**
 * 
 * @author 时间：2019年6月11日下午10:11:25 Description:学生处理类
 */
public class actionstudent {
	String stuID;
	String stuName;
	String sex;
	String classID;
	String dormID;
	String stuTel;
	String address;
	String bedID;
	String dormBuildingID;

	public actionstudent(String stuID, String stuName, String sex,
			String classID, String dormID, String stuTel, String address,
			String bedID, String dormBuildingID) {
		super();
		this.stuID = stuID;
		this.stuName = stuName;
		this.sex = sex;
		this.classID = classID;
		this.dormID = dormID;
		this.stuTel = stuTel;
		this.address = address;
		this.bedID = bedID;
		this.dormBuildingID = dormBuildingID;
	}

	public String getDormBuildingID() {
		return dormBuildingID;
	}

	public void setDormBuildingID(String dormBuildingID) {
		this.dormBuildingID = dormBuildingID;
	}

	public String getDormID() {
		return dormID;
	}

	public void setDormID(String dormID) {
		this.dormID = dormID;
	}

	public String getBedID() {
		return bedID;
	}

	public void setBedID(String bedID) {
		this.bedID = bedID;
	}

	public actionstudent() {
	}

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

	public String getClassID() {
		return classID;
	}

	public void setClassID(String classID) {
		this.classID = classID;
	}

	public String getdormID() {
		return dormID;
	}

	public void setdormID(String dormID) {
		this.dormID = dormID;
	}

	public String getStuTel() {
		return stuTel;
	}

	public void setStuTel(String stuTel) {
		this.stuTel = stuTel;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	/*
	 * 系统管理员添加学生
	 */
	public void addstudent() throws Exception {

		Connection conn = database.getConn();
		String sql = "insert into sys_student(stuID,stuName,sex,classID,dormID,stuTel,address,dormBuildingID,bedID)values(?,?,?,?,?,?,?,?,?);";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, stuID);
		pstmt.setString(index++, stuName);
		pstmt.setString(index++, sex);
		pstmt.setString(index++, classID);
		pstmt.setString(index++, dormID);
		pstmt.setString(index++, stuTel);
		pstmt.setString(index++, address);
		pstmt.setString(index++, dormBuildingID);
		pstmt.setString(index, bedID);
		int count = pstmt.executeUpdate();
		database.close(pstmt, conn);

	}
/*
 * 系统管理员和学生个人的修改信息的方法
 */
	public void updatestudent() throws Exception {
		Connection conn = database.getConn();
		String sql = "update sys_student set stuName=?,sex=?,classID=?,dormID=?,stuTel=?,bedID=?,address=?,dormBuildingID=? where stuID=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, stuName);
		pstmt.setString(index++, sex);
		pstmt.setString(index++, classID);
		pstmt.setString(index++, dormID);
		pstmt.setString(index++, stuTel);
		pstmt.setString(index++, bedID);
		pstmt.setString(index++, address);
		pstmt.setString(index++, dormBuildingID);
		pstmt.setString(index, stuID);
		// 2.5 执行SQL并返回执行结果
		int count = pstmt.executeUpdate();
		// 2.6 关闭数据库连接资源
		database.close(pstmt, conn);
	}
/*
 * 系统管理员删除学生信息方法
 */
	public void removestudent(String stuID) throws Exception {
		Connection conn = database.getConn();
		String sql = "delete from sys_student where stuID=?";

		PreparedStatement pstmt = conn.prepareStatement(sql);

		int parameterIndex = 1;
		pstmt.setString(parameterIndex, stuID);

		int count = pstmt.executeUpdate();

		database.close(pstmt, conn);
	}
/*
 * 系统管理员查询学生信息的无参方法
 */
	public List<liststudent> liststudent() throws Exception {
		String stuID = null;
		return liststudent(stuID);
	}
	/*
	 * 系统管理员查询学生信息的有参方法（方法的重载）
	 */
	public List<liststudent> liststudent(String stuID) throws Exception {
		String sql = null;

		sql = "select  DISTINCT sys_student.stuID,className,stuName,sex,address,bedID,stuTel,sys_dorm.dormID,dormName,dormBuildingName "
				+"from sys_student LEFT JOIN  sys_classes on sys_student.classID=sys_classes.classID  LEFT JOIN sys_dorm on sys_dorm.dormID=sys_student.dormID "
				+"LEFT JOIN sys_dormbuilding  ON sys_dorm.dormBuildingID=sys_dormbuilding.dormBuildingID";

		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);

		// PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
		ResultSet rs = pstmt.executeQuery();
		// 定义int序号变量

		List<liststudent> ls = new ArrayList<liststudent>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			stuName = rs.getString("stuName");
			sex = rs.getString("sex");
			String className = rs.getString("className");
			String dormName = rs.getString("dormName");
			      dormID = rs.getString("dormID");
			String dormBuildingName = rs.getString("dormBuildingName");
			stuTel = rs.getString("stuTel");
			String address = rs.getString("address");
			String bedID = rs.getString("bedID");
			liststudent sl = new liststudent( stuID,  stuName,  sex,
					 className,  dormName,  stuTel,
					 dormBuildingName,  bedID,  dormID,  address);
			ls.add(sl);

		}
		return ls;
	}
	/*
	 * 学生查询个人信息的方法
	 */
	public List<liststudent> liststudentpersonal(String stuID) throws Exception {
		String sql = null;

		sql = "select DISTINCT sys_student.stuID,className,stuName,sex,address,bedID,stuTel,sys_dorm.dormID,dormName,dormBuildingName "
				+ "from sys_student,sys_classes,sys_department,sys_dorm ,sys_dormbuilding "
				+ "where sys_dorm.dormID=sys_student.dormID and sys_dorm.dormBuildingID=sys_dormbuilding.dormBuildingID "
				+ "and  sys_student.classID=sys_classes.classID and sys_student.stuID=?";
		Connection conn = database.getConn();

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, stuID);
		// PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
		ResultSet rs = pstmt.executeQuery();


		List<liststudent> ls = new ArrayList<liststudent>();
		while (rs.next()) {
			stuID = rs.getString("stuID");
			stuName = rs.getString("stuName");
			sex = rs.getString("sex");
			String className = rs.getString("className");
			String dormName = rs.getString("dormName");
			      dormID = rs.getString("dormID");
			String dormBuildingName = rs.getString("dormBuildingName");
			stuTel = rs.getString("stuTel");
			String address = rs.getString("address");
			String bedID = rs.getString("bedID");
			liststudent sl = new liststudent( stuID,  stuName,  sex,
					 className,  dormName,  stuTel,
					 dormBuildingName,  bedID,  dormID,  address);
			ls.add(sl);

		}
		return ls;
	}
}
