package com.hweong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		String op = req.getParameter("button");
		
		int x = 0;
		int y = 0;
		int result = 0;
		
		if(x_ != null && x_ != "") {
			x = Integer.parseInt(x_);
		}
		else {
			x = 0;
		}
		
		if(y_ != null && y_ != "") {
			y = Integer.parseInt(y_);
		}
		else {
			y = 0;
		}
		
		
		
		System.out.println(x);
		
		if(op.equals("plus")) {
			result = x + y;
			
		}
		else if(op.equals("minus")) {
			result = x - y;
		}
		System.out.println(result);
		
		resp.getWriter().printf("Result is %d", result);
		
	}

}
