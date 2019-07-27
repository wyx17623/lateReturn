package com.gxuwz.bean.BO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.gxuwz.base.database;
import com.gxuwz.bean.vo.listmanager;

public class actionmanager {
	String userID ;
	String fullname ;
	String telephone ;
	String password;
	public String getuserID() {
		return userID;
	}
	public void setuserID(String userID) {
		this.userID = userID;
	}
	public actionmanager() {
		super();
	}
	public actionmanager(String userID, String fullname, String telephone,
			String password) {
		super();
		this.userID = userID;
		this.fullname = fullname;
		this.telephone = telephone;
		this.password = password;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
/*
 * ϵͳ����Ա�޸ĸ�����Ϣ����
 */
	public void updatemanager() throws Exception{
		Connection conn = database.getConn();
		 String sql1="update sys_admin set fullname=?,telephone=?  where userID=?";	
		 String sql2="update sys_user set password=? where userID=?";	
		  PreparedStatement pstmt=conn.prepareStatement(sql1);
		 
		  int index=1;		  
		  pstmt.setString(index++, fullname);
		  pstmt.setString(index++, telephone);		
		  pstmt.setString(index++, userID);	
		  //2.5 ִ��SQL������ִ�н��
		  int count=pstmt.executeUpdate();
		  PreparedStatement pstmt1=conn.prepareStatement(sql2);
		 int index1=1;
		  pstmt1.setString(index1++, password);
		  pstmt1.setString(index1++, userID);	
		  pstmt1.executeUpdate();
		  //�ر����ݿ�������Դ
		 database.close(pstmt, conn);
	}
	/*
	 * ϵͳ����Ա�鿴������Ϣ
	 */
	public List<listmanager> listmanager() throws Exception{		    				   				   				             
				String sql="";
				
					sql="select sys_admin.userID, fullname,  telephone,  password from sys_user,sys_admin where sys_user.userID=sys_admin.userID and  type='0' ";
				Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//2.4:PrepareStatement���͵Ķ���pstmtִ��SQL��ѯ��䲢���ؽ��
				ResultSet rs = pstmt.executeQuery();
				
				List<listmanager> ls =new ArrayList<listmanager>();
				while (rs.next()) {
				 userID=rs.getString("userID");
				 fullname=rs.getString("fullname");		
				 telephone=rs.getString("telephone");
				
				String  password=rs.getString("password");
				listmanager sl =new listmanager(userID,  fullname, telephone,  password);
				ls.add(sl);
			
	}
				return ls;
	}
}
