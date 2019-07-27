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
		//���ղ���
		String userID = request.getParameter("userID");
		 String password =request.getParameter("password");
		 String type =request.getParameter("type");
		 boolean flag=false;
		 Connection conn=null;
		 PreparedStatement pstmt=null;
		 ResultSet rs =null;
		 
		 try{
		 //�������
		  	conn=database.getConn();
		  	String sql="select * from sys_user where userID=? and password=? and type=?";
		  	pstmt=conn.prepareStatement(sql);
		 //���ö�̬������Ӧ��ֵ
		  	int index=1;
		  	pstmt.setString(index++, userID);
		  	pstmt.setString(index++, password);
		  	pstmt.setString(index++, type);
		 //ִ�в�ѯ
		  	rs=pstmt.executeQuery();
		  	//�ж��Ƿ�����һ��
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
		 //3:��תĿ��ҳ��
		  if(flag){
			//���û���Ű󶨵�session���󣬷���ȡֵ
			HttpSession session = request.getSession();
			session.setAttribute("userID", userID);
			if(type.equals("0")){//typeΪ��ʱ��ת������Ա��ҳ
				 base.process(request, response, "/manager_index.jsp");
			}
			else if(type.equals("1")){//typΪ1ʱ��ת����ʦ��ҳ
		    base.process(request, response, "/teacher_index.jsp");
			}
			else if(type.equals("2")){//typeΪ2ʱ��ת���޹�Ա��ҳ
			    base.process(request, response, "/houseparent_index.jsp");
				}
		else if(type.equals("3")){//typeΪ4ʱ��ת��ѧ����ҳ
			    base.process(request, response, "/student_index.jsp");
				}//typeΪloginout��ת��½ҳ��
		  }else if(type.equals("loginout")){
			  //��ȡվ����������/��Ŀ��
			  String path = request.getContextPath();
			  //��ȡsession
			  HttpSession session = request.getSession();
			  //ע��session
			  session.invalidate();
			  //�ض��򵽵�½ҳ��
			  response.sendRedirect(path+"/login.jsp");
		  }
		  else{//���������flag==flase)�����ص�½ҳ��
		    base.process(request, response, "/login.jsp");
		  }
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
              doGet(request,response);
	}

}
