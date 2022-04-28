package com.mrsabu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateData")
public class UpdateData extends HttpServlet {
	private static final long serialVersionUID = 1L;
     Connection conn=null;  
     PreparedStatement pst=null;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String Email=request.getParameter("Email");
		String Pass=request.getParameter("Pass");
		
		DbConnect dconn=new DbConnect();
		conn=dconn.getConnection();
		
		
		try {
			String query="select * from EmployeeDetails where Email=?";
			
			 pst=conn.prepareStatement(query);
			pst.setString(1, Email);
			ResultSet rs=pst.executeQuery();
			if(rs.next()) {
				
				String updatepassword="update EmployeeDetails set Pass=? where Email=?";
			    pst=conn.prepareStatement(updatepassword);
			    pst.setString(1, Pass);
			    pst.setString(2, Email);
			    int i=pst.executeUpdate();
			    if(i>0) {
			    	out.println("Password changed");
			    }
			    else {
			    	out.println("Password not changed");
			    }
			    
			}
			else {
				out.println("user not registered");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
