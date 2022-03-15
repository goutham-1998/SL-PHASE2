import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.DBConnection;

/**
* Servlet implementation class ProductDetails
*/
@WebServlet("/list")
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
        	PrintWriter out = response.getWriter();
                try {
                        
                        out.println("<html><body>");
                         
                        InputStream in = getServletContext().getResourceAsStream("/WEB-INF/config.properties");
                        Properties props = new Properties();
                        //props.load(in);
                        
                        //connection information
                        DBConnection conn = new DBConnection("jdbc:mysql://localhost:3306/pets", "root", "Ra@1611003010107");
                        Statement stmt = conn.getConnection().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                        
                        
                        ResultSet rst = stmt.executeQuery("select * from pets.product");
                        
                        
                        String productSearch = request.getParameter("search");
                        //out.println(productSearch);
                        
                        
                        if(productSearch == null)
                        {	
	                        
	                        //simple while loop to print all elements in table
//	                       
	                        out.println("<div align='center'>"+"<table border=1 width=50% height=50%>");  
	                        out.println("<tr><th>Product Id</th><th>Product Name</th><th>Product Color</th><th>Product Price</th><tr>");  
	                        while (rst.next()) 
	                        {  
	                            int id = rst.getInt("ID");  
	                            String name = rst.getString("name");  
	                            String color = rst.getString("color"); 
	                            float price = rst.getFloat("price");
	                            out.println("<tr><td>" + id + "</td><td>" + name + "</td><td>" + color + "</td><td>" + price + "</td></tr>");   
	                        }  
	                        out.println("</table>"+"</div>");  
	                        out.println("</html></body>");
                        }
                        
                        else 
                        {
                        	//select the row corresponding to the id number
                        	String sql_res= "select * from pets.product where id=" + productSearch;
                            ResultSet inTable = stmt.executeQuery(sql_res);
                            
                            //if not empty
                            if(inTable.next()) {
                            	out.println("<div align='center'>"+"<table border=1 width=50% height=50%>");  
	                        out.println("<tr><th>Product Id</th><th>Product Name</th><th>Product Color</th><th>Product Price</th><tr>");
	                        
	                        out.println("<tr><td>" + inTable.getInt("ID") + "</td><td>" + inTable.getString("name") + "</td><td>" + inTable.getString("color") + "</td><td>" + inTable.getFloat("price") + "</td></tr>");
	                        out.println("</table>"+"</div>"); 
                            }
                            //empty
                            else 
                            	out.println("Sorry!! Your search with " + productSearch + " is not found in the table, Please choose appropriate value");
                           
                        }
                    	
                        stmt.close();
                        
                        
                        
                        out.println("</body></html>");
                        conn.closeConnection();
                        
                } catch (ClassNotFoundException e) {
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