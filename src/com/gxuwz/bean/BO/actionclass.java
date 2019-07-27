package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listclasses;

/**
 * 
 * @author 
 * 时间：2019年6月11日下午3:45:38
 * Description:班级增删改查处理类
 */
public class actionclass {
	private String classID ;//学号
	private String className ;//学生姓名
	private String grade ;//年级
	private String depID;//学院ID
	private String teacherID;//教师ID
	public String getDepID() {
		return depID;
	}
	public void setDepID(String depID) {
		this.depID = depID;
	}
	public String getTeacherID() {
		return teacherID;
	}
	public actionclass(String classID, String className, String grade,
			String depID, String teacherID) {
		super();
		this.classID = classID;
		this.className = className;
		this.grade = grade;
		this.depID = depID;
		this.teacherID = teacherID;
	}
	public void setTeacherID(String teacherID) {
		this.teacherID = teacherID;
	}
	public String getClassID() {
		return classID;
	}
	public actionclass() {
		super();
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
	/*
	 * 系统管理员查询所有班级信息
	 */
  public List<listclasses> listclasses () throws Exception{
		String sql = "select sys_classes.classID,className,grade,depName,teacherName "
				+ "from sys_classes LEFT JOIN sys_department on sys_classes.depID=sys_department.depID LEFT JOIN sys_teacher on "
				+ "sys_teacher.teacherID=sys_classes.teacherID";
//获取数据库链接
Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//定义一个List存储所有班级对象
List<listclasses> ls =new ArrayList<listclasses>();
while (rs.next()) {
classID=rs.getString("classID");
className=rs.getString("className");		
grade =rs.getString("grade");
String depName=rs.getString("depName");
String teacherName=rs.getString("teacherName");
//创建一个listclasses对象，
listclasses sl =new listclasses(classID, className,grade ,depName,teacherName);
//将对象加入到list中
ls.add(sl);

}
//关闭数据库连接
database.close(pstmt, conn);
	  return ls;
  }
  /*
   * 系统管理员添加班级的方法
   */
  public void  addclasses () throws Exception{
      
	  String sql="insert into sys_classes(classID,className,grade,depID,teacherID) values(?,?,?,?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, classID);
	   pstmt.setString(Index++, className); 
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, depID);
	   pstmt.setString(Index++, teacherID);
	   pstmt.executeUpdate();
	  //定义int序号变量

	   database.close(pstmt, conn);
	  	  
	    }
  /*
   * 系统管理员修改班级业务处理
   */
public void  updateclasses () throws Exception{
      
	  String sql="update sys_classes set className=?,grade=?,depID=? ,teacherID=? where classID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, className);
	   pstmt.setString(Index++, grade);
	   pstmt.setString(Index++, depID);
	   pstmt.setString(Index++, teacherID);
	   pstmt.setString(Index++, classID);
	   pstmt.executeUpdate();
	   database.close(pstmt, conn);
 
	    }
/*
 * 系统管理员删除班级业务处理
 */
public void removeclasses(String classID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_classes where classID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, classID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
