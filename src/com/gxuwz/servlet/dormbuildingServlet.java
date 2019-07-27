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
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
         	 String type =request.getParameter("type");
         	 /*
         	  * ϵͳ����Ա��ѯ����¥��Ϣ
         	  */
    		if(type.equals("list")){
    			//����һ��actiondormbuilding����
    			actiondormbuilding as =new actiondormbuilding();
    			 try {
    				 //����actiondormbuilding�����listdormBuilding��������ѯ����¥��Ϣ�õ�һ��List����
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//��List�������request������
    				request.setAttribute("dormbuildinglist",sl);
    				//����ת��
    				RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
             /*
              * ϵͳ����Ա�������¥��Ϣ
              */
    		if(type.equals("add")){
    			//���ܲ���
    			String dormBuildingID= request.getParameter("dormBuildingID");
                String dormBuildingName = request.getParameter("dormBuildingName");
              //����һ��actiondormbuilding����
                actiondormbuilding as =new actiondormbuilding(dormBuildingID,dormBuildingName);
    			try {
    				as.adddormBuilding();
    				 //����actiondormbuilding�����listdormBuilding��������ѯ����¥��Ϣ�õ�һ��List����
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//��List�������request������
    				request.setAttribute("dormbuildinglist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    		      rd.forward(request, response);
    		}
    		/*
    		 * ϵͳ����Ա�޸�����¥��Ϣ
    		 */
    		if(type.equals("update")){
    			String dormBuildingID = request.getParameter("dormBuildingID");
                String dormBuildingName = request.getParameter("dormBuildingName");
              //����һ��actiondormbuilding����
    			actiondormbuilding as =new actiondormbuilding( dormBuildingID,  dormBuildingName);
    			try {
    				as.updatedormBuilding();
    				 //����actiondormbuilding�����listdormBuilding��������ѯ����¥��Ϣ�õ�һ��List����
    				List<sys_dormbuilding> sl=as.listdormBuilding();
    				//��List�������request������
    				request.setAttribute("dormbuildinglist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    		    rd.forward(request, response);
    		}
    		/*
    		 * ϵͳ����Աɾ������¥��Ϣ
    		 */
    	if(type.equals("remove")){
    		//���ܲ���
    		String dormBuildingID = request.getParameter("dormBuildingID");
    		//����һ��actiondormbuilding����
    		actiondormbuilding as =new actiondormbuilding();
    		 try {
    			 as.removedormBuilding(dormBuildingID);
    			 //����actiondormbuilding�����listdormBuilding��������ѯ����¥��Ϣ�õ�һ��List����
    			List<sys_dormbuilding> sl=as.listdormBuilding();
    			//��List�������request������
    			request.setAttribute("dormbuildinglist",sl);
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dormbuilding/dormbuilding_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����doget��������
                  doGet(request,response);
	}

}
