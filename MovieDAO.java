package com.training.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;
import com.training.pojo.Movie;

public class MovieDAO {
	Scanner sc;
private Connection con;
private PreparedStatement stat;
private List<Movie>movielist;

public MovieDAO()
{
	con=DataConnect.getConnection();
	movielist=new ArrayList<Movie>();
}
//prepare stateme
public void insertData(List<Movie>movielist) throws SQLException
{
	/*stat=con.prepareStatement("insert into movie values(?,?,?,?)");
	stat.setInt(1,mov.getMovieid());
	stat.setString(2,mov.getMoviename());
	stat.setDouble(3,mov.getPrice());
	stat.setInt(4,mov.getDuration());
	int result= stat.executeUpdate();
	if(result>0) {
		System.out.println("Data inserted");
	}*/
	con.setAutoCommit(false);

	
	//Batch method
	stat=con.prepareStatement("insert into movie values(?,?,?,?)");
	for(Movie m:movielist)
	{
	stat.setInt(1,m.getMovieid());
	stat.setString(2,m.getMoviename());
	stat.setDouble(3,m.getPrice());
	stat.setInt(4,m.getDuration());
	stat.addBatch();
}
	int result[]=stat.executeBatch();
	if(result[0]>0)
	{
		System.out.println("inserted");
	}
	con.setAutoCommit(true);
}
public List<Movie> getDetails()throws SQLException
{
	stat=con.prepareStatement("select*from movie");
	ResultSet res=stat.executeQuery();
	while(res.next())
	{
		Movie m=new Movie();
		m.setMovieid(res.getInt(1));
		m.setMoviename(res.getString(2));
		m.setPrice(res.getDouble(3));
		m.setPrice(res.getInt(4));
		movielist.add(m);
	}
	return movielist;
}
public void deletedata(int moviecode) throws SQLException {
	stat=con.prepareStatement("delete from movie where moviecode="+moviecode+"");
	int result=stat.executeUpdate();
	if(result>0) {
		System.out.println("delete sucessfully");
	}
	
}
public void updatedata(String name,int update) throws SQLException
{
	stat=con.prepareStatement("update movie set movietittle='"+name+"' where moviecode= "+update+"");
	int result=stat.executeUpdate();
	if(result>0) {
		System.out.println("update sucessfully");
	}
}
public void calculatetotalPrice() throws SQLException {
	double totalprice;
	stat=con.prepareStatement("select sum(price) from movie");
	ResultSet result=stat.executeQuery();
	if(result.next())
	{
		totalprice =result.getDouble(1);
		System.out.println("Total is "+totalprice);
		
	}
}
public void retreivemoviename(String name) throws SQLException, Filenotfound
{
	stat=con.prepareStatement("select* from movie where movietittle='"+name+"'");
	
	//stat.setString(1,sc.next());
	ResultSet result=stat.executeQuery();
	if(result.next()) {
		System.out.println("movie code"+result.getInt(1));
		System.out.println("movie name"+result.getString(2));
		System.out.println("movie price"+result.getDouble(3));
		System.out.println("movie duration"+result.getDouble(4));
	}
	else
	{
		throw new Filenotfound();
	}
	
	
	
}
public void above500() throws SQLException {
	stat=con.prepareStatement("select*from movie where price>500");
	ResultSet result=stat.executeQuery();
	if(result.next()) {
		System.out.println("movie code"+result.getInt(1));
		System.out.println("movie name"+result.getString(2));
		System.out.println("movie price"+result.getDouble(3));
		System.out.println("movie duration"+result.getDouble(4));
	}
}
}
