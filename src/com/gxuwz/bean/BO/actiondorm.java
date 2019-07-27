package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listdorm;

public class actiondorm {
  private String dormID;//����ID
  private String dormName;//��������
  private String dormBuildingID;//����¥ID
  
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
 * ϵͳ����Ա��ѯ�����������Ϣ
 */
public List<listdorm> listdorm () throws Exception{
    
String sql="select dormID,dormName,dormBuildingName from sys_dorm left join sys_dormBuilding "
		+ " on  sys_dorm.dormBuildingID=sys_dormBuilding.dormBuildingID";


Connection conn = database.getConn();

PreparedStatement pstmt = conn.prepareStatement(sql);

ResultSet rs = pstmt.executeQuery();
//����һ��List
List<listdorm> ls =new ArrayList<listdorm>();
while (rs.next()) {
dormID = rs.getString("dormID");
dormName = rs.getString("dormName");
String dormBuildingName = rs.getString("dormBuildingName");
//����һ��listdorm����
listdorm sl =new listdorm(dormID,dormName,dormBuildingName);
//��������ӵ�List
ls.add(sl);

}
database.close(pstmt, conn);
	  return ls;
 }
/*
 * ϵͳ����Ա�������ķ���
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
  * ϵͳ����Ա�޸�������Ϣ�ķ���
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
	  //����int��ű���

	   database.close(pstmt, conn);
	  	  
	    }
/*
 * ϵͳ����Աɾ��������Ϣ�ķ���
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
