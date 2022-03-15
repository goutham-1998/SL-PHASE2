import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Product
 */
@WebServlet("/Product")
public class Product extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Product() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String color = request.getParameter("color");
		String price = request.getParameter("price");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Add operation Successful</h2><br/>");
		out.println("Added "+color+" "+name+" to the database.");
		
		float price_cost = 0;
		int id_int = 0;
		try {
			price_cost = (float) Double.parseDouble(price);
			id_int = Integer.parseInt(id);
			
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pets","root","Ra@1611003010107");
			
			Statement st = con.createStatement();
			st.executeUpdate("use pets");
			
			st.executeUpdate("insert into pets.product(ID,name,color,price)values('"+id_int+"','"+name+"','"+color+"','"+price_cost+"')");
			ResultSet rs = st.executeQuery("select * from pets.product");
			
			ResultSetMetaData md = rs.getMetaData();
			int col = md.getColumnCount();  
			
			out.println("<br/><br/>");
			
            
            out.println("<div align='center' style='margin-top:50%'>"+"<table border=1 width=50% height=50%>");  
            out.println("<tr><th>Product Id</th><th>Product Name</th><th>Product Color</th><th>Product Price</th><tr>");
			while (rs.next()) 
			{
				out.println("<tr>");
				for(int i = 1 ; i <= col; i++)
				{
					out.print("<td>"+rs.getString(i) +"</td>"); 
				}
				out.println("</tr>");
			  	out.println("<br><br>");
			}
			out.println("</table>"+"</div>");  
            out.println("</html></body>");
            st.close();
			con.close();
			
		}
		catch(NumberFormatException e) {
			price_cost = (float) 0.00;
		}
		catch(ClassNotFoundException e) {
			out.println(e);
		} catch (SQLException e) {
			out.println(e);
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