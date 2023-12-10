package com.training.client;

import java.sql.SQLException;
import java.util.Scanner;

import com.training.dao.Filenotfound;
import com.training.service.MovieService;

public class MovieMenu {
	int choice;
	String ch="Y";
	Scanner sc;
	MovieService movieservice;
	public MovieMenu()
	{
		sc=new Scanner(System.in);
		movieservice=new MovieService();
	}
	public void createMenu() throws SQLException, Filenotfound {
		while(ch.equals("Y"))
		{
			System.out.println("******1.Insert Movie*******");
			System.out.println("******2.Delete Movie*******");
			System.out.println("******3.update Movie*******");
			System.out.println("******4.view Movie*******");
			System.out.println("******5.total money spent on all movie*******");
			System.out.println("***********6.Enter the movie name");
			System.out.println("***********7.Enter the movie price above 500 ");

			System.out.println("******8.exit*******");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				movieservice.insertMovie();
				break;
			case 2:
				movieservice.deletedata();
				break;
			case 3:
				movieservice.updatedata();
				break;
			case 4:
				movieservice.retreiveData();
				break;
			case 5:
				movieservice.calculatetotalPrice();
			case 6:
				movieservice.retreivemoviename();
			case 7:
				movieservice.above500();
			case 8:
				System.exit(0);
				break;
			}
			System.out.println("did you want to continue");
			ch=sc.next();
		}
	}

}
