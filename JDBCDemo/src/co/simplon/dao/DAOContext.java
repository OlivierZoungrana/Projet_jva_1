package co.simplon.dao;

import java.sql.*;

import javax.servlet.ServletContext;

public class DAOContext {
	
	static String db_url = "jdbc:mysql://localhost:3306/testjdbc";
	static String db_username= "root";
	static String db_password= "######";
	
	
	
	      
	public static Connection get_Connection() throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		Connection connexion = DriverManager.getConnection(db_url,db_username,db_password);
				return connexion;
	}
	
	public PaysDAO getPaysDao() {
		
		//PaysDAO paysDaoobjet = new PaysDaoImpl(this);
		//return paysDaoobjet;
		return new PaysDaoImpl(this);
	}
	
	public static void init (ServletContext context) {
		
		try {
			
			Class.forName(context.getInitParameter("JDBC_DRIVER"));
			db_url = context.getInitParameter("JDBC_LOGIN");
			db_username = context.getInitParameter("JDBC_LOGIN");
			db_password= context.getInitParameter("JDBC_PASSWORD");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
	}
	
	

}
