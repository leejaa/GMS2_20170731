package com.gms.web.util;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.constant.Servlet;

public class DispatcherServlet {
	public static void send(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String fulldirectory=request.getServletPath();
		String directory=fulldirectory.substring(1,fulldirectory.indexOf("."))+"/";
		String page=request.getParameter("page");
		String dest=Servlet.WEBINF+directory+page+".jsp";
		System.out.println(dest);
		request.getRequestDispatcher(dest).forward(request, response);
	}
}
