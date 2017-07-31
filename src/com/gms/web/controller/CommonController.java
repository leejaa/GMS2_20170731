package com.gms.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gms.web.constant.Servlet;
import com.gms.web.util.DispatcherServlet;


@WebServlet("/common.do")
public class CommonController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fulldirectory=request.getServletPath();
		String directory=fulldirectory.substring(fulldirectory.indexOf("/")+1,fulldirectory.indexOf("."))+"/";
		String page=request.getParameter("page");
		String dest=Servlet.WEBINF+directory+page+".jsp";
		System.out.println(dest);
		DispatcherServlet.send(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
