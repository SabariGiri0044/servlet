package com.mrsabu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertData
 */
@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DbConnect cob=new DbConnect();
		String Name=request.getParameter("Name");
		String Email=request.getParameter("Email");
		String Pass=request.getParameter("Password");
		int Age=Integer.parseInt(request.getParameter("Age"));
		
		PrintWriter out=response.getWriter();
		conn=cob.getConnection();
		String sql="insert into EmployeeDetails values(?,?,?,?)";
		try {
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1,Name);
			pst.setString(2,Email);
			pst.setString(3, Pass);
			pst.setInt(4, Age);
			int i=pst.executeUpdate();
			if(i>0) {
				out.println("Registration success");
			}else {
				out.println("Error occurred");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
	}

}
