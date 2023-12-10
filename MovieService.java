package com.training.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.training.dao.Filenotfound;
import com.training.dao.MovieDAO;
import com.training.pojo.Movie;

public class MovieService {
private Scanner sc;
private MovieDAO moviedao;
private List<Movie>moviedata;
public MovieService() {
	sc=new Scanner(System.in);
	moviedao=new MovieDAO();
	    moviedata=new ArrayList<Movie>();
}
public void insertMovie() throws SQLException
{
	System.out.println("Enter the how many movie detail u want to enter");
	int no=sc.nextInt();
	for(int i=0;i<no;i++) {
	Movie mov=new Movie();
	System.out.println("Enter the movie code");
	mov.setMovieid(sc.nextInt());
	System.out.println("Enter the movie tittle");
	mov.setMoviename(sc.next());
	System.out.println("Enter the price");
	mov.setPrice(sc.nextDouble());
	System.out.println("Enter the duration");
	mov.setDuration(sc.nextInt());
	             moviedata.add(mov);
	//moviedao.insertData(mov);
	}
	moviedao.insertData(moviedata);
}
public void retreiveData()throws SQLException
{
	List<Movie>movieretreive=moviedao.getDetails();
	for(Movie m:movieretreive)
	{
		System.out.println("Movie title is "+m.getMoviename());
		System.out.println("Movie price"+m.getPrice());
	}
}
public void deletedata() throws SQLException {
	System.out.println("enter the movie code which want to delete");
	int delete=sc.nextInt();
	moviedao.deletedata(delete);
	
}
public void updatedata() throws SQLException
{
	System.out.println("enter the movie code which want to update");
	int update=sc.nextInt();
	System.out.println("Enter the new movie name");
	String name=sc.next();
	moviedao.updatedata(name,update);

}
public void calculatetotalPrice() throws SQLException{
	System.out.println("total money spent on all movie");
	moviedao.calculatetotalPrice();
}
public void retreivemoviename() throws SQLException, Filenotfound
{
	System.out.println("Enter the movie name ");
	String name=sc.next();
	moviedao.retreivemoviename(name);
}
public void above500() throws SQLException
{
	System.out.println("above 500");
	moviedao.above500();
}

}
