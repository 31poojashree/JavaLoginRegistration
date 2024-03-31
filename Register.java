package backend.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/regForm")
public class Register extends HttpServlet{
	Connection con = null;
	PreparedStatement pst = null;
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		
	     String id = req.getParameter("id");
	     String name = req.getParameter("name");
	     String email = req.getParameter("email");
	     String pass = req.getParameter("pass");
	     String city = req.getParameter("city");
	     
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","admin");
	    	 pst= con.prepareStatement("insert into Employee values(?,?,?,?,?)");
	    	 pst.setString(1,id);
	    	 pst.setString(2,name);
	    	 pst.setString(3,email);
	    	 pst.setString(4,pass);
	    	 pst.setString(5,city);
	    	 
	    	 int count = pst.executeUpdate();
	    	 if(count>0) {
	    		 resp.setContentType("text/html");
	    		 out.println("<h3 style= 'color:green'>User Register Successfully</h3>");
	    		 RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
	    		 rd.include(req, resp);
	    		 
	    	 }
	    	 else {
	    		 resp.setContentType("text/html");
	    		 out.println("<h3 style= 'color:red'>User not Registered due to some error</h3>");
	    		 RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
	    		 rd.include(req, resp);
	    		 
	    	 }
	     }
	     catch(Exception e) {
	    	 e.printStackTrace();
	    	 resp.setContentType("text/html");
    		 out.println("<h3 style= 'color:red'>Exception Occur :" +e.getMessage()+"</h3>");
    		 RequestDispatcher rd = req.getRequestDispatcher("/register.jsp");
    		 rd.include(req, resp);
    		 
	     }
	     
	}}
