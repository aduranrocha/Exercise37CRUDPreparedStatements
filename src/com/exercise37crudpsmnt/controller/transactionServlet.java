package com.exercise37crudpsmnt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class transactionServlet
 */
@WebServlet("/transactionServlet")
public class transactionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources.properties");
		props.load(in);

		// 1. Variable declaration
		String urlServer = props.getProperty("urlServer");
		String user = props.getProperty("userName");
		String pass = props.getProperty("password");
		String sql1 = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES ('pa',10,'pa',10.0,'pa')";
		String sql2 = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES ('pe',10,'pa',10.0,'pe')";
		String sql3 = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES ('pi',10,'pa',10.0,'pi')";
		String sql4 = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES ('po',10,'pa',10.0,'po')";
		String sql5 = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES ('pu',10,'pa',10.0,'pu')";
		System.out.println("url: " + urlServer);
		// 2. Object  constructor
		Connection conn = null;
		PreparedStatement pstmnt = null;
		int rowAffected = 0;
	
		// it has a 'cj' 
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// 3. Connect DB
			conn = DriverManager.getConnection(urlServer,user,pass);
			conn.setAutoCommit(false);
			// 4. Prepared statement
			pstmnt = conn.prepareStatement(sql1);
			pstmnt.executeUpdate();
			pstmnt = conn.prepareStatement(sql2);
			pstmnt.executeUpdate();
			pstmnt = conn.prepareStatement(sql3);
			pstmnt.executeUpdate();
			pstmnt = conn.prepareStatement(sql4);
			pstmnt.executeUpdate();
			pstmnt = conn.prepareStatement(sql5);
			pstmnt.executeUpdate();
			
			conn.commit();
			// 5. Execute instruction
			// Make roll back
			// conn.rollback();
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException
				| NoSuchMethodException | SecurityException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmnt.close();
				conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

}
