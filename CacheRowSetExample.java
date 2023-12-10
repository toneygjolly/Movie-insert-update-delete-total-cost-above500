package com.training.info;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

public class CacheRowSetExample {
CachedRowSet rowset;
public CacheRowSetExample() throws SQLException
{
	rowset=RowSetProvider.newFactory().createCachedRowSet();
	rowset.setUrl("jdbc:mysql://localhost:3306/movies?relaxAutoCommit=true");
	rowset.setUsername("root");
	rowset.setPassword("Toney@123");
}
public void operation() throws SQLException
{
	rowset.setCommand("select*from movie");
	rowset.execute();
	rowset.next();
	rowset.moveToInsertRow();
	
	rowset.updateInt(1,5);
	rowset.updateString(2,"New movie");
	rowset.updateDouble(3,9000);
	rowset.updateDouble(4, 6);
	rowset.insertRow();
	System.out.println("Inseted");
}
public static void main(String args[]) throws SQLException {
	CacheRowSetExample cache=new CacheRowSetExample();
	cache.operation();
}

}
