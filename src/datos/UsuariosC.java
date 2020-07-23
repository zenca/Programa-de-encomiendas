package datos;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import comun.UsuariosM;
import comun.UsuariosT;
import comun.UsuariosTLogin;

public class UsuariosC extends Conexion implements UsuariosM {
	
	Connection conectar = Conexion();
	Statement comando = null;
	ResultSet registro = null;
	
	
	public String validarLogin(UsuariosTLogin miUsuarioLogin) {  
			
		
		try {			
			comando = conectar.createStatement();
			registro = comando.executeQuery("Select nombreusuario,claveacceso,tipo,cedulausuario from usuarios Where nombreusuario='"+miUsuarioLogin.getNombreusuario()+"' and claveacceso='"+miUsuarioLogin.getClaveacceso()+"'");
			
		if(registro.next()) {                             
			 
			miUsuarioLogin.setNombreusuario(registro.getString("nombreusuario"));      
			miUsuarioLogin.setTipo(registro.getString("tipo")); 
			miUsuarioLogin.setCedulaUsuario(registro.getString("cedulausuario")); 
			
			String elTipo=registro.getString("tipo");
			return elTipo;
					
		}else {
			//JOptionPane.showMessageDialog(null,"No Existe ese Usuario");
			String elTipo="vacio";
			return elTipo;		
		}
			
		}	
			
		catch (SQLException e) {
			System.out.println("No se pudo corroborar el dato: "+e.getMessage());
			
		}
		return null;
		
					
}
		
	
	public void crearUsuario(UsuariosT miUsuarioT) {
		
		try {	      
			comando = conectar.createStatement();
			
			comando.executeUpdate("insert into usuarios (nombre,claveacceso,tipo,apellido,nombreusuario,cedulausuario) values  ('"+miUsuarioT.getNombre()+"','"+miUsuarioT.getClaveacceso()+"','"+miUsuarioT.getTipo()+"','"+miUsuarioT.getApellido()+"','"+miUsuarioT.getNombreusuario()+"','"+miUsuarioT.getCedulaUsuario()+"')");
		
			JOptionPane.showMessageDialog(null,"El ususario se ha creado. Para corrobororarlo actualice la tabla");	
			
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"No se pudo registrar el dato");
			}
		
		}
		
		
			
		public void eliminarUsuario(UsuariosT miUsuarioT) {
					
		try {	      
			comando = conectar.createStatement();
			
			comando.executeUpdate("delete from usuarios where cedulausuario='"+miUsuarioT.getCedulaUsuario()+"'");
			
			JOptionPane.showMessageDialog(null,"El ususario se ha eliminado. Para corrobororarlo actualice la tabla");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"No se pudo eliminar al usuario");
			}
		
		

		}
		
			
		
		public  ArrayList<Object[]> buscarTablaUsuarios() {
			
			ArrayList<Object[]> datosUsuarios=new ArrayList<Object[]>();
			
			try {
				comando=conectar.createStatement();
				registro=comando.executeQuery("Select * from usuarios");
				
				while(registro.next()) {
					Object[] filas=new Object[6];
					for(int f=0;f<6;f++) {
						filas[f]=registro.getObject(f+1);
						
					}
					datosUsuarios.add(filas);
					
				}
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar base de datos");
			}
			return datosUsuarios;
			
		}


		public void modificarUsuario(String cedulausuario, UsuariosT miUsuarioT) {
				
			try {	      
				comando = conectar.createStatement();
				
				comando.executeUpdate("UPDATE usuarios SET nombre='"+miUsuarioT.getNombre()+"',"+"claveacceso='"+miUsuarioT.getClaveacceso()+"',"+" tipo='"+miUsuarioT.getTipo()+"',"+"apellido='"+miUsuarioT.getApellido()+"',"+"nombreusuario='"+miUsuarioT.getNombreusuario()+"'"+ "WHERE cedulausuario='"+miUsuarioT.getCedulaUsuario()+"'");
				
				JOptionPane.showMessageDialog(null,"El usuario se ha modificado. Para corrobororarlo actualice la tabla");
				
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null,"No se pudo modificar el usuariosario");
				}
			
					
		}

	
}//Ultima de la clase

