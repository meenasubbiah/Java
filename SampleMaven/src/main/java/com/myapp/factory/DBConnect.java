package com.myapp.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	private static DBConnect dbcon=null;
	private int flag=0;
	private static Connection con=null;
	
	
	private DBConnect(){
		try{
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
				System.out.println("Driver loaded");
				con=DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/meenadb", "SA", "");
				System.out.println("Connected to db");
		}catch(SQLException | ClassNotFoundException e){
			e.printStackTrace();
			throw new RuntimeException(e);
	}}
	
	public static Connection getConnection(){
		if(dbcon==null){
			dbcon=new DBConnect();
		}
		return con;
	}	

}
