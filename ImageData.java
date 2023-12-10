package com.training.info;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Blob;
import com.mysql.cj.protocol.Resultset;
import com.training.connect.DataConnect;

public class ImageData {
private Connection con;
private PreparedStatement stat;

public ImageData()
{
	con=DataConnect.getConnection();
}
public void insertImage() throws SQLException, IOException
{
	stat=con.prepareStatement("insert into image values(?,?)");
	stat.setString(1,"First Imgage");
	FileInputStream input
	=new FileInputStream("/home/administrator/Documents/ktu/download.jpeg");
	stat.setBinaryStream(2,input,input.available());
	int result=stat.executeUpdate();
	if(result>0)
	{
		
		System.out.println("Data inserted");
	}
}
public void readimage() throws SQLException, IOException
{
	stat=con.prepareStatement("select emppic from image where empname=?");
	stat.setString(1,"First Imgage");
	ResultSet result=stat.executeQuery();
	if(result.next())
	{
		Blob imagedata=(Blob) result.getBlob(1);
		byte arr[]=imagedata.getBytes(1,(int)imagedata.length());
		FileOutputStream output=new FileOutputStream("/home/administrator/Documents/ktu/data.jpeg");
		output.write(arr);
		System.out.println("File created");
		
	}
}
public static void main(String args[]) throws SQLException, IOException {
	ImageData Img=new ImageData();
	Img.insertImage();
	Img.readimage();
}
}
