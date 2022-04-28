package com.mrsabu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class ServletCalc1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCalc1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		out.println("hello i'm servlet");

		String name = request.getParameter("uname");
		out.println("welcome " + name);

		double op;
		double n1 = Double.parseDouble(request.getParameter("num1"));
		out.println("number1 value " + n1);

		double n2 = Double.parseDouble(request.getParameter("num2"));
		out.println("number2 value " + n2);

		String sel = request.getParameter("calc");

		switch (sel) {
		case "ADD":
			op = n1 + n2;
			out.println("addition of two values is : " + op);
			break;
		case "DIFF":
			op = n1 - n2;
			out.println("difference of two values is : " + op);
			break;
		case "MULTIPLY":
			op = n1 * n2;
			out.println("multiplication of two values is : " + op);
			break;
		case "DIV":
			if(n2!=0) {
				op = n1 / n2;
				out.println("division of two values is : " + op);
			}
			else
			{
				System.out.println("division is done zero error");
				break;
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}


