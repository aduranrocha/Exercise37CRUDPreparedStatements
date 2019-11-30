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
 * Servlet implementation class updateServlet
 */
@WebServlet("/updateServlet")
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset='UTF-8'");
		PrintWriter output = response.getWriter();
		Employee myEmployee = new Employee();
		// Set the values into the object
		myEmployee.setIdEmployee(Integer.parseInt(request.getParameter("txtIdEmployee")));
		myEmployee.setNameEmployee(request.getParameter("txtNameEmployee"));
		myEmployee.setAgeEmployee(Integer.parseInt(request.getParameter("txtAgeEmployee")));
		myEmployee.setAddressEmployee(request.getParameter("txtAddressEmployee"));
		myEmployee.setSalaryEmployee(Double.parseDouble(request.getParameter("txtSalaryEmployee")));
		myEmployee.setDepartmentEmployee(request.getParameter("txtDeparmentEmployee"));
		
		
		// 1. Variable modification
		Properties props = new Properties();
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("resources.properties");
		props.load(in);
		String urlServer = props.getProperty("urlServer");
		String user = props.getProperty("userName");
		String pass = props.getProperty("password");
		String sentenceSQL = "UPDATE Employee SET nameEmployee = ?, ageEmployee = ? , addressEmployee = ? , salaryEmployee = ?, departmentEmployee = ? WHERE idEmployee = ?";
		int rowsAffected = 0;
		
		// 2. Object inicialization
		Connection conn = null;
		PreparedStatement pstmnt = null;
		
		try {
			// 3. Connection driver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// 4. Open connection
			conn = DriverManager.getConnection(urlServer,user,pass);
			// 5. Prepare stmnt
			pstmnt = conn.prepareStatement(sentenceSQL);

			pstmnt.setString(1, myEmployee.getNameEmployee());
			pstmnt.setInt(2, myEmployee.getAgeEmployee());
			pstmnt.setString(3, myEmployee.getAddressEmployee());
			pstmnt.setDouble(4, myEmployee.getSalaryEmployee());
			pstmnt.setString(5, myEmployee.getDepartmentEmployee());
			pstmnt.setInt(6, myEmployee.getIdEmployee());
			// 6. SQL statement
			rowsAffected = pstmnt.executeUpdate();

			if(rowsAffected > 0) {
				output.append("Registro modificado con exito");
			}
			else {
				output.append("Registro NO modificado!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmnt.close();
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
