package com.Dao;
import java.sql.*;
public class ConProvider {

	public static Connection getConnection(){
	Connection con=null;
	//1.load driver
	try {
		Class.forName("oracle.jdbc.OracleDriver");
		con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","SYSTEM","Newuser123");
		System.out.println("Connection to db..");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("catch connection..");
	} catch (SQLException e) {
		System.out.println("catch connection..2");
		e.printStackTrace();
	}
	return con;
}
}
