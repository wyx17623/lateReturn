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

import com.gxuwz.bean.BO.actionstudent;
import com.gxuwz.bean.vo.liststudent;

/**
 * 
 * @author 时间：2019年6月12日下午8:02:19 Description:学生处理
 */
public class studentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //获取页面传递的参数，决定调用的方法和走的路径     
		String type = request.getParameter("type");
       /*
        * 系统管理员查询所有学生的方法
        */
		if (type.equals("list")) {
			//创建一个actionstudent对象
			actionstudent as = new actionstudent();
			try {//调用actionstudent对象的liststudent方法查询学生信息得到一个List链表
				List<liststudent> sl = as.liststudent();
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/student/student_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
/*
 * 系统管理员添加学生
 */
		if (type.equals("add")) {
			//接收参数
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//创建一个actionstudent对象
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//调用actionstudent对象的addstudent添加学生
				as.addstudent();
				//调用actionstudent对象的liststudent方法查询学生信息得到一个List链表
				List<liststudent> sl = as.liststudent();
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/student/student_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 系统管理员修改学生信息
		 */
		if (type.equals("update")) {
			//获取参数
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//创建一个actionstudent对象
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//调用actionstudent对象的updatestudent方法修改学生信息
				as.updatestudent();
				//调用actionstudent对象的liststudent方法查询学生信息得到一个List链表
				List<liststudent> sl = as.liststudent();
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/student/student_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 系统管理员删除学生信息
		 */
		if (type.equals("remove")) {
			//创建一个actionstudent对象
			actionstudent as = new actionstudent();
			//接收参数
			String stuID = request.getParameter("stuID");
			try {//调用actionstudent对象的removestudent方法删除学生信息
				as.removestudent(stuID);
				//调用actionstudent对象的liststudent方法查询学生信息得到一个List链表
				List<liststudent> sl = as.liststudent();
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/student/student_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 学生个人查询个人信息
		 */
		if (type.equals("listpersonal")) {
			//创建一个actionstudent对象
			actionstudent as = new actionstudent();
			HttpSession session = request.getSession();
			String stuID=(String)session.getAttribute("userID");
			try {//学生调用actionstudent对象的liststudent方法查询个人得到一个List链表
				List<liststudent> sl = as.liststudentpersonal(stuID);
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/userpersonal/studentpersonal_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * 学生修改个人信息
		 */
		if (type.equals("updatepersonal")) {
			//接受参数
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			//创建一个actionstudent对象
			String dormBuildingID = request.getParameter("dormBuildingID");
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//调用actionstudent对象的updatestudent方法修改个人信息
				as.updatestudent();
				//调用actionstudent对象的liststudent方法查询个人信息得到一个List链表
				List<liststudent> sl = as.liststudentpersonal(stuID);
				//将得到的List放入request中
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/userpersonal/studentpersonal_list.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
