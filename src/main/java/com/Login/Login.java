package com.Login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("UserId");
		String password=request.getParameter("password");
		RequestDispatcher rd=null;
		if(username.equalsIgnoreCase("LearnerAcademy@gmail.com") && password.equals("1234")) {
			rd=request.getRequestDispatcher("DashBoard.html");
			rd.forward(request, response);	
		}
		else {
			rd=request.getRequestDispatcher("AdminLogin.html");
			PrintWriter out=response.getWriter();
			rd.include(request, response);
			out.println("<center> <span style='color:red'>Invalid Login</span></center>");
			
		}
	}

}
