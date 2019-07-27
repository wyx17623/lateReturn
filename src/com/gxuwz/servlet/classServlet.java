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
             //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��
         	 String type =request.getParameter("type");
        	//ϵͳ����Ա��ѯ���а༶��Ϣ
    		if(type.equals("list")){
    			//����һ��actionclass����
    			actionclass as =new actionclass();
    			 try {
    				 //����actionclass�����listcalsses�����õ�һ��list
    				List<listclasses> sl=as.listclasses();
    				//��list����request������
    				request.setAttribute("listclasses",sl);
    				//����ת����ָ��ҳ��
    				RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
    		//ϵͳ����Ա�޸����а༶��Ϣ
    		if(type.equals("add")){
    			//����ҳ��Ĳ���
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                String grade = request.getParameter("grade");
                String depID = request.getParameter("depID");
                String teacherID = request.getParameter("teacherID");
                //����һ��actionclass����
    			actionclass as =new actionclass( classID,  className, grade, depID,teacherID);
    			try {
    				//����actionclass��addclass��ӷ���
    				as.addclasses();
    				//����actionclass��listclass�Ĳ�ѯ�����õ�һ��list����
    				List<listclasses> sl=as.listclasses();
    				//���������request������
    				request.setAttribute("listclasses",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		      rd.forward(request, response);
    		}
    		//ϵͳ����Ա�޸İ༶��Ϣ
    		if(type.equals("update")){
    			//���ܲ���
    			String classID = request.getParameter("classID");
                String className = request.getParameter("className");
                String grade = request.getParameter("grade");
                String depID = request.getParameter("depID");
                String teacherID = request.getParameter("teacherID");
                //����һ��actionclass��
    			actionclass as =new actionclass( classID,  className, grade, depID,teacherID);
    			try {
    				//����actionclass���update����
    				as.updateclasses();
    				//����actionclass���listclass��ѯ�������õ�һ��list����
    				List<listclasses> sl=as.listclasses();
    				//��list�������request������
    				request.setAttribute("listclasses",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		    rd.forward(request, response);
    		}
    		//ϵͳ����Աɾ���༶��Ϣ
    	if(type.equals("remove")){
    		//���ܲ���
    		String classID = request.getParameter("classID");
    	//����һ��actionclass����
    		actionclass as =new actionclass();
    		 try {
    			 //����actionclass��removeclassesɾ������
    			 as.removeclasses(classID);
    			 //����actionclass��listclasses��ѯ�������õ�һ��list����
    			List<listclasses> sl=as.listclasses();
    			//��list�������request������
    			request.setAttribute("listclasses",sl);
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/classes/classes_list.jsp");
    		      rd.forward(request, response);
    		} catch (Exception e) {
    			
    			e.printStackTrace();
    		}
    		}
	
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//dost��������doget��������
                  doGet(request,response);
	}

}
