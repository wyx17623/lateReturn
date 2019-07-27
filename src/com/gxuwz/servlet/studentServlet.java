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

import com.gxuwz.bean.BO.actionstudent;
import com.gxuwz.bean.vo.liststudent;

/**
 * 
 * @author ʱ�䣺2019��6��12������8:02:19 Description:ѧ������
 */
public class studentServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
		String type = request.getParameter("type");
       /*
        * ϵͳ����Ա��ѯ����ѧ���ķ���
        */
		if (type.equals("list")) {
			//����һ��actionstudent����
			actionstudent as = new actionstudent();
			try {//����actionstudent�����liststudent������ѯѧ����Ϣ�õ�һ��List����
				List<liststudent> sl = as.liststudent();
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/student/student_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
/*
 * ϵͳ����Ա���ѧ��
 */
		if (type.equals("add")) {
			//���ղ���
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//����һ��actionstudent����
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//����actionstudent�����addstudent���ѧ��
				as.addstudent();
				//����actionstudent�����liststudent������ѯѧ����Ϣ�õ�һ��List����
				List<liststudent> sl = as.liststudent();
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/student/student_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * ϵͳ����Ա�޸�ѧ����Ϣ
		 */
		if (type.equals("update")) {
			//��ȡ����
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String dormBuildingID = request.getParameter("dormBuildingID");
			//����һ��actionstudent����
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//����actionstudent�����updatestudent�����޸�ѧ����Ϣ
				as.updatestudent();
				//����actionstudent�����liststudent������ѯѧ����Ϣ�õ�һ��List����
				List<liststudent> sl = as.liststudent();
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/student/student_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * ϵͳ����Աɾ��ѧ����Ϣ
		 */
		if (type.equals("remove")) {
			//����һ��actionstudent����
			actionstudent as = new actionstudent();
			//���ղ���
			String stuID = request.getParameter("stuID");
			try {//����actionstudent�����removestudent����ɾ��ѧ����Ϣ
				as.removestudent(stuID);
				//����actionstudent�����liststudent������ѯѧ����Ϣ�õ�һ��List����
				List<liststudent> sl = as.liststudent();
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/student/student_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * ѧ�����˲�ѯ������Ϣ
		 */
		if (type.equals("listpersonal")) {
			//����һ��actionstudent����
			actionstudent as = new actionstudent();
			HttpSession session = request.getSession();
			String stuID=(String)session.getAttribute("userID");
			try {//ѧ������actionstudent�����liststudent������ѯ���˵õ�һ��List����
				List<liststudent> sl = as.liststudentpersonal(stuID);
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/userpersonal/studentpersonal_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		/*
		 * ѧ���޸ĸ�����Ϣ
		 */
		if (type.equals("updatepersonal")) {
			//���ܲ���
			String stuID = request.getParameter("stuID");
			String stuName = request.getParameter("stuName");
			String sex = request.getParameter("sex");
			String classID = request.getParameter("classID");
			String stuTel = request.getParameter("stuTel");
			String address = request.getParameter("address");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			//����һ��actionstudent����
			String dormBuildingID = request.getParameter("dormBuildingID");
			actionstudent as = new actionstudent(stuID, stuName, sex, classID,
					dormID, stuTel, address, bedID, dormBuildingID);
			try {//����actionstudent�����updatestudent�����޸ĸ�����Ϣ
				as.updatestudent();
				//����actionstudent�����liststudent������ѯ������Ϣ�õ�һ��List����
				List<liststudent> sl = as.liststudentpersonal(stuID);
				//���õ���List����request��
				request.setAttribute("studentlist", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/userpersonal/studentpersonal_list.jsp");
			rd.forward(request, response);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);

	}

}
