package com.mrsabu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UserLogin
 */
@WebServlet("/UserLogin")
public class UserLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String u=request.getParameter("uname");
		String p=request.getParameter("upass");
		response.setContentType("text/html");
		RequestDispatcher rd;
		
		PrintWriter out=response.getWriter();
		if(u.equalsIgnoreCase("mrsabu") && (p.equals("123"))){
			//out.print("Valid User");
			//go to SuccessServlet
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
		}
		else {
			out.println("Try again");
			//login page to be displayed again
			rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
				
	}

}
