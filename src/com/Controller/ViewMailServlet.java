package com.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Dao.ConProvider;
@WebServlet("/ViewMailServlet")
public class ViewMailServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		request.getRequestDispatcher("header.jsp").include(request, response);
		request.getRequestDispatcher("link.jsp").include(request, response);
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		HttpSession session=request.getSession(false);
		if(session==null){
			response.sendRedirect("index.jsp");
		}else{
			String email=(String)session.getAttribute("email");
			out.print("<span style='float:right'>Hi, "+email+"</span>");
			
			int id=Integer.parseInt(request.getParameter("id"));
			
			try{
				Connection con=ConProvider.getConnection();
				PreparedStatement ps=con.prepareStatement("select * from company_mailer_message where id=?");
				ps.setInt(1,id);
				ResultSet rs=ps.executeQuery();
				if(rs.next()){
					out.print("<h1>"+rs.getString("subject")+"</h1><hr/>");
					out.print("<p><b>Message:</b><br/> "+rs.getString("message")+" <br/> <b>By: "+rs.getString("sender")+"</b></p>");
					out.print("<p><a href='DeleteMailServlet?id="+rs.getString(1)+"'>Delete Mail</a></p>");			
									
				}
				
				con.close();
			}catch(Exception e){out.print(e);}
		}
		
		
		
		request.getRequestDispatcher("footer.jsp").include(request, response);
		out.close();
	}

	}

