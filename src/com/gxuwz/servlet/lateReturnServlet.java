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

import com.gxuwz.bean.BO.actionlateReturn;
import com.gxuwz.bean.vo.listlateReturn;

/**
 * 
 * @author ʱ�䣺2019��6��12������8:49:24 Description:��鴦����
 */
public class lateReturnServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//ͨ��request�õ�Session����
		HttpSession session = request.getSession();
		//��session�����л�ȡ�û�ID
		String userID = (String)session.getAttribute("userID");
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
		String type = request.getParameter("type");
		/*
		 * �������Ա�鿴�Լ�¥�����е�����¼
		 */
		if (type.equals("list")) {
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn();
			
			try {
				//����actionlateReturn�����listlateReturn��������ѯ����¼���õ�һ��List����
				List<listlateReturn> sl = as.listlateReturn(userID);
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * �������Ա�������¼
		 */
		if (type.equals("add")) {
			
			String lateReturnID = request.getParameter("lateReturnID");
			String stuID = request.getParameter("stuID");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String lateReturnTime = request.getParameter("lateReturnTime");
			String lateReturnReason = request.getParameter("lateReturnReason");
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn(lateReturnID, stuID,
					dormID, bedID, lateReturnTime, lateReturnReason);
			try {
				//����actionlateReturn�����addlateReturn�����������¼
				as.addlateReturn();
				//����actionlateReturn�����listlateReturn��������ѯ����¼���õ�һ��List����
				List<listlateReturn> sl = as.listlateReturn(userID);
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}	//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * �������Ա�޸�����¼
		 */
		if (type.equals("update")) {
			//���ղ���
			String lateReturnID = request.getParameter("lateReturnID");
			String stuID = request.getParameter("stuID");
			String dormID = request.getParameter("dormID");
			String bedID = request.getParameter("bedID");
			String lateReturnTime = request.getParameter("lateReturnTime");
			String lateReturnReason = request.getParameter("lateReturnReason");
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn(lateReturnID, stuID,
					dormID, bedID, lateReturnTime, lateReturnReason);
			try {//����actionlateReturn�����updatelateReturn�����޸�����¼
				as.updatelateReturn();
				//����actionlateReturn�����listlateReturn��������ѯ����¼���õ�һ��List����
				List<listlateReturn> sl = as.listlateReturn(userID);
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
			} catch (Exception e) {
				e.printStackTrace();
			}	//����ת��
			RequestDispatcher rd = request
					.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
			rd.forward(request, response);
		}
		/*
		 * �������Աɾ������¼
		 */
		if (type.equals("remove")) {
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn();
			try {//���ղ���
				String lateReturnID = request.getParameter("lateReturnID");
				//����actionlateReturn�����removelateReturn����ɾ������¼
				as.removelateReturn(lateReturnID);
				//����actionlateReturn�����listlateReturn��������ѯ����¼���õ�һ��List����
				List<listlateReturn> sl = as.listlateReturn(userID);
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/lateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * ��ʦ��ѯ�Լ������༶������¼
		 */
		if (type.equals("listteacher")) {
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn();
			//���ղ���
			String classID = request.getParameter("classID");
		//����һ������
			List<listlateReturn> sl;
			try { 
				//��classIDΪnullʱ���÷����õ���ʦ���������˵�����¼
				if(classID==null){
					//����actionlateReturn�����listTeacherlateReturn��������ѯ����¼���õ�һ��List����
				 sl = as.listTeacherlateReturn(userID);
				 //��classID��Ϊnullʱ�õ���ʦ������ĳ���༶�����˵�����¼
				}else{//����actionlateReturn�����listTeacherlateReturn��������ѯ����¼���õ�һ��List����
					 sl = as.listTeacherlateReturn(userID,classID);
				}
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/TeacherlateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
		/*
		 * ѧ����ѯ�Լ�������¼
		 */
		if (type.equals("liststudent")) {
			//����һ��actionlateReturn����
			actionlateReturn as = new actionlateReturn();
			//����һ������
			List<listlateReturn> sl;
			try { 
				//����actionlateReturn�����listStulateReturn��������ѯ����¼���õ�һ��List����
					 sl = as.listStulateReturn(userID);
			
				//���õ����������request
				request.setAttribute("listlateReturn", sl);
				//����ת��
				RequestDispatcher rd = request
						.getRequestDispatcher("/page/lateReturn/StulateReturn_list.jsp");
				rd.forward(request, response);
			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//����doget��������
		doGet(request, response);

	}

}
