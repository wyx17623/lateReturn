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
 * ϵͳ����Ա��ӽ�ʦ�ķ���
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
		
		
		  //ִ��SQL������ִ�н��
		  int count=pstmt.executeUpdate();
		  // �ر����ݿ�������Դ
		 database.close(pstmt, conn);
		
	}
	/*
	 * ϵͳ����Ա�޸Ľ�ʦ�ķ���
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
		  // ִ��SQL������ִ�н��
		  int count=pstmt.executeUpdate();
		  // �ر����ݿ�������Դ
		 database.close(pstmt, conn);
	}
	/*
	 * ϵͳ����Աɾ����ʦ�ķ���
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
	 * ϵͳ����Ա��ѯ��ʦ��Ϣ����
	 */
	public List<listteacher> listteacher() throws Exception{
		             
				String sql=null;
				
					sql="select teacherID, teacherName, sex, teaTel "
							+ "from sys_teacher "
							+ "where 1=1 ";
                Connection conn = database.getConn();
				
				PreparedStatement pstmt = conn.prepareStatement(sql);
				
				//2.4:PrepareStatement���͵Ķ���pstmtִ��SQL��ѯ��䲢���ؽ��
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
	//��ʦ��ѯ������Ϣ�ķ���
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
