package com.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;

import com.model.AddressLine;
import com.model.Details;
import com.model.Login;
public class RegisterDao {


//	public static int save(){
//		int status=0;
//		
//		try{
//			Login l = new Login();
//			AddressLine a=new AddressLine();
//			Details d = new Details(l,a);
//
//			Connection con=ConProvider.getConnection();
//			PreparedStatement ps=con.prepareStatement("insert into REGISTRATION_USER(id) values(REGISTRATION_ID.NEXTVAL,?,?,?,?,?,?,?,?,?)");
//			ps.setString(1,d.getName());
//			ps.setString(2,d.getEmail());
//			ps.setString(3,d.getPassword());
//			ps.setString(4,d.getGender());
//			ps.setString(5,d.getAddressLine());
//			ps.setString(6,d.getCity());
//			ps.setString(7,d.getState());
//			ps.setString(8,d.getState());
//			ps.setString(9,d.getContact());
//			
//			status=ps.executeUpdate();
//						
//		}catch(Exception e){System.out.println(e);}
//		
//		
//		
//		return status;
//	}

	public int save(ArrayList<Details> list) {
		// TODO Auto-generated method stub
		int status=0;
		try{
			
			Details l = list.get(0);
			/*AddressLine a=new AddressLine();
			Details d = new Details(l,a);*/
		
			Connection con=ConProvider.getConnection();
			PreparedStatement ps=con.prepareStatement("insert into REGISTRATION_USER values(REGISTRATION_ID.NEXTVAL,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,l.getName());
			ps.setString(2,l.getEmail());
			ps.setString(3,l.getPassword());
			ps.setString(4,l.getGender());
			ps.setString(5,l.getAddressLine());
			ps.setString(6,l.getCity());
			ps.setString(7,l.getState());
			ps.setString(8,l.getCountry());
			ps.setInt(9, l.getContact());
			
			System.out.println(l.getName());
			status=ps.executeUpdate();
						
		}catch(Exception e){System.out.println("fail");}
		
		System.out.println(status);
		
		return status;
	}
		
	}


