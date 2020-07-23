package datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
	
	
	private String nombreBd="proyectoencomiendas";
	private String usuario="root";
	private String password="";
	private String url="jdbc:mysql://localhost/"+nombreBd+"?useSSL=false";

	private Connection conn=null;
		                                                              
	                                                                 
	public Connection Conexion(){
		
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
					
			 conn=DriverManager.getConnection(url,usuario,password);
			
			if (conn!=null) {
				//JOptionPane.showMessageDialog(null,"Se ha conectadoa la bd");
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"NO se ha podido conectar a la base de datos");
		}catch(ClassNotFoundException e){
	         System.out.println(e);
	      }catch(Exception e){
	         System.out.println(e);
	      }return conn;
	}
	
	
	
	public void desconectar(){
		conn=null;
	}
}
	 