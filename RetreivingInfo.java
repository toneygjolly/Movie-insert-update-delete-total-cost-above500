package com.training.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.result.ResultSetMetaData;
import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;

public class RetreivingInfo {
private PreparedStatement stat;
private Connection con;
public RetreivingInfo()
{
	con=DataConnect.getConnection();
}
public void retreiveData() throws SQLException
{
	stat=con.prepareStatement("select*from movie");
	ResultSet result=stat.executeQuery();
	while(result.next())
	{
		System.out.println("Movie id is"+result.getInt(1));
		System.out.println("Movie name is"+result.getString(2));
		
	}
	ResultSetMetaData resultmeta=(ResultSetMetaData) result.getMetaData();
	System.out.println
	("Column name of first column is"+resultmeta.getColumnName(1));
	System.out.println("Totl column returned in result set"+resultmeta.getColumnCount());
	System.out.println("data type of 2nd column is"+resultmeta.getColumnTypeName(2));
}
public static void main(String args[] ) throws SQLException
{
	RetreivingInfo Retre=new RetreivingInfo();
	Retre.retreiveData();
}
}
