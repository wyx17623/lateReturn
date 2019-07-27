package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listdorm;

public class actiondorm {
  private String dormID;//宿舍ID
  private String dormName;//宿舍名称
  private String dormBuildingID;//宿舍楼ID
  
public actiondorm() {
	super();
}
public actiondorm(String dormID, String dormName, String dormBuildingID) {
	super();
	this.dormID = dormID;
	this.dormName = dormName;
	this.dormBuildingID = dormBuildingID;
}
public String getDormID() {
	return dormID;
}
public void setDormID(String dormID) {
	this.dormID = dormID;
}
public String getDormName() {
	return dormName;
}
public void setDormName(String dormName) {
	this.dormName = dormName;
}
public String getDormBuildingID() {
	return dormBuildingID;
}
public void setDormBuildingID(String dormBuildingID) {
	this.dormBuildingID = dormBuildingID;
}
/*
 * 系统管理员查询所有宿舍的信息
 */
public List<listdorm> listdorm () throws Exception{
    
String sql="select dormID,dormName,dormBuildingName from sys_dorm left join sys_dormBuilding "
		+ " on  sys_dorm.dormBuildingID=sys_dormBuilding.dormBuildingID";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//定义一个List
List<listdorm> ls =new ArrayList<listdorm>();
while (rs.next()) {
dormID = rs.getString("dormID");
dormName = rs.getString("dormName");
String dormBuildingName = rs.getString("dormBuildingName");
//创建一个listdorm链表
listdorm sl =new listdorm(dormID,dormName,dormBuildingName);
//将对象添加到List
ls.add(sl);

}
database.close(pstmt, conn);
	  return ls;
 }
/*
 * 系统管理员添加宿舍的方法
 */
 public void  adddorm () throws Exception{
     
	  String sql="insert into sys_dorm(dormID,dormName,dormBuildingID)values(?,?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	  pstmt.setString(Index++, dormID);
	  pstmt.setString(Index++, dormName);
	   pstmt.setString(Index++, dormBuildingID);
	   pstmt.executeUpdate();
	   database.close(pstmt, conn);
	  	  
	    }
 /*
  * 系统管理员修改宿舍信息的方法
  */
public void  updatedorm () throws Exception{
     
	  String sql="update sys_dorm set dormName=? ,dormBuildingID=? where dormID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, dormName);
	   pstmt.setString(Index++, dormBuildingID);
	   pstmt.setString(Index++, dormID);
	   pstmt.executeUpdate();
	  //定义int序号变量

	   database.close(pstmt, conn);
	  	  
	    }
/*
 * 系统管理员删除宿舍信息的方法
 */
public void removedorm(String dormID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_dorm where dormID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, dormID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
