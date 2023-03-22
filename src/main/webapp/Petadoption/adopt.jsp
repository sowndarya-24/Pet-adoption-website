<%@ page language="java" import="java.sql.*"%>
<%
String powner=request.getParameter("powner");
String phone=request.getParameter("phone");
String date=request.getParameter("date");
String time=request.getParameter("time");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
PreparedStatement ps = con.prepareStatement("insert into adopt(powner,phone,date,time) values(?,?,?,?)");


ps.setString(1, powner);
ps.setString(2, phone);

ps.setString(3, date);

ps.setString(4, time);

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