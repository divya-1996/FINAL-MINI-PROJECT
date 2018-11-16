package com.Controller;


import java.awt.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.RegisterDao;
import com.model.AddressLine;
import com.model.Details;
import com.model.Login;
@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		
		String name=request.getParameter("usrname");
		String password=request.getParameter("password");
		String email=request.getParameter("email");
		String gender=request.getParameter("gender");
		String addressLine=request.getParameter("addressLine");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		String country=request.getParameter("country");
		int contact=Integer.parseInt(request.getParameter("contact"));
		 
		Login l = new Login();
		AddressLine a=new AddressLine();
		Details d = new Details(l,a);
		d.setEmail(email);
		d.setPassword(password);
		d.setName(name);
		d.setGender(gender);
		d.setContact(contact);
		d.setAddressLine(addressLine);
		d.setCity(city);
		d.setCountry(country);
		d.setState(state);
		
		
		ArrayList<Details> list= new ArrayList<Details>();
		list.add(d);
		RegisterDao jd = new RegisterDao();
		int status=jd.save(list);
	        if(status>0){
			out.print("<p>You are successfully registered!</p>");
			request.getRequestDispatcher("login.jsp").include(request, response);
			
		}
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

}
