  package com.gxuwz.base;

import java.sql.*;
/**
 * 
 * @author 
 * 时间  2019年6月10日下午9:21:25
 * Description:数据库链接类
 */
public class database {
	public static  Connection getConn()throws Exception{
	    Connection conn=null;
	   try{
	         String db_url="jdbc:mysql://127.0.0.1:3306/latereturndb";
			   String db_user="root";
			   String db_pwd="123456";
			   Class.forName("com.mysql.cj.jdbc.Driver");
			  //DriverManager获得Connection 类型的连接对象conn
			    conn=DriverManager.getConnection(db_url, db_user, db_pwd);
			    return conn;
	    }catch(Exception e){
	      throw e;
	    }
	   
	   }
       //数据库关闭类
	  public static void close(ResultSet rs,Statement stmt,Connection conn)throws SQLException{
	    try{
	      if(rs!=null){//判断是否为空，如果为空调用关闭方法，会报空指针异常
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
