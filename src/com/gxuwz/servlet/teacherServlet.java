package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.gxuwz.bean.BO.actionteacher;
import com.gxuwz.bean.vo.listteacher;

public class teacherServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //获取页面传递的参数，决定调用的方法和走的路径     
			String type =request.getParameter("type");
		/*
		 * 系统管理员查询所有教师信息
		 */
			if(type.equals("list")){
				//创建一个actionteacher对象
				actionteacher as =new actionteacher();
				 try {
					//调用actionteacher对象的listteacher方法查询教师信息得到一个List链表
					List<listteacher> sl=as.listteacher();
					//将链表放入request对象中
					request.setAttribute("teacherlist",sl);
					//请求转发
					RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
				      rd.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
/*
 * 系统管理员增加教师
 */
			if(type.equals("add")){
				String teacherID = request.getParameter("teacherID");
				String teacherName = request.getParameter("teacherName");
				String sex = request.getParameter("sex");
				String telephone = request.getParameter("teaTel");
				//创建一个actionteacher对象
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
				try {	//调用actionteacher对象的addteacher方法增加教师信息
					as.addteacher();
					//调用actionteacher对象的listteacher方法查询教师信息得到一个List链表
					List<listteacher> sl=as.listteacher();
					//将链表放入request对象中
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}//请求转发
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
			/*
			 * 系统管理员修改教师信息
			 */
			if(type.equals("update")){
				//获取参数
				String teacherID = request.getParameter("teacherID");
				String teacherName = request.getParameter("teacherName");
				String sex = request.getParameter("sex");
				String telephone = request.getParameter("teaTel");
				//创建一个actionteacher对象
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
				try {//调用actionteacher对象的updateteacher方法修改教师信息
					as.updateteacher();
					//调用actionteacher对象的listteacher方法查询教师信息得到一个List链表
					List<listteacher> sl=as.listteacher();
					//将链表放入request对象中
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}//请求转发
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
			/*
			 * 系统管理员删除教师信息
			 */
		if(type.equals("remove")){
			//创建一个actionteacher对象
			actionteacher as =new actionteacher();
			 try {	//获取参数
				 String teacherID = request.getParameter("teacherID");
				//调用actionteacher对象的removeteacher方法删除教师信息
				 as.removeteacher(teacherID);
					//调用actionteacher对象的listteacher方法查询教师信息得到一个List链表
				List<listteacher> sl=as.listteacher();
				//将链表放入request对象中
				request.setAttribute("teacherlist",sl);
				//请求转发
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			}
		/**
		 * 教师查询个人信息
		 */
		if(type.equals("listpersonal")){
			//创建一个actionteacher对象
			actionteacher as =new actionteacher();
			//获取session对象
			HttpSession session = request.getSession();
			//从session中取ID值
			String teacherID =(String)session.getAttribute("userID");
			 try {	//调用actionteacher对象的listteacherpersonal方法查询教师个人信息得到一个List链表
				List<listteacher> sl=as.listteacherpersonal(teacherID);
				//将链表放入request对象中
				request.setAttribute("teacherlist",sl);
				//请求转发
				RequestDispatcher rd=request.getRequestDispatcher("/page/userpersonal/teacherpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		/*
		 * 学生修改个人信息
		 */
		if(type.equals("updatepersonal")){
			//获取参数
			String teacherID = request.getParameter("teacherID");
			String teacherName = request.getParameter("teacherName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("teaTel");
			//创建一个actionteacher对象
			actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
			try {//调用actionteacher对象的updateteacher方法修改教师个人信息
				as.updateteacher();
				//调用actionteacher对象的listteacherpersonal方法查询教师信息得到一个List链表
				List<listteacher> sl=as.listteacherpersonal(teacherID);
				//将链表放入request对象中
				request.setAttribute("teacherlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd=request.getRequestDispatcher("/page/userpersonal/teacherpersonal_list.jsp");
		      rd.forward(request, response);
		}
		}
		
		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用doget方法处理
             doGet(request,response);
		
	}



}
