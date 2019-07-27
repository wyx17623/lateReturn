package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listteacher;

public class actionteacher {

	String teacherID ;
	String teacherName ;
	String sex ;
	String teaTel;
	
	public actionteacher() {
	
	}
	public actionteacher(String teacherID, String teacherName, String sex,
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
/*
 * 系统管理员添加教师的方法
 */
	public void addteacher() throws Exception{
		
		Connection conn = database.getConn();
		  String sql="insert into sys_teacher(teacherID, teacherName,sex,teaTel)values(?,?,?,?)";
			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;
		  pstmt.setString(index++, teacherID);			  
		  pstmt.setString(index++, teacherName);
		  pstmt.setString(index++, sex);
		  pstmt.setString(index++, teaTel);
		
		
		  //执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  // 关闭数据库连接资源
		 database.close(pstmt, conn);
		
	}
	/*
	 * 系统管理员修改教师的方法
	 */
	public void updateteacher() throws Exception{
		Connection conn = database.getConn();
		 String sql="update sys_teacher set teacherName=?,sex=?,teaTel=?  where teacherID=?";			
		  PreparedStatement pstmt=conn.prepareStatement(sql);
		  int index=1;		  
		  pstmt.setString(index++, teacherName);
		  pstmt.setString(index++, sex);
		  pstmt.setString(index++, teaTel);	
		  pstmt.setString(index++, teacherID);	
		  // 执行SQL并返回执行结果
		  int count=pstmt.executeUpdate();
		  // 关闭数据库连接资源
		 database.close(pstmt, conn);
	}
	/*
	 * 系统管理员删除教师的方法
	 */
	public void removeteacher(String teacherID) throws Exception{
		Connection conn = database.getConn();
		  String sql="delete from sys_teacher where teacherID=?";
		  
		   PreparedStatement pstmt=conn.prepareStatement(sql);
		  
		   int parameterIndex=1;
		   pstmt.setString(parameterIndex, teacherID);
		  
		   int count=pstmt.executeUpdate();
		
		    database.close(pstmt, conn);
	}
	/*
	 * 系统管理员查询教师信息方法
	 */
	public List<listteacher> listteacher() throws Exception{
		             
				String sql=null;
				
					sql="select teacherID, teacherName, sex, teaTel "
							+ "from sys_teacher "
							+ "where 1=1 ";
                Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//2.4:PrepareStatement类型的对象pstmt执行SQL查询语句并返回结果
				ResultSet rs = pstmt.executeQuery();
				
				List<listteacher> ls =new ArrayList<listteacher>();
				while (rs.next()) {
				 teacherID=rs.getString("teacherID");
				 teacherName=rs.getString("teacherName");		
				 sex=rs.getString("sex");
				teaTel=rs.getString("teaTel");
				listteacher sl =new listteacher(teacherID,  teacherName,sex,teaTel);
				ls.add(sl);		
	}
				return ls;
	}
	//教师查询个人信息的方法
	public List<listteacher> listteacherpersonal(String teacherID ) throws Exception
	{  				   				   				             
				String sql="select teacherID, teacherName, sex, teaTel "
							+ "from sys_teacher "
							+ "where teacherID=? ";
				Connection conn = database.getConn();			
				PreparedStatement pstmt = conn.prepareStatement(sql);
				  pstmt.setString(1, teacherID);
				ResultSet rs = pstmt.executeQuery();
				List<listteacher> ls =new ArrayList<listteacher>();
				while (rs.next()) {
				 teacherID=rs.getString("teacherID");
				 teacherName=rs.getString("teacherName");		
				 sex=rs.getString("sex");
				teaTel=rs.getString("teaTel");
				listteacher sl =new listteacher(teacherID,  teacherName,sex,teaTel);
				ls.add(sl);
			
	}
				return ls;
	}
	
}
