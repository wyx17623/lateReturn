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

import com.gxuwz.bean.BO.actionlateReturn;
import com.gxuwz.bean.vo.listlateReturn;

/**
 * 
 * @author 时间：2019年6月12日下午8:49:24 Description:晚归处理类
 */
public class lateReturnServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//通过request得到Session对象
		HttpSession session = request.getSession();
		//从session对象中获取用户ID
		String userID = (String)session.getAttribute("userID");
		 //获取页面传递的参数，决定调用的方法和走的路径     
		String type = request.getParameter("type");
		/*
		 * 宿舍管理员查看自己楼的所有的晚归记录
		 */
		if (type.equals("list")) {
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn();
			
			try {
				//调用actionlateReturn对象的listlateReturn方法，查询晚归记录，得到一个List链表
				List<listlateReturn> sl = as.listlateReturn(userID);
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 宿舍管理员添加晚归记录
		 */
		if (type.equals("add")) {
			
			String lateReturnID = request.getParameter("lateReturnID");
			String stuID = request.getParameter("stuID");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String lateReturnTime = request.getParameter("lateReturnTime");
			String lateReturnReason = request.getParameter("lateReturnReason");
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn(lateReturnID, stuID,
					dormID, bedID, lateReturnTime, lateReturnReason);
			try {
				//调用actionlateReturn对象的addlateReturn方法添加晚归记录
				as.addlateReturn();
				//调用actionlateReturn对象的listlateReturn方法，查询晚归记录，得到一个List链表
				List<listlateReturn> sl = as.listlateReturn(userID);
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}	//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 宿舍管理员修改晚归记录
		 */
		if (type.equals("update")) {
			//接收参数
			String lateReturnID = request.getParameter("lateReturnID");
			String stuID = request.getParameter("stuID");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String lateReturnTime = request.getParameter("lateReturnTime");
			String lateReturnReason = request.getParameter("lateReturnReason");
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn(lateReturnID, stuID,
					dormID, bedID, lateReturnTime, lateReturnReason);
			try {//调用actionlateReturn对象的updatelateReturn方法修改晚归记录
				as.updatelateReturn();
				//调用actionlateReturn对象的listlateReturn方法，查询晚归记录，得到一个List链表
				List<listlateReturn> sl = as.listlateReturn(userID);
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}	//请求转发
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * 宿舍管理员删除晚归记录
		 */
		if (type.equals("remove")) {
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn();
			try {//接收参数
				String lateReturnID = request.getParameter("lateReturnID");
				//调用actionlateReturn对象的removelateReturn方法删除晚归记录
				as.removelateReturn(lateReturnID);
				//调用actionlateReturn对象的listlateReturn方法，查询晚归记录，得到一个List链表
				List<listlateReturn> sl = as.listlateReturn(userID);
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 教师查询自己所带班级的晚归记录
		 */
		if (type.equals("listteacher")) {
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn();
			//接收参数
			String classID = request.getParameter("classID");
		//定义一个链表
			List<listlateReturn> sl;
			try { 
				//当classID为null时调用方法得到教师带班所有人的晚归记录
				if(classID==null){
					//调用actionlateReturn对象的listTeacherlateReturn方法，查询晚归记录，得到一个List链表
				 sl = as.listTeacherlateReturn(userID);
				 //当classID不为null时得到教师所带的某个班级所有人的晚归记录
				}else{//调用actionlateReturn对象的listTeacherlateReturn方法，查询晚归记录，得到一个List链表
					 sl = as.listTeacherlateReturn(userID,classID);
				}
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/TeacherlateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * 学生查询自己的晚归记录
		 */
		if (type.equals("liststudent")) {
			//创建一个actionlateReturn对象
			actionlateReturn as = new actionlateReturn();
			//定义一个链表
			List<listlateReturn> sl;
			try { 
				//调用actionlateReturn对象的listStulateReturn方法，查询晚归记录，得到一个List链表
					 sl = as.listStulateReturn(userID);
			
				//将得到的链表放入request
				request.setAttribute("listlateReturn", sl);
				//请求转发
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/StulateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用doget方法处理
		doGet(request, response);

	}

}
