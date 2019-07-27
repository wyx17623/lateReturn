package com.gxuwz.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @author 
 * ʱ��  2019��6��10������9:17:00
 * Description:��½��������
 */
public class register implements Filter {
	  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//��ȡsession
		HttpSession session= ((HttpServletRequest) req).getSession();
	   //��session��ȡuserid��ֵ
	String userID = (String) session.getAttribute("userID");
	//�ж��û��Ƿ��½
	        if(userID==null){
	        	//��ȡresponse
	        	HttpServletResponse response =(HttpServletResponse) resp;
	        	//��ȡ��Ŀ��
	        	String path =((HttpServletRequest) req).getContextPath();
	        	//�ض��򵽵�½ҳ��
	        	response.sendRedirect(path+"/login.jsp");
	        }else{
	        	chain.doFilter(req, resp);
	        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
