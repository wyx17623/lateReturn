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
 * ʱ�䣺2019��6��12������8:46:52
 * Description:�޹�Ա������
 */
 

public class houseparentServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
		String type = request.getParameter("type");
		/*
		 * ϵͳ����Ա��ѯ�����������Ա��Ϣ
		 */
		if (type.equals("list")) {
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent();
			try {//����actionhouseparent�����listhouseparent��������ѯ���е��������Ա��Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparent();
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * ϵͳ����Ա����������Ա��Ϣ
		 */
		if (type.equals("add")) {
			//���ܲ���
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {//����actionhouseparent�����addhouseparent��ӷ���
				as.addhouseparent();
				//����actionhouseparent�����listhouseparent��������ѯ���е��������Ա��Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparent();
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * ϵͳ����Ա�޸��������Ա��Ϣ
		 */
		if (type.equals("update")) {
			//���ܲ���
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {//����actionhouseparent�����updatehouseparent�����޸�
				as.updatehouseparent();
				//����actionhouseparent�����listhouseparent��������ѯ���е��������Ա��Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparent();
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
			rd.forward(request, response);
		}
		if (type.equals("remove")) {
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent();
			try {//���ܲ���
				String houseparentID = request.getParameter("houseparentID");
				//����actionhouseparent��removehouseparent����ɾ��
				as.removehouseparent(houseparentID);
				//����actionhouseparent�����listhouseparent��������ѯ���е��������Ա��Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparent();
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/houseparent/houseparent_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * �������Ա�鿴������Ϣ
		 */
		if (type.equals("listpersonal")) {
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent();
			//ͨ��request�õ�Session����
			HttpSession session = request.getSession();
			//��session�����л�ȡ�û�ID
			String houseparentID=(String)session.getAttribute("userID");
			try {//����actionhouseparent�����listhouseparent��������ѯ������Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparentpersonal(houseparentID);
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/userpersonal/houseparentpersonal_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * �������Ա�޸ĸ�����Ϣ
		 */
		if (type.equals("updatepersonal")) {
			//���ܲ���
			String houseparentID = request.getParameter("houseparentID");
			String houseparentName = request.getParameter("houseparentName");
			String sex = request.getParameter("sex");
			String telephone = request.getParameter("houTel");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//����һ��actionhouseparent����
			actionhouseparent as = new actionhouseparent(houseparentID,
					houseparentName, sex, telephone, dormBuildingID);
			try {
				//����updatehouseparent�����޸ĸ�����Ϣ
				as.updatehouseparent();
				//����actionhouseparent�����listhouseparent��������ѯ������Ϣ���õ�һ��List����
				List<listhouseparent> sl = as.listhouseparentpersonal(houseparentID);
				//���õ���List�������request������
				request.setAttribute("listhouseparent", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/userpersonal/houseparentpersonal_list.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����doget��������
		doGet(request, response);

	}

}
