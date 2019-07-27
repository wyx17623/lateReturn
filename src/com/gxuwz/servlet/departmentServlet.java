package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gxuwz.bean.BO.actiondepartment;
import com.gxuwz.bean.entity.sys_department;


public class departmentServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// //获取页面传递的参数，决定调用的方法和走的路径     
         	 String type =request.getParameter("type");
         	 //系统管理员查询所有学院信息
    		if(type.equals("list")){
    			//创建一个actiondepartment对象
    			actiondepartment as =new actiondepartment();
    			 try {
    				 //调用actiondepartment对象的listdepartment方法查询所有学院信息返回一个list链表
    				List<sys_department> sl=as.listdepartment();
    				//将得到的list链表放入request对象中
    				request.setAttribute("departmentlist",sl);
    				//请求转发
    				RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
//系统管理员添加学院信息
    		if(type.equals("add")){
    			//接受参数
    			String depID= request.getParameter("depID");
                String depName = request.getParameter("depName");
              //创建一个actiondepartment对象
                actiondepartment as =new actiondepartment(depID,depName);
    			try {
    				//调用actiondepartment对象的addepartment方法添加学院信息
    				as.adddepartment();
    				 //调用actiondepartment对象的listdepartment方法查询所有学院信息返回一个list链表
    				List<sys_department> sl=as.listdepartment();
    				//将得到的list链表放入request对象中
    				request.setAttribute("departmentlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		      rd.forward(request, response);
    		}
    		//系统管理员修改学院信息
    		if(type.equals("update")){
    			//接受参数
    			String depID = request.getParameter("depID");
                String depName = request.getParameter("depName");
              //创建一个actiondepartment对象
    			actiondepartment as =new actiondepartment( depID,  depName);
    			try {
    				as.updatedepartment();
    				 //调用actiondepartment对象的listdepartment方法查询所有学院信息返回一个list链表
    				List<sys_department> sl=as.listdepartment();
    				//将得到的list链表放入request对象中
    				request.setAttribute("departmentlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		    rd.forward(request, response);
    		}
    		//系统管理员删除学院信息
    	if(type.equals("remove")){
    		//接受参数
    		String depID = request.getParameter("depID");
    		//创建一个actiondepartment对象
    		actiondepartment as =new actiondepartment();
    		 try {//调用actiondepartment对象的removedeoartment方法删除学院信息
    			 as.removedepartment(depID);
    			 //调用actiondepartment对象的listdepartment方法查询所有学院信息返回一个list链表
    			List<sys_department> sl=as.listdepartment();
    			//将得到的list链表放入request对象中
    			request.setAttribute("departmentlist",sl);
    			
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//调用doget方法处理
                  doGet(request,response);
	}

}
