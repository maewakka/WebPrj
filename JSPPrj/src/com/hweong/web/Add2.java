package com.hweong.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/add2")
public class Add2 extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String[] num_s = req.getParameterValues("num");		
		
		int result = 0;
		
		for(int i=0; i<num_s.length; i++) {
			int num = Integer.parseInt(num_s[i]);
			result += num;
		}
		
		resp.getWriter().printf("Result is %d", result);
		
	}

}
