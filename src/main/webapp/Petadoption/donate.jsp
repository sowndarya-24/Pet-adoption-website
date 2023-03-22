<%@ page language="java" import="java.sql.*"%>
<%
String powner=request.getParameter("powner");
String pname=request.getParameter("pname");
String pbreed=request.getParameter("pbreed");
String phone=request.getParameter("phone");
String date=request.getParameter("date");
String timing=request.getParameter("timing");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
PreparedStatement ps = con.prepareStatement("insert into donation(powner,pname,pbreed,phone,date,timing) values(?,?,?,?,?,?)");


ps.setString(1, powner);

ps.setString(2, pname);

ps.setString(3, pbreed);


ps.setString(4, phone);

ps.setString(5, date);

ps.setString(6, timing);

int x=ps.executeUpdate();
if(x>0)
{
	response.sendRedirect("Thankyou.html");

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