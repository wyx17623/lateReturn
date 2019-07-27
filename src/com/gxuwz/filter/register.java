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
 * 时间  2019年6月10日下午9:17:00
 * Description:登陆过滤拦截
 */
public class register implements Filter {
	  
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {
		//获取session
		HttpSession session= ((HttpServletRequest) req).getSession();
	   //从session中取userid的值
	String userID = (String) session.getAttribute("userID");
	//判断用户是否登陆
	        if(userID==null){
	        	//获取response
	        	HttpServletResponse response =(HttpServletResponse) resp;
	        	//获取项目名
	        	String path =((HttpServletRequest) req).getContextPath();
	        	//重定向到登陆页面
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
