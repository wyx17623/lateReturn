package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionmanager;
import com.gxuwz.bean.vo.listmanager;

public class managerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		 //获取页面传递的参数，决定调用的方法和走的路径     
		String type = request.getParameter("type");
		/*
		 * 系统管理员查询个人信息
		 */
		if(type.equals("list")){
			//创建一个actionmanager对象
			actionmanager as =new actionmanager();
			 try {
				 //调用actionmanager的listmanager方法查询个人信息得到一个链表
				List<listmanager> sl=as.listmanager();
				//将链表放入request对象中
				request.setAttribute("managerlist",sl);
				//请求转发
				RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		/*
		 * 系统管理员修改个人信息
		 */
		if(type.equals("update")){
			  //接收参数
			String userID = request.getParameter("userID");
			String fullname = request.getParameter("fullname");
			String telephone = request.getParameter("telephone");
			String password =request.getParameter("password");
			//创建一个actionmanager对象
			actionmanager as =new actionmanager(userID,  fullname,  telephone, password);
			try {
				as.updatemanager();
				 //调用actionmanager的listmanager方法查询个人信息得到一个链表
				List<listmanager> sl=as.listmanager();
				//将链表放入request对象中
				request.setAttribute("managerlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}		//请求转发
			RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
		      rd.forward(request, response);
		}
	
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					doGet(request,response);
	}



}
