package com.training.info;

import java.sql.SQLException;

import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class RowSetExample {
JdbcRowSet rowset;
public RowSetExample() throws SQLException
{
	rowset=RowSetProvider.newFactory().createJdbcRowSet();
	rowset.setUrl("jdbc:mysql://localhost:3306/movies");
	rowset.setUsername("root");
	rowset.setPassword("Toney@123");
}
public void retreiveData() throws SQLException
{
	rowset.setCommand("select*from movie");
	rowset.execute();
	while(rowset.next())
	{
		System.out.println("movie id is"+rowset.getInt(1));
		System.out.println("movie name is"+rowset.getString(2));
		System.out.println("movie price"+rowset.getDouble(3));
		System.out.println("movie duration"+rowset.getDouble(4));
	}
}
public static void main(String args[]) throws SQLException {
	RowSetExample row=new RowSetExample();
	row.retreiveData();
}
}
