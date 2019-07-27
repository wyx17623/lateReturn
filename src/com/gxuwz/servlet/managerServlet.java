package com.gxuwz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gxuwz.bean.BO.actionmanager;
import com.gxuwz.bean.vo.listmanager;

public class managerServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	    
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
		String type = request.getParameter("type");
		/*
		 * ϵͳ����Ա��ѯ������Ϣ
		 */
		if(type.equals("list")){
			//����һ��actionmanager����
			actionmanager as =new actionmanager();
			 try {
				 //����actionmanager��listmanager������ѯ������Ϣ�õ�һ������
				List<listmanager> sl=as.listmanager();
				//���������request������
				request.setAttribute("managerlist",sl);
				//����ת��
				RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}

		/*
		 * ϵͳ����Ա�޸ĸ�����Ϣ
		 */
		if(type.equals("update")){
			  //���ղ���
			String userID = request.getParameter("userID");
			String fullname = request.getParameter("fullname");
			String telephone = request.getParameter("telephone");
			String password =request.getParameter("password");
			//����һ��actionmanager����
			actionmanager as =new actionmanager(userID,  fullname,  telephone, password);
			try {
				as.updatemanager();
				 //����actionmanager��listmanager������ѯ������Ϣ�õ�һ������
				List<listmanager> sl=as.listmanager();
				//���������request������
				request.setAttribute("managerlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}		//����ת��
			RequestDispatcher rd=request.getRequestDispatcher("/page/manager/manager_list.jsp");
		      rd.forward(request, response);
		}
	
		
		
		
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
					doGet(request,response);
	}



}
