<%@ page language="java" import="java.sql.*"%>
<%
String powner=request.getParameter("powner");
String pname=request.getParameter("pname");
String pbreed=request.getParameter("pbreed");
String service=request.getParameter("service");
String phonenumber=request.getParameter("phonenumber");
String date=request.getParameter("date");

try
{
Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/user","Sowndarya","Sowndary@24");
PreparedStatement ps = con.prepareStatement("insert into grooming(powner,pname,pbreed,service,phonenumber,date) values(?,?,?,?,?,?)");


ps.setString(1, powner);

ps.setString(2, pname);

ps.setString(3, pbreed);

ps.setString(4, service);

ps.setString(5, phonenumber);

ps.setString(6, date);
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