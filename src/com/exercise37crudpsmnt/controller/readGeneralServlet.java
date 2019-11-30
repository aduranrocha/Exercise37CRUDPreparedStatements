package com.exercise37crudpsmnt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;
/**
 * Servlet implementation class readGeneralServlet
 */
@WebServlet("/readGeneralServlet")
public class readGeneralServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset='UTF-8'");
		PrintWriter output = response.getWriter();
		// 1. Variable modification
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources.properties");
		props.load(in);
		
		String urlServer = props.getProperty("urlServer");
		String user = props.getProperty("userName");
		String pass = props.getProperty("password");
		/*
		output.append("url: " + urlServer);
		output.append("user: " + user);
		output.append("password: " + pass);
		 */
		output.close();
	}

}
