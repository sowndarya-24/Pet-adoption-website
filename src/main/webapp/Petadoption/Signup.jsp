<%@ page language="java" import="java.sql.*"  %>
<%
String fname=request.getParameter("fname");
String lname=request.getParameter("lname");
String email=request.getParameter("email");
String phone=request.getParameter("phone");
String password=request.getParameter("password");


try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
PreparedStatement ps = con.prepareStatement("insert into user(fname,lname,email,phone,password) values(?,?,?,?,?)");


ps.setString(1, fname);

ps.setString(2, lname);

ps.setString(3, email);

ps.setString(4, phone);

ps.setString(5, password);
int x=ps.executeUpdate();
if(x>0)
{
	response.sendRedirect("login.html");

}
else
{
	System.out.println("Data not saved");
	
}
}
catch(Exception e)
{
	response.sendRedirect("error.html");

}
%>