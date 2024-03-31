package backend.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logForm")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		Connection con = null;
		PreparedStatement pst = null;
		
		PrintWriter out = resp.getWriter();
		
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
        
		try {
			
			 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee","root","admin");
	    	 pst= con.prepareStatement("select * from employee where email=? and pass=?");
	    	 
	    	 pst.setString(1, email);
	    	 pst.setString(2, pass);
	    	 ResultSet rs = pst.executeQuery();
	    	 if(rs.next()) {
	    		 HttpSession session= req.getSession();
	    		 
	    		 session = setAttribute("session_name",rs.getString("name"));
	    		 session = setAttribute("session_id",rs.getString("id"));
	    		 session = setAttribute("session_email",rs.getString("email"));
	    		 
	    		 RequestDispatcher rd = req.getRequestDispatcher("/profile.jsp");
	    		 rd.forward(req, resp);
	    	 }
	    	 else {
	    		 resp.setContentType("text/html");
	    		 out.println("<h3 style= 'color:red'>User not Registered due to some error</h3>");
	    		 RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
	    		 rd.include(req, resp);
	    		 
	    	 }
	    			 	
		} catch (Exception e) {
			e.printStackTrace();
			 resp.setContentType("text/html");
    		 out.println("<h3 style= 'color:red'>Exception Occur :" +e.getMessage()+"</h3>");
    		 RequestDispatcher rd = req.getRequestDispatcher("/login.jsp");
    		 rd.include(req, resp);
 		}
	}

	private HttpSession setAttribute(String string, String string2) {
		// TODO Auto-generated method stub
		return null;
	}

}
