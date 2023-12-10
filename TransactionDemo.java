package com.training.info;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;

public class TransactionDemo {
private Connection con;
private PreparedStatement stat;
private Scanner sc;


public TransactionDemo()
{
	sc=new Scanner(System.in);
	con=DataConnect.getConnection();
}
public void updateBalance() throws SQLException
{
	con.setAutoCommit(false);
	double balance1=0;
	stat=con.prepareStatement("select balance from Account where customercode=101");
	ResultSet resultdata=stat.executeQuery();
	if(resultdata.next()) {
		balance1=resultdata.getDouble(1);
	}
	System.out.println("Enter the amount which u want to withdrew");
	double amtdata=sc.nextDouble();
	if(amtdata>balance1) {
		con.rollback();
	}
	else
	{
		stat=con.prepareStatement("update Account set balance=balance-"+amtdata+"where customercode=101");
				int result=stat.executeUpdate();
		if(result>0)
		{
			System.out.println("First Account updated");
		}
		stat=con.prepareStatement("update Account set balance=balance +"+amtdata+" where customercode=102");
		int result1=stat.executeUpdate();
		if(result>0)
		{
			System.out.println("Second account also updated");
		}
		con.setAutoCommit(true);
	}
}
public static void main(String args[]) throws SQLException {
	TransactionDemo demo=new TransactionDemo();
	demo.updateBalance();
}
}