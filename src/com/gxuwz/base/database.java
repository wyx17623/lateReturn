  package com.gxuwz.base;

import java.sql.*;
/**
 * 
 * @author 
 * ʱ��  2019��6��10������9:21:25
 * Description:���ݿ�������
 */
public class database {
	public static  Connection getConn()throws Exception{
	    Connection conn=null;
	   try{
	         String db_url="jdbc:mysql://127.0.0.1:3306/latereturndb";
			   String db_user="root";
			   String db_pwd="123456";
			   Class.forName("com.mysql.cj.jdbc.Driver");
			  //DriverManager���Connection ���͵����Ӷ���conn
			    conn=DriverManager.getConnection(db_url, db_user, db_pwd);
			    return conn;
	    }catch(Exception e){
	      throw e;
	    }
	   
	   }
       //���ݿ�ر���
	  public static void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
	    try{
	      if(rs!=null){//�ж��Ƿ�Ϊ�գ����Ϊ�յ��ùرշ������ᱨ��ָ���쳣
	     stmt.close();
	  }
	    if(stmt!=null){
	     stmt.close();
	  }
	   if(conn!=null){
	     conn.close();
	  }
	    }catch(SQLException e){
	      throw e;
	    }
	  }
	  
	   public static void close(Statement stmt,Connection conn)throws SQLException{
	       close(null, stmt, conn);
	   }
	   
	  public void close(ResultSet rs)throws SQLException{
	       close(rs, null, null);
	   }
	    public void close(Statement stmt)throws SQLException{
	       close(null, stmt, null);
	   }
	   public void close(Connection conn)throws SQLException{
	       close(null, null, conn);
	   }
}
