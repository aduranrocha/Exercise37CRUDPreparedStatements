package com.exercise37crudpsmnt.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise37crudpsmnt.model.Employee;

/**
 * Servlet implementation class readOneServlet
 */
@WebServlet("/readOneServlet")
public class readOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset='UTF-8'");
		PrintWriter output = response.getWriter();
		// Create object to send data
		Employee myEmployee = new Employee();
		// Set the values into object
		myEmployee.setIdEmployee(Integer.parseInt(request.getParameter("txtIdEmployee")));
		// 1. Variable modification
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources.properties");
		props.load(in);
		
		String urlServer = props.getProperty("urlServer");
		String user = props.getProperty("userName");
		String pass = props.getProperty("password");
		String sentenceSQL = "SELECT * FROM Employee WHERE idEmployee = ?";
		
		// 2. Object Declaration
		Connection conn = null;
		PreparedStatement pstmnt = null;
		ResultSet rs = null;
		try {
			// 3. Connector Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// 4. Open Connection
			conn = DriverManager.getConnection(urlServer,user,pass);
			// 5. Prepare statement
			pstmnt = conn.prepareStatement(sentenceSQL);
			pstmnt.setInt(1, myEmployee.getIdEmployee());
			// 6. SQL Statement
			rs = pstmnt.executeQuery();
			// 7. Data process
			while(rs.next()) {
				output.append("<p>");
				output.append("ID Employee: " + rs.getInt(1));
				output.append("<br/>");
				output.append("Employee Name: " + rs.getString("nameEmployee"));
				output.append("<br/>");
				output.append("Employee Age: " + rs.getInt("ageEmployee"));
				output.append("<br/>");
				output.append("Employee Address: " + rs.getString("addressEmployee"));
				output.append("<br/>");
				output.append("Employee Salary: " + rs.getDouble("salaryEmployee"));
				output.append("<br/>");
				output.append("Employee Department: " + rs.getString("departmentEmployee"));
				output.append("</p>");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally {
			try {
				// 8. Close 
				rs.close();
				pstmnt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		output.close();
	}

}
