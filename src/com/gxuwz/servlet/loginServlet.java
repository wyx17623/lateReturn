package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

import com.gxuwz.base.database;
import com.gxuwz.base.base;
public class loginServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//接收参数
		String userID = request.getParameter("userID");
		 String password =request.getParameter("password");
		 String type =request.getParameter("type");
		 boolean flag=false;
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs =null;
		 
		 try{
		 //获得连接
		  	conn=database.getConn();
		  	String sql="select * from sys_user where userID=? and password=? and type=?";
		  	pstmt=conn.prepareStatement(sql);
		 //设置动态参数对应的值
		  	int index=1;
		  	pstmt.setString(index++, userID);
		  	pstmt.setString(index++, password);
		  	pstmt.setString(index++, type);
		 //执行查询
		  	rs=pstmt.executeQuery();
		  	//判断是否有下一条
		  	flag=rs.next();
		   }catch(SQLException e){
		     e.printStackTrace();
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 try {
			database.close(rs, pstmt, conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 //3:跳转目标页面
		  if(flag){
			//将用户编号绑定到session对象，方便取值
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			if(type.equals("0")){//type为零时跳转到管理员主页
				 base.process(request, response, "/manager_index.jsp");
			}
			else if(type.equals("1")){//typ为1时跳转到教师主页
		    base.process(request, response, "/teacher_index.jsp");
			}
			else if(type.equals("2")){//type为2时跳转到宿管员主页
			    base.process(request, response, "/houseparent_index.jsp");
				}
		else if(type.equals("3")){//type为4时跳转到学生主页
			    base.process(request, response, "/student_index.jsp");
				}//type为loginout跳转登陆页面
		  }else if(type.equals("loginout")){
			  //获取站点名，即：/项目名
			  String path = request.getContextPath();
			  //获取session
			  HttpSession session = request.getSession();
			  //注销session
			  session.invalidate();
			  //重定向到登陆页面
			  response.sendRedirect(path+"/login.jsp");
		  }
		  else{//其他情况（flag==flase)：返回登陆页面
		    base.process(request, response, "/login.jsp");
		  }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doGet(request,response);
	}

}
