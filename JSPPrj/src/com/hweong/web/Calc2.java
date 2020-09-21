package com.hweong.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		HttpSession session = req.getSession();
		
		Cookie[] cookies = req.getCookies();
		
		resp.setCharacterEncoding("UTF-8");		
		resp.setContentType("text/html; charset=UTF-8");
		
		String value_= req.getParameter("value");
		String op = req.getParameter("operator");
		
		String v = "";
		
		int value = 0;
		int x = 0;
		int result = 0;
		
		if(!value_.equals("")) value = Integer.parseInt(value_);
		
		if(op.equals("=")) {
			
			
			//int x = (Integer)application.getAttribute("value");
			//int x = (Integer)session.getAttribute("value");

			for(Cookie c : cookies) {
				if(c.getName().equals("value")) {
					x = Integer.parseInt(c.getValue());
					break;
				}
			}
			
			int y = value;
			String operator = "" ;
			//String operator = (String)session.getAttribute("operator");
			
			for(Cookie c : cookies) {
				if(c.getName().equals("op")) {
					operator = c.getValue();
					break;
				}
			}
			
			
			if(operator.equals("+")) {
				result = x + y;
			}
			else {
				result = x - y;
			}
			
			resp.getWriter().printf("Result is %d", result);
		}
		else {
			
			//application.setAttribute("value", value);
			//application.setAttribute("operator", op);
			
			//session.setAttribute("value", value);
			//session.setAttribute("operator", op);
			
			Cookie valuecookie = new Cookie("value", Integer.toString(value));
			Cookie opcookie = new Cookie("op", op);
			
			valuecookie.setMaxAge(24 * 60 * 60);
			opcookie.setMaxAge(24 * 60 * 60);
			
			resp.addCookie(valuecookie);
			resp.addCookie(opcookie);
		}
		
		
		
		
		
	}

}
