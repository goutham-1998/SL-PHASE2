

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
 * Servlet implementation class DBOperations
 */
@WebServlet("/init")
public class DBOperations extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DBOperations() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		String dbUrl = "jdbc:mysql://localhost:3306/ecommerce";
		String userName = "root";
		String pwd = "Ra@1611003010107";
		
		PrintWriter out = response.getWriter();
        out.println("<html><body>");
        
		
		try {
			DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);
           
           
            
           Statement stmt = dConnection.getConnection().createStatement();
           
           
           stmt.executeUpdate("create database mydatabase");
           out.println("Created database: mydatabase<br>");
           stmt.executeUpdate("use mydatabase");
           out.println("Selected database: mydatabase<br>");
           stmt.executeUpdate("drop database mydatabase");
           stmt.close();
           out.println("Dropped database: mydatabase<br>");
           
           dConnection.closeConnection();
          
           out.println("</body></html>");
           
           
   } catch (ClassNotFoundException e) {
           e.printStackTrace();
   } catch (SQLException e) {
           e.printStackTrace();
   }
}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
