package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Dao.ComposeDao;

@WebServlet("/ComposeServletProcess")
public class ComposeServletProcess extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		String receiver=request.getParameter("to");
		

		 

	
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		message=message.replaceAll("\n","<br/>");
		String email=(String)request.getSession(false).getAttribute("email");
		
		int i=ComposeDao.save(email, receiver, subject, message);
		if(i>0){
			request.setAttribute("msg","message successfully sent");
			request.getRequestDispatcher("ComposeServlet").forward(request, response);
		}
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();

	}

}
