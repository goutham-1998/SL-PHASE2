

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBConnection.DBConnection;

/**
 * Servlet implementation class DBConnection
 */
@WebServlet("/init")
public class ProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dbUrl = "jdbc:mysql://localhost:3306/ecommerce"; // JDBC URL
		String userName = "root";
		String pwd = "Ra@1611003010107";

		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		try {
			DBConnection dConnection = new DBConnection(dbUrl, userName, pwd);

			java.sql.CallableStatement stmt = dConnection.getConnection()
					.prepareCall("call add_product_12032022(?,?);");

			stmt.setString(2, "PRODUCT_FROM_CALLABLE_STMT");
			stmt.setInt(1, 10);

			stmt.executeUpdate();

			stmt.close();
			dConnection.closeConnection();

			out.println("</body></html>");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
