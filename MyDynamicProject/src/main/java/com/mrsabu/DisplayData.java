package com.mrsabu;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayServlet
 */
@WebServlet("/DisplayData")
public class DisplayData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	Statement st=null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayData() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		out.println("<html><body>");
		DbConnect dconn=new DbConnect();
		conn=dconn.getConnection();
		try {
			st=conn.createStatement();
		
		String s="select * from EmployeeDetails";
		ResultSet rs=st.executeQuery(s);
		out.println("<table border='1' align='center'>");
		out.println("<tr><th>Name</th><th>Email</th><th>Password</th><th>Age</th></tr>");
		while(rs.next()) {
			out.println("<tr><td>"+rs.getString("Name")+"</td><td>"+rs.getString("Email")+"</td> <td>"+rs.getString("Pass")+"</td> <td>"+rs.getInt("Age")+"</td></tr>");
		}
		out.println("</table></body></html>");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}