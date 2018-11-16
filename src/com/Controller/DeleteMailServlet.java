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
@WebServlet("/DeleteMailServlet")
public class DeleteMailServlet extends HttpServlet {
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
				PreparedStatement ps=con.prepareStatement("delete from company_mailer_message  where id=?");
				ps.setInt(1,id);
				
				int i=ps.executeUpdate();
				if(i>0){
					request.setAttribute("msg","Mail successfully deleted!");
					request.getRequestDispatcher("InboxServlet").forward(request, response);
				}
				con.close();
			}catch(Exception e){out.print(e);}
		}
		
		
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}
