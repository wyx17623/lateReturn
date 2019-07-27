package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.gxuwz.bean.BO.actiondormbuilding;
import com.gxuwz.bean.entity.sys_dormbuilding;


public class dormbuildingServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //获取页面传递的参数，决定调用的方法和走的路径     
         	 String type =request.getParameter("type");
         	 /*
         	  * 系统管理员查询宿舍楼信息
         	  */
    		if(type.equals("list")){
    			//创建一个actiondormbuilding对象
    			actiondormbuilding as =new actiondormbuilding();
    			 try {
    				 //调用actiondormbuilding对象的listdormBuilding方法，查询宿舍楼信息得到一个List链表
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//将List链表放入request对象中
    				request.setAttribute("dormbuildinglist",sl);
    				//请求转发
    				RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
             /*
              * 系统管理员添加宿舍楼信息
              */
    		if(type.equals("add")){
    			//接受参数
    			String dormBuildingID= request.getParameter("dormBuildingID");
                String dormBuildingName = request.getParameter("dormBuildingName");
              //创建一个actiondormbuilding对象
                actiondormbuilding as =new actiondormbuilding(dormBuildingID,dormBuildingName);
    			try {
    				as.adddormBuilding();
    				 //调用actiondormbuilding对象的listdormBuilding方法，查询宿舍楼信息得到一个List链表
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//将List链表放入request对象中
    				request.setAttribute("dormbuildinglist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    		      rd.forward(request, response);
    		}
    		/*
    		 * 系统管理员修改宿舍楼信息
    		 */
    		if(type.equals("update")){
    			String dormBuildingID = request.getParameter("dormBuildingID");
                String dormBuildingName = request.getParameter("dormBuildingName");
              //创建一个actiondormbuilding对象
    			actiondormbuilding as =new actiondormbuilding( dormBuildingID,  dormBuildingName);
    			try {
    				as.updatedormBuilding();
    				 //调用actiondormbuilding对象的listdormBuilding方法，查询宿舍楼信息得到一个List链表
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//将List链表放入request对象中
    				request.setAttribute("dormbuildinglist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    		    rd.forward(request, response);
    		}
    		/*
    		 * 系统管理员删除宿舍楼信息
    		 */
    	if(type.equals("remove")){
    		//接受参数
    		String dormBuildingID = request.getParameter("dormBuildingID");
    		//创建一个actiondormbuilding对象
    		actiondormbuilding as =new actiondormbuilding();
    		 try {
    			 as.removedormBuilding(dormBuildingID);
    			 //调用actiondormbuilding对象的listdormBuilding方法，查询宿舍楼信息得到一个List链表
    			List<sys_dormbuilding> sl=as.listdormBuilding();
    			//将List链表放入request对象中
    			request.setAttribute("dormbuildinglist",sl);
    			//请求转发
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
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
