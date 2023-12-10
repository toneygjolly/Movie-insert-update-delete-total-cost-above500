package com.training.client;

import java.sql.SQLException;

import com.training.dao.Filenotfound;

public class Main {
public static void main(String args[]) throws SQLException {
	MovieMenu menu=new MovieMenu();
	try {
		menu.createMenu();
	} catch (Filenotfound e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
	}
}
}
