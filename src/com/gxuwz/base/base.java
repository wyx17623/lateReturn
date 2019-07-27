package com.gxuwz.base;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//封装此方法供请求转发使用
public class base {
	  public static void process(HttpServletRequest request,HttpServletResponse resp,String url)throws ServletException,IOException{
		  
		     RequestDispatcher rd=request.getRequestDispatcher(url);
		      rd.forward(request, resp);
		  }

}
