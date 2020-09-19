package com.hweong.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TEST extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = resp.getWriter();
		
		String cnt_t = req.getParameter("cnt");
		
		int cnt = 0;
		
		if (cnt_t != null && cnt_t != "") {
			cnt = Integer.parseInt(cnt_t);
			for (int i=0; i<cnt; i++) {
				out.println((i+1) + " : Hello Servlet~!<br>");
			}
		}
		else {
			out.println("Input Error");
		}
		
	}

}
