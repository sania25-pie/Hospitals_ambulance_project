package log;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class registerpages
 */

@WebServlet("/logpgs")
public class registerpages extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerpages() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
   
	     PrintWriter out= resp.getWriter();	
		
		String myemail1=req.getParameter("email");
		
		String mypass1=req.getParameter("password");
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/n_jdbc","root","123456");
			PreparedStatement ps=cc.prepareStatement("select * from reg where email=? and password=?");
			ps.setString(1, myemail1);
			ps.setString(2, mypass1);
			ResultSet rd=ps.executeQuery();
			
			if(rd.next()) {
				 
				resp.setContentType("text/html");
				out.print("<h3 style='color:blue'>Login is succesful</h3>");
				RequestDispatcher rs=req.getRequestDispatcher("/home.html");
				rs.include(req, resp);
			}
			
			else {
				
				resp.setContentType("text/html");
				out.print("<h3 style='color:red'>Email or Password is incorrect</h3>");
				RequestDispatcher rs=req.getRequestDispatcher("/loginpage.jsp");
				rs.include(req, resp);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print("<h3 style='color:red'>"+e.getMessage()+"</h3>");
			RequestDispatcher rs=req.getRequestDispatcher("/loginpage.jsp");
			rs.include(req, resp);
		}
	}

}
