package myservlet.control; 
import mybean.data.*; 
import myservlet.conn.jdbcUtil;

import java.sql.*; 
import java.io.*; 

import javax.servlet.*; 
import javax.servlet.http.*; 
//import javax.naming.NamingException;   
public class register extends HttpServlet 
{   
	/**
	 * Constructor of the object.
	 */
	public register() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request,response); 
	}
   public  void  doPost(HttpServletRequest request,HttpServletResponse response)  
                        throws ServletException,IOException 
    {    
	   	request.setCharacterEncoding("GBK");
        String logname=request.getParameter("logname");  
        String password=request.getParameter("password"); 
        String advertiseTitle=request.getParameter("advertiseTitle"); 
        String email=request.getParameter("email"); 
        String phone=request.getParameter("phone");
        String message=request.getParameter("message");
        Connection conn = new jdbcUtil().getConnection();
        Register reg= new Register();
        String sql = "insert into member (logname, password, advertiseTitle, email,phone,message) values (?,?,?,?,?,?)";
        PreparedStatement ps;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1,logname);
			ps.setString(2,password);
			ps.setString(3,advertiseTitle);
			ps.setString(4,email);
			ps.setString(5,phone);
			ps.setString(6,message);
			ps.executeUpdate();

			ps.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("showRegisterMess.jsp");
		dispatcher.forward(request, response);
		

    }
  }