package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.entity.sys_dormbuilding;

public class actiondormbuilding {
private String dormBuildingID;//����¥��
private String dormBuildingName;//����¥����
public String getdormBuilding() {
	return dormBuildingID;
}
public void setdormBuilding(String dormBuilding) {
	this.dormBuildingID = dormBuilding;
}
public String getdormBuildingName() {
	return dormBuildingName;
}
public void setdormBuildingName(String dormBuildingName) {
	this.dormBuildingName = dormBuildingName;
}
public actiondormbuilding(String dormBuilding, String dormBuildingName) {
	super();
	this.dormBuildingID = dormBuilding;
	this.dormBuildingName = dormBuildingName;
}
public actiondormbuilding() {
	super();
}
/*
 * ϵͳ����Ա��ѯ��������¥�ķ���
 */
public List<sys_dormbuilding> listdormBuilding () throws Exception{
    
String sql="select * from sys_dormbuilding";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();

List<sys_dormbuilding> ls =new ArrayList<sys_dormbuilding>();
while (rs.next()) {
dormBuildingID = rs.getString("dormBuildingID");
dormBuildingName = rs.getString("dormBuildingName");
sys_dormbuilding sl =new sys_dormbuilding(dormBuildingID,dormBuildingName);
ls.add(sl);

}
	  
	  return ls;
 }
/*
 * ϵͳ����Ա�����������¥�ķ���
 */
 public void  adddormBuilding () throws Exception{
     
	  String sql="insert into sys_dormbuilding(dormBuildingID,dormBuildingName) values(?,?)";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, dormBuildingID);
	   pstmt.setString(Index++, dormBuildingName);
	   pstmt.executeUpdate();
	
	  	  
	  	  
	    }
 /*
  * ϵͳ����Ա�޸���������¥�ķ���
  */
public void  updatedormBuilding () throws Exception{
     
	  String sql="update sys_dormbuilding set dormBuildingName=? where dormBuildingID=?";

	  Connection conn = database.getConn();

	  PreparedStatement pstmt = conn.prepareStatement(sql);
	  int Index=1;
	   pstmt.setString(Index++, dormBuildingName);
	   pstmt.setString(Index++, dormBuildingID);
	   pstmt.executeUpdate();
	
	  	  
	  	  
	    }
/*
 * ϵͳ����Աɾ������¥�ķ���
 */
public void removedormBuilding(String dormBuildingID) throws Exception{
	Connection conn = database.getConn();
	  String sql="delete from sys_dormbuilding where dormBuildingID=?";
	  
	   PreparedStatement pstmt=conn.prepareStatement(sql);
	  
	   int parameterIndex=1;
	   pstmt.setString(parameterIndex, dormBuildingID);
	  
	   int count=pstmt.executeUpdate();
	
	    database.close(pstmt, conn);
}
}
