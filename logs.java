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

/**
 * Servlet implementation class logs
 */

@WebServlet("/regs")
public class logs extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public logs() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=resp.getWriter();
		
		String first=req.getParameter("firstname");
		String last=req.getParameter("lastname");
		String myphone=req.getParameter("phnumber");
		String myemail=req.getParameter("email");
		String mypass=req.getParameter("password");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection cc=DriverManager.getConnection("jdbc:mysql://localhost:3306/n_jdbc","root","123456");
			PreparedStatement ps=cc.prepareStatement("insert into reg values(?,?,?,?,?)");
			ps.setString(1, first);
			ps.setString(2, last);
			ps.setString(3, myphone);
			ps.setString(4, myemail);
			ps.setString(5, mypass);
			
			int counts=ps.executeUpdate();
			
			if(counts>0)
			{
				resp.setContentType("text/html");
				out.print(" <h3>style='color:green'> User is Succesfully registered </h3>");
				RequestDispatcher rr=req.getRequestDispatcher("/home.html");
				rr.include(req, resp);
				
			}
			else {
				resp.setContentType("text/html");
				out.print(" <h3>style='color:red'> User is not registered </h3>");
				RequestDispatcher rr=req.getRequestDispatcher("/home.html");
				rr.include(req, resp);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			resp.setContentType("text/html");
			out.print(" <h3>style='color:red'> Eception ouccer:"+e.getMessage()+" </h3>");
			RequestDispatcher rr=req.getRequestDispatcher("/home.html");
			rr.include(req, resp);
			
		}
	}

}
