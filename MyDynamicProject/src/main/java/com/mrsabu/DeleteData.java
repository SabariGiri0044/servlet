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
 * Servlet implementation class DeleteData
 */
@WebServlet("/DeleteData")
public class DeleteData extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Connection conn=null;
	Statement st=null;
	

    /**
     * Default constructor. 
     */
    public DeleteData() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
		String Email=request.getParameter("Email");
		
		DbConnect dconn=new DbConnect();
		conn=dconn.getConnection();
		try {
			response.setContentType("text/html");
			String query="select * from EmployeeDetails where Email='"+Email+"'";
			
			ResultSet rs=st.executeQuery(query);
			
			if(rs.next()) {
				String sql="Delete from  EmployeeDetails " + "where Email='"+Email+"'";
			   System.out.println(sql);
				int i=st.executeUpdate(sql);
			    if(i>0) {
			    	out.println("Deleted");
			    }
			    else {
			    	out.println("Failed to delete");
			    }
			    
			}
			else {
				out.println("Record Not present");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
