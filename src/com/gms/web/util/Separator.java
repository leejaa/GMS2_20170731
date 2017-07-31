package com.gms.web.util;

import javax.servlet.http.HttpServletRequest;

import com.gms.web.constant.Servlet;

public class Separator {
	public static String init(HttpServletRequest request){
		String fulldirectory=request.getServletPath();
		String directory=fulldirectory.substring(1,fulldirectory.indexOf("."))+"/";
		String page=request.getParameter("page");
		String dest=Servlet.WEBINF+directory+page+".jsp";
		System.out.println(dest);
		return dest;
	}
}
