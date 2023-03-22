<%@ page language="java" import="java.sql.*"%>
<%
String name=request.getParameter("name");
String email=request.getParameter("email");
String message=request.getParameter("message");

try
{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
	PreparedStatement ps = con.prepareStatement("insert into feedback(name,email,message) values(?,?,?)");
	
	ps.setString(1, name);
	
	ps.setString(2, email);
	
	ps.setString(3,message);
	
	int x = ps.executeUpdate();
	if(x>0)
	{
	System.out.println("Data saved successfully");
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