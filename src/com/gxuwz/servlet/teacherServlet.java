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

import com.gxuwz.bean.BO.actionteacher;
import com.gxuwz.bean.vo.listteacher;

public class teacherServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
			String type =request.getParameter("type");
		/*
		 * ϵͳ����Ա��ѯ���н�ʦ��Ϣ
		 */
			if(type.equals("list")){
				//����һ��actionteacher����
				actionteacher as =new actionteacher();
				 try {
					//����actionteacher�����listteacher������ѯ��ʦ��Ϣ�õ�һ��List����
					List<listteacher> sl=as.listteacher();
					//���������request������
					request.setAttribute("teacherlist",sl);
					//����ת��
					RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
				      rd.forward(request, response);
				} catch (Exception e) {
					
					e.printStackTrace();
				}
			}
/*
 * ϵͳ����Ա���ӽ�ʦ
 */
			if(type.equals("add")){
				String teacherID = request.getParameter("teacherID");
				String teacherName = request.getParameter("teacherName");
				String sex = request.getParameter("sex");
				String telephone = request.getParameter("teaTel");
				//����һ��actionteacher����
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
				try {	//����actionteacher�����addteacher�������ӽ�ʦ��Ϣ
					as.addteacher();
					//����actionteacher�����listteacher������ѯ��ʦ��Ϣ�õ�һ��List����
					List<listteacher> sl=as.listteacher();
					//���������request������
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}//����ת��
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
			/*
			 * ϵͳ����Ա�޸Ľ�ʦ��Ϣ
			 */
			if(type.equals("update")){
				//��ȡ����
				String teacherID = request.getParameter("teacherID");
				String teacherName = request.getParameter("teacherName");
				String sex = request.getParameter("sex");
				String telephone = request.getParameter("teaTel");
				//����һ��actionteacher����
				actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
				try {//����actionteacher�����updateteacher�����޸Ľ�ʦ��Ϣ
					as.updateteacher();
					//����actionteacher�����listteacher������ѯ��ʦ��Ϣ�õ�һ��List����
					List<listteacher> sl=as.listteacher();
					//���������request������
					request.setAttribute("teacherlist",sl);
				} catch (Exception e) {
					e.printStackTrace();
				}//����ת��
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			}
			/*
			 * ϵͳ����Աɾ����ʦ��Ϣ
			 */
		if(type.equals("remove")){
			//����һ��actionteacher����
			actionteacher as =new actionteacher();
			 try {	//��ȡ����
				 String teacherID = request.getParameter("teacherID");
				//����actionteacher�����removeteacher����ɾ����ʦ��Ϣ
				 as.removeteacher(teacherID);
					//����actionteacher�����listteacher������ѯ��ʦ��Ϣ�õ�һ��List����
				List<listteacher> sl=as.listteacher();
				//���������request������
				request.setAttribute("teacherlist",sl);
				//����ת��
				RequestDispatcher rd=request.getRequestDispatcher("/page/teacher/teacher_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
			}
		/**
		 * ��ʦ��ѯ������Ϣ
		 */
		if(type.equals("listpersonal")){
			//����һ��actionteacher����
			actionteacher as =new actionteacher();
			//��ȡsession����
			HttpSession session = request.getSession();
			//��session��ȡIDֵ
			String teacherID =(String)session.getAttribute("userID");
			 try {	//����actionteacher�����listteacherpersonal������ѯ��ʦ������Ϣ�õ�һ��List����
				List<listteacher> sl=as.listteacherpersonal(teacherID);
				//���������request������
				request.setAttribute("teacherlist",sl);
				//����ת��
				RequestDispatcher rd=request.getRequestDispatcher("/page/userpersonal/teacherpersonal_list.jsp");
			      rd.forward(request, response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		/*
		 * ѧ���޸ĸ�����Ϣ
		 */
		if(type.equals("updatepersonal")){
			//��ȡ����
			String teacherID = request.getParameter("teacherID");
			String teacherName = request.getParameter("teacherName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("teaTel");
			//����һ��actionteacher����
			actionteacher as =new actionteacher(teacherID,  teacherName,  sex, telephone);
			try {//����actionteacher�����updateteacher�����޸Ľ�ʦ������Ϣ
				as.updateteacher();
				//����actionteacher�����listteacherpersonal������ѯ��ʦ��Ϣ�õ�һ��List����
				List<listteacher> sl=as.listteacherpersonal(teacherID);
				//���������request������
				request.setAttribute("teacherlist",sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd=request.getRequestDispatcher("/page/userpersonal/teacherpersonal_list.jsp");
		      rd.forward(request, response);
		}
		}
		
		
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����doget��������
             doGet(request,response);
		
	}



}
