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

import com.gxuwz.bean.BO.actionhouseparent;
import com.gxuwz.bean.vo.listhouseparent;
/**
 * 
 * @author 
 * 时间：2019年6月12日下午8:46:52
 * Description:宿管员处理类
 */
 

public class houseparentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //获取页面传递的参数，决定调用的方法和走的路径     
		String type = request.getParameter("type");
		/*
		 * 系统管理员查询所有宿舍管理员信息
		 */
		if (type.equals("list")) {
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent();
			try {//调用actionhouseparent对象的listhouseparent方法，查询所有的宿舍管理员信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparent();
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 系统管理员添加宿舍管理员信息
		 */
		if (type.equals("add")) {
			//接受参数
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {//调用actionhouseparent对象的addhouseparent添加方法
				as.addhouseparent();
				//调用actionhouseparent对象的listhouseparent方法，查询所有的宿舍管理员信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparent();
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 系统管理员修改宿舍管理员信息
		 */
		if (type.equals("update")) {
			//接受参数
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {//调用actionhouseparent对象的updatehouseparent方法修改
				as.updatehouseparent();
				//调用actionhouseparent对象的listhouseparent方法，查询所有的宿舍管理员信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparent();
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
			rd.forward(request, response);
		}
		if (type.equals("remove")) {
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent();
			try {//接受参数
				String houseparentID = request.getParameter("houseparentID");
				//调用actionhouseparent的removehouseparent方法删除
				as.removehouseparent(houseparentID);
				//调用actionhouseparent对象的listhouseparent方法，查询所有的宿舍管理员信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparent();
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 宿舍管理员查看个人信息
		 */
		if (type.equals("listpersonal")) {
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent();
			//通过request得到Session对象
			HttpSession session = request.getSession();
			//从session对象中获取用户ID
			String houseparentID=(String)session.getAttribute("userID");
			try {//调用actionhouseparent对象的listhouseparent方法，查询个人信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparentpersonal(houseparentID);
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/userpersonal/houseparentpersonal_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 宿舍管理员修改个人信息
		 */
		if (type.equals("updatepersonal")) {
			//接受参数
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//创建一个actionhouseparent对象
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {
				//调用updatehouseparent方法修改个人信息
				as.updatehouseparent();
				//调用actionhouseparent对象的listhouseparent方法，查询个人信息，得到一个List链表
				List<listhouseparent> sl = as.listhouseparentpersonal(houseparentID);
				//将得到的List链表放入request对象中
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/userpersonal/houseparentpersonal_list.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用doget方法处理
		doGet(request, response);

	}

}
