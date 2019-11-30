package com.exercise37crudpsmnt.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.exercise37crudpsmnt.model.Employee;

/**
 * @author adura
 * @version 1.0
 * @see Method to create a Employee
 */
@WebServlet("/createServlet")
public class createServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html charset='UTF-8'");
		PrintWriter output = response.getWriter();
		// Create object to send the data
		Employee myEmployee = new Employee();
		// Set the values into the object
		//myEmployee.setIdEmployee(Integer.parseInt(request.getParameter("txtIdEmployee")));
		myEmployee.setNameEmployee(request.getParameter("txtNameEmployee"));
		myEmployee.setAgeEmployee(Integer.parseInt(request.getParameter("txtAgeEmployee")));
		myEmployee.setAddressEmployee(request.getParameter("txtAddressEmployee"));
		myEmployee.setSalaryEmployee(Double.parseDouble(request.getParameter("txtSalaryEmployee")));
		myEmployee.setDepartmentEmployee(request.getParameter("txtDepartmenteEmployee"));
		// 1. Variable Declaration
		String urlServer ="jdbc:mysql://localhost:3306/store?useSSL=false&serverTimezone=UTC";
		String userName = "root";
		String password = "root";
		int rowsAffected = 0;
		String sentenceSQLPreparedStmnt = "INSERT INTO Employee (nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) VALUES(?,?,?,?,?)";

		// 2. Object construction
		Connection conn = null;
		PreparedStatement pstmnt= null;
		
	
		try {
			// 3. Instance driver
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			// 4. Open connection
			conn = DriverManager.getConnection(urlServer,userName,password);
		
			pstmnt = conn.prepareStatement(sentenceSQLPreparedStmnt);
			pstmnt.setString(1, myEmployee.getNameEmployee());
			pstmnt.setInt(2, myEmployee.getAgeEmployee());
			pstmnt.setString(3, myEmployee.getAddressEmployee());
			pstmnt.setDouble(4, myEmployee.getSalaryEmployee());
			pstmnt.setString(5, myEmployee.getDepartmentEmployee());
			
			rowsAffected = pstmnt.executeUpdate();
			/* INSERT INTO Employee ("
			+ "nameEmployee,ageEmployee,addressEmployee,salaryEmployee,departmentEmployee) "
			+ "VALUES ('" + myEmployee.getNameEmployee() + "'," + myEmployee.getAgeEmployee() + "'," + myEmployee.getAddressEmployee( ) + "'," + myEmployee.getSalaryEmployee() +"'," + myEmployee.getDepartmentEmployee() +")"
			*/
			if(rowsAffected > 0) {
				output.append("Registro añadido con exito");
			}
			else {
				output.append("Registro NO añadido!");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				pstmnt.close();
				conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		output.close();
	}

}
