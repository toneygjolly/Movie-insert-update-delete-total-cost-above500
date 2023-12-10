package com.training.info;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;

public class UpdateresultsetExample {
public static void main(String args []) throws SQLException
{
	Connection con=DataConnect.getConnection();
	Statement st=con.createStatement
			(ResultSet.TYPE_SCROLL_SENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
	ResultSet rs=st.executeQuery("select*from movie");
	rs.next();
	rs.updateInt(1,111);
	rs.updateRow();
	System.out.println("1 row updated");
	rs.moveToInsertRow();
	rs.updateInt(1,1005);
	rs.updateString(2,"YYYYr");
	rs.updateDouble(3, 799);
    rs.updateDouble(4,3);
    rs.insertRow();
    rs.absolute(4);
    rs.updateString(2,"Data");
    rs.updateRow();
    
    
    
    System.out.println("Data updated");
    System.out.println("1. row updated");
    System.out.println("After updation");
    con.close();
}
}
