package com.hweong.web;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc2")
public class Calc2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ServletContext application = req.getServletContext();
		resp.setCharacterEncoding("UTF-8");
		
		String value_= req.getParameter("value");
		String op = req.getParameter("operator");
		
		int value = 0;
		int result = 0;
		
		if(!value_.equals("")) value = Integer.parseInt(value_);
		
		if(op.equals("=")) {
			
			int x = (Integer)application.getAttribute("value");
			int y = value;
			String operator = (String)application.getAttribute("operator");
			
			if(operator.equals("+")) {
				result = x + y;
			}
			else {
				result = x - y;
			}
			
			resp.getWriter().printf("Result is %d", result);
		}
		else {
			
			application.setAttribute("value", value);
			application.setAttribute("operator", op);
		}
		
		
		
		
		
	}

}
