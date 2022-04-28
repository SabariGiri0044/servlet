package com.mrsabu;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnect {
   //Database connection , get the connection
	String driver="com.mysql.cj.jdbc.Driver";
	String url="jdbc:mysql://localhost:3306/servletop";
	String un="root";
    String ps="Root123@";
    Connection conn=null;
    
    public Connection getConnection() {
    	
    	try {
    	  Class.forName(driver);
    	  conn=DriverManager.getConnection(url,un,ps);
    	  
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	if(conn==null) {
    		System.out.println("Connection Error");
    	}
    	
		return conn;
    }
	
}
