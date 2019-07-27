package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_department;

public class actiondepartment {
private String depID;//ѧԺID
private String depName;//ѧԺ����
public String getDepID() {
	return depID;
}
public void setDepID(String depID) {
	this.depID = depID;
}
public String getDepName() {
	return depName;
}
public void setDepName(String depName) {
	this.depName = depName;
}
public actiondepartment(String depID, String depName) {
	super();
	this.depID = depID;
	this.depName = depName;
}
public actiondepartment() {
	super();
}
/*
 * ϵͳ����Ա��ѯ����ѧԺ��Ϣ
 */
public List<sys_department> listdepartment () throws Exception{
    
String sql="select * from sys_department";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//����int��ű���
//����һ��List����
List<sys_department> ls =new ArrayList<sys_department>();
while (rs.next()) {
depID = rs.getString("depID");
depName = rs.getString("depName");
//����sys_department����
sys_department sl =new sys_department(depID,depName);
//��������ӵ�List
ls.add(sl);

}
	  
	  return ls;
 }
/*
 * ϵͳ����Ա���ѧԺ�ķ���
 */
 public void  adddepartment () throws Exception{
     
	  String sql="insert into sys_department(depID,depName) values(?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, depID);
	   pstmt.setString(Index++, depName);
	   pstmt.executeUpdate();
 
	    }
 /*
  * ϵͳ����Ա�޸�ѧԺ�ķ���
  */
public void  updatedepartment () throws Exception{
     
	  String sql="update sys_department set depName=?where depID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, depName);
	   pstmt.setString(Index++, depID);
	   pstmt.executeUpdate();
	  	  
	    }
/*
 * ϵͳ����Աɾ��ѧԺ����Ϣ
 */
public void removedepartment(String depID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_department where depID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, depID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
