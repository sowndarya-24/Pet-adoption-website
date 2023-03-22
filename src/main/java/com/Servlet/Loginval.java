package com.Servlet;
import java.io.IOException;
import com.Modal.DBval;

	import javax.servlet.ServletException;
	import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;


	/**
	 * Servlet implementation class LoginValidation
	 */
	@WebServlet("/Loginval")
	public class Loginval extends HttpServlet {
		private static final long serialVersionUID = 1L;

		/**
		 * @see HttpServlet#HttpServlet()
		 */
		public Loginval() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			response.getWriter().append("Invalid Request - Not Allowed To Access");
		}

		/**
		 * 
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
		 *      response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			String strEmail = "";
			String strPassWrd = "";

			int iCount = 0;
			strEmail = request.getParameter("email");

			strPassWrd = request.getParameter("password");

			DBval objDB = new DBval();
			
			iCount = objDB.validateDtls(strEmail,strPassWrd);
			
			if(iCount == 0)
			{	
				response.sendRedirect("Petadoption/login.html");
				
			}
			else
			{
				response.sendRedirect("Petadoption/services.jsp");
			}
			
		}

	}

