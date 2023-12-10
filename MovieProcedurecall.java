package com.training.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;
import com.training.connect.DataConnect;

public class MovieProcedurecall {
private Connection con;
private java.sql.CallableStatement stat;
private Scanner sc;
public MovieProcedurecall()
{
	con=DataConnect.getConnection();
	sc=new Scanner(System.in);
	
}
public void callingprocedure()throws SQLException
{
	System.out.println("enter the movie id which u have details");
	int movieid=sc.nextInt();
	stat=con.prepareCall("{call GetMovieDetailss(?,?)}");
	stat.setInt(1,movieid);
	stat.registerOutParameter(2,Types.VARCHAR);
	stat.executeUpdate();
	String moviename=stat.getString(2);
	System.out.println("Movie name is "+moviename);
}
public static void main(String args[]) throws SQLException {
	MovieProcedurecall moviepro=new MovieProcedurecall();
	moviepro.callingprocedure();
}
}
