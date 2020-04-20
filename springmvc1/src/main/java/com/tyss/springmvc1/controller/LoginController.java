package com.tyss.springmvc1.controller;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.tyss.springmvc1.beans.Login;
import com.tyss.springmvc1.dao.LoginDAO;
import com.tyss.springmvc1.dao.LoginDAOI;

public class LoginController extends HttpServlet{

	LoginDAOI loginDAOI;
	
	public LoginController() {
		loginDAOI = new LoginDAO();
		}
	@Override
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		
		Login login = new Login();
		login.setUsername(req.getParameter("username"));
		login.setPassword(req.getParameter("password"));
	String status= loginDAOI.authenticate(login);
		if(status.equals("true")) {
			session.setAttribute("username1", login.getUsername());
			
			resp.sendRedirect("/springmvc1/listEmployee");
		} else if(status.equals("false")){
			resp.sendRedirect("/springmvc1/WEB_INF/views/index.jsp");
		}
	}
}
