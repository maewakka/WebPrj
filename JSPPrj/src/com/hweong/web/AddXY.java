package com.hweong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add")
public class AddXY extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String x_ = req.getParameter("x");
		String y_ = req.getParameter("y");
		
		int x = 0;
		int y = 0;
		
		if(x_ != null && x_ != "") {
			x = 0;
		}
		if(y_ != null && y_ != "") {
			y = 0;
		}
		
		x = Integer.parseInt(x_);
		y = Integer.parseInt(y_);
		
		int result = x + y;
		
		resp.getWriter().printf("Result is %d", result);
		
	}

}
