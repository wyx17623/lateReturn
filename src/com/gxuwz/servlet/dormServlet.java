package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.gxuwz.bean.BO.actiondorm;
import com.gxuwz.bean.vo.listdorm;

/**
 * 
 * @author 
 * 时间：2019年6月12日下午3:01:19
 * Description:宿舍处理类
 */
public class dormServlet extends HttpServlet {	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   
		 //获取页面传递的参数，决定调用的方法和走的路径     
         	 String type =request.getParameter("type");
         	 /*
         	  * 系统管理员查询宿舍信息
         	  */
    		if(type.equals("list")){
    			//创建一个actiondorm对象
    			actiondorm as =new actiondorm();
    			 try {
    				 //调用actiondorm对象的listdorm方法查询所有的宿舍信息，得到一个List链表
    				List<listdorm> sl=as.listdorm();
    				//将得到的List链表放入request对象中
    				request.setAttribute("dormlist",sl);
    				//请求转发
    				RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
           /*
            * 系统管理员添加宿舍信息
            */
    		if(type.equals("add")){
    			//获取参数
    			String dormID= request.getParameter("dormID");
                String dormName = request.getParameter("dormName");
                String dormBuildingID = request.getParameter("dormBuildingID");
              //创建一个actiondorm对象
                actiondorm as =new actiondorm(dormID,dormName,dormBuildingID);
    			try {
    				as.adddorm();
    				 //调用actiondorm对象的listdorm方法查询所有的宿舍信息，得到一个List链表
    				List<listdorm> sl=as.listdorm();
    				//将得到的List链表放入request对象中
    				request.setAttribute("dormlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			//参数获取
    			String dormID = request.getParameter("dormID");
                String dormName = request.getParameter("dormName");
                String dormBuildingID = request.getParameter("dormBuildingID");
              //创建一个actiondorm对象
    			actiondorm as =new actiondorm(dormID, dormName, dormBuildingID);
    			try {
    				as.updatedorm();
    				 //调用actiondorm对象的listdorm方法查询所有的宿舍信息，得到一个List链表
    				List<listdorm> sl=as.listdorm();
    				//将得到的List链表放入request对象中
    				request.setAttribute("dormlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		//参数获取
    		String dormID = request.getParameter("dormID");
    		//创建一个actiondorm对象
    		actiondorm as =new actiondorm();
    		 try {
    			 as.removedorm(dormID);
    			 //调用actiondorm对象的listdorm方法查询所有的宿舍信息，得到一个List链表
    			List<listdorm> sl=as.listdorm();
    			//将得到的List链表放入request对象中
    			request.setAttribute("dormlist",sl);
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
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
