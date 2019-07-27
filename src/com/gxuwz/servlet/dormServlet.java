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
 * ʱ�䣺2019��6��12������3:01:19
 * Description:���ᴦ����
 */
public class dormServlet extends HttpServlet {	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {   
		 //��ȡҳ�洫�ݵĲ������������õķ������ߵ�·��     
         	 String type =request.getParameter("type");
         	 /*
         	  * ϵͳ����Ա��ѯ������Ϣ
         	  */
    		if(type.equals("list")){
    			//����һ��actiondorm����
    			actiondorm as =new actiondorm();
    			 try {
    				 //����actiondorm�����listdorm������ѯ���е�������Ϣ���õ�һ��List����
    				List<listdorm> sl=as.listdorm();
    				//���õ���List�������request������
    				request.setAttribute("dormlist",sl);
    				//����ת��
    				RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    			      rd.forward(request, response);
    			} catch (Exception e) {
    				
    				e.printStackTrace();
    			}
    		}
           /*
            * ϵͳ����Ա���������Ϣ
            */
    		if(type.equals("add")){
    			//��ȡ����
    			String dormID= request.getParameter("dormID");
                String dormName = request.getParameter("dormName");
                String dormBuildingID = request.getParameter("dormBuildingID");
              //����һ��actiondorm����
                actiondorm as =new actiondorm(dormID,dormName,dormBuildingID);
    			try {
    				as.adddorm();
    				 //����actiondorm�����listdorm������ѯ���е�������Ϣ���õ�һ��List����
    				List<listdorm> sl=as.listdorm();
    				//���õ���List�������request������
    				request.setAttribute("dormlist",sl);
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    		      rd.forward(request, response);
    		}
    		if(type.equals("update")){
    			//������ȡ
    			String dormID = request.getParameter("dormID");
                String dormName = request.getParameter("dormName");
                String dormBuildingID = request.getParameter("dormBuildingID");
              //����һ��actiondorm����
    			actiondorm as =new actiondorm(dormID, dormName, dormBuildingID);
    			try {
    				as.updatedorm();
    				 //����actiondorm�����listdorm������ѯ���е�������Ϣ���õ�һ��List����
    				List<listdorm> sl=as.listdorm();
    				//���õ���List�������request������
    				request.setAttribute("dormlist",sl);
    			
    			} catch (Exception e) {
    				e.printStackTrace();
    			}	//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
    		    rd.forward(request, response);
    		}
    	if(type.equals("remove")){
    		//������ȡ
    		String dormID = request.getParameter("dormID");
    		//����һ��actiondorm����
    		actiondorm as =new actiondorm();
    		 try {
    			 as.removedorm(dormID);
    			 //����actiondorm�����listdorm������ѯ���е�������Ϣ���õ�һ��List����
    			List<listdorm> sl=as.listdorm();
    			//���õ���List�������request������
    			request.setAttribute("dormlist",sl);
    			//����ת��
    			RequestDispatcher rd=request.getRequestDispatcher("/page/dorm/dorm_list.jsp");
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
