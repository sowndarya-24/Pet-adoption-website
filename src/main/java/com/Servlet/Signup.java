package com.Servlet;

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
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement st = null;
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();		
		
		try{ 
			String password = request.getParameter("password");
			
			int key = 3;
			String en_pword = "";
			
			char[] chars1 = password.toCharArray();
			for(char c: chars1)
			{
				c+= key;
				en_pword += c;
			}
	
			
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String email=request.getParameter("email");
			String phone=request.getParameter("phone");
		    
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
			PreparedStatement ps = conn.prepareStatement("insert into user(fname,lname,email,phone,password) values(?,?,?,?,?)");


			ps.setString(1, fname);

			ps.setString(2, lname);

			ps.setString(3, email);

			ps.setString(4, phone);

			ps.setString(5, en_pword);
			
			response.sendRedirect("Petadoption/login.html");

			
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			response.sendRedirect("error.html");

		}
		
	}
}