package com.Modal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBval {

	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
	private static final String DB_USERNAME = "Sowndarya";
	private static final String DB_PASSWORD = "Sowndary@24";

	public int  validateDtls(String strEmail,String strPassWrd)
	{
		Connection conn = null;
		ResultSet rs = null;
		PreparedStatement stmt = null;
		int iCount = 0;
		String strQry = "";
		try
		{
			// Register the JDBC driver
			Class.forName(DB_DRIVER);

			// Open the connection
			conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

			if (conn != null)
			{
			
				
				strQry = "select count(email) as count from user where email = ? and password = ?";
				stmt = conn.prepareStatement(strQry);
				stmt.setString(1,strEmail);
				stmt.setString(2,strPassWrd);
				rs = stmt.executeQuery();
				while (rs.next())
				{
					if(rs.getInt(1) == 1)
					{
						iCount = 1;
					}
					else
					{
						iCount = 0;
					}
				}
				
			}
			else
			{
				System.out.println("Failed to connect.");
			}
		}
		catch ( SQLException e )
		{
			e.printStackTrace();
		}
		catch ( ClassNotFoundException e )
		{
			e.printStackTrace();
		}
		finally
		{
			try {
				stmt.close();
				rs.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return iCount;
}
}