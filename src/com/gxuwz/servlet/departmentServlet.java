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
		// //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
         	 String type =request.getParameter("type");
         	 //ϵͳ����Ա��ѯ����ѧԺ��Ϣ
    		if(type.equals("list")){
    			//����һ��actiondepartment����
    			actiondepartment as =new actiondepartment();
    			 try {
    				 //����actiondepartment�����listdepartment������ѯ����ѧԺ��Ϣ����һ��list����
    				List<sys_department> sl=as.listdepartment();
    				//���õ���list�������request������
    				request.setAttribute("departmentlist",sl);
    				//����ת��
    				RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
//ϵͳ����Ա���ѧԺ��Ϣ
    		if(type.equals("add")){
    			//���ܲ���
    			String depID= request.getParameter("depID");
                String depName = request.getParameter("depName");
              //����һ��actiondepartment����
                actiondepartment as =new actiondepartment(depID,depName);
    			try {
    				//����actiondepartment�����addepartment�������ѧԺ��Ϣ
    				as.adddepartment();
    				 //����actiondepartment�����listdepartment������ѯ����ѧԺ��Ϣ����һ��list����
    				List<sys_department> sl=as.listdepartment();
    				//���õ���list�������request������
    				request.setAttribute("departmentlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		      rd.forward(request, response);
    		}
    		//ϵͳ����Ա�޸�ѧԺ��Ϣ
    		if(type.equals("update")){
    			//���ܲ���
    			String depID = request.getParameter("depID");
                String depName = request.getParameter("depName");
              //����һ��actiondepartment����
    			actiondepartment as =new actiondepartment( depID,  depName);
    			try {
    				as.updatedepartment();
    				 //����actiondepartment�����listdepartment������ѯ����ѧԺ��Ϣ����һ��list����
    				List<sys_department> sl=as.listdepartment();
    				//���õ���list�������request������
    				request.setAttribute("departmentlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
    		    rd.forward(request, response);
    		}
    		//ϵͳ����Աɾ��ѧԺ��Ϣ
    	if(type.equals("remove")){
    		//���ܲ���
    		String depID = request.getParameter("depID");
    		//����һ��actiondepartment����
    		actiondepartment as =new actiondepartment();
    		 try {//����actiondepartment�����removedeoartment����ɾ��ѧԺ��Ϣ
    			 as.removedepartment(depID);
    			 //����actiondepartment�����listdepartment������ѯ����ѧԺ��Ϣ����һ��list����
    			List<sys_department> sl=as.listdepartment();
    			//���õ���list�������request������
    			request.setAttribute("departmentlist",sl);
    			
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/department/department_list.jsp");
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
