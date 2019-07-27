package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxuwz.bean.BO.actionclass;
import com.gxuwz.bean.vo.listclasses;
public class classServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             //获取页面传递的参数，决定调用的方法和走的路径
         	 String type =request.getParameter("type");
        	//系统管理员查询所有班级信息
    		if(type.equals("list")){
    			//创建一个actionclass对象
    			actionclass as =new actionclass();
    			 try {
    				 //调用actionclass对象的listcalsses方法得到一个list
    				List<listclasses> sl=as.listclasses();
    				//将list放入request对象中
    				request.setAttribute("listclasses",sl);
    				//请求转发到指定页面
    				RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
    		//系统管理员修改所有班级信息
    		if(type.equals("add")){
    			//接受页面的参数
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                String grade = request.getParameter("grade");
                String depID = request.getParameter("depID");
                String teacherID = request.getParameter("teacherID");
                //创建一个actionclass的类
    			actionclass as =new actionclass( classID,  className, grade, depID,teacherID);
    			try {
    				//调用actionclass的addclass添加方法
    				as.addclasses();
    				//调用actionclass的listclass的查询方法得到一个list链表
    				List<listclasses> sl=as.listclasses();
    				//将链表放入request对象中
    				request.setAttribute("listclasses",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		      rd.forward(request, response);
    		}
    		//系统管理员修改班级信息
    		if(type.equals("update")){
    			//接受参数
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                String grade = request.getParameter("grade");
                String depID = request.getParameter("depID");
                String teacherID = request.getParameter("teacherID");
                //创建一个actionclass类
    			actionclass as =new actionclass( classID,  className, grade, depID,teacherID);
    			try {
    				//调用actionclass类的update方法
    				as.updateclasses();
    				//调用actionclass类的listclass查询方法，得到一个list链表
    				List<listclasses> sl=as.listclasses();
    				//将list链表放入request对象中
    				request.setAttribute("listclasses",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		    rd.forward(request, response);
    		}
    		//系统管理员删除班级信息
    	if(type.equals("remove")){
    		//接受参数
    		String classID = request.getParameter("classID");
    	//创建一个actionclass对象
    		actionclass as =new actionclass();
    		 try {
    			 //调用actionclass的removeclasses删除方法
    			 as.removeclasses(classID);
    			 //调用actionclass的listclasses查询方法，得到一个list链表
    			List<listclasses> sl=as.listclasses();
    			//将list链表放入request对象中
    			request.setAttribute("listclasses",sl);
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//dost方法调用doget方法处理
                  doGet(request,response);
	}

}
