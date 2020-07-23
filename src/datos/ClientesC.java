package datos;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import comun.ClientesM;
import comun.ClientesT;
import comun.EncomiendasM;
import comun.EncomiendasT;



public    class ClientesC extends Conexion implements  ClientesM {
	
	Connection conectar = Conexion();
	Statement comando = null;
	ResultSet registro=null;
	
	
	
	
	public void ingresarClienteC( ClientesT miClienteT) {
					
	try {	      
		comando = conectar.createStatement();
			
		comando.executeUpdate("insert into clientes (nombreremitente,cedulacliente,telefono,direccion,nombredestinatario) values  ('"+miClienteT.getNombreremitente()+"','"+miClienteT.getCedulacliente()+"','"+miClienteT.getTelefono()+"','"+miClienteT.getDireccion()+"','"+miClienteT.getNombredestinatario()+"')");
		
	}catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"No se pudo registrar el dato");
		}
	}

	

	
	public ArrayList<Object[]> traerEncomiendasClientesC(String nombreDelRemitente, ClientesT miClienteT) {
		
		
		
		 ArrayList<Object[]> datosEncomiendasClientes=new ArrayList<Object[]>();
			
			try {
				comando=conectar.createStatement();
				registro=comando.executeQuery("SELECT codigopaquete,estado,origen,destino,fecharecibido,fechaentregado,fk_cedulausuario,fk_cedulacliente,nombreremitente,telefono,direccion,nombredestinatario from encomiendas join clientes on fk_cedulacliente=cedulacliente where nombreremitente='"+miClienteT.getNombreremitente()+"'");
						
				
							
				while(registro.next()) {
					Object[] filas=new Object[12];
					for(int f=0;f<12;f++) {
						filas[f]=registro.getObject(f+1);
						
					}
					datosEncomiendasClientes.add(filas);
					//registro.close();
					//comando.close();
					// conectar.close();
				}
			}catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al consultar base de datos");
			}
		
		
		return datosEncomiendasClientes;
	}

	
	
}//Es las usltima de la clase



/*public  ArrayList<Object[]> traerTablaClientes() {

ArrayList<Object[]> datosClientes=new ArrayList<Object[]>();

try {
	comando=conectar.createStatement();
	registro=comando.executeQuery("Select * from clientes");
	
	while(registro.next()) {
		Object[] filas=new Object[5];
		for(int f=0;f<5;f++) {
			filas[f]=registro.getObject(f+1);
			
		}
		datosClientes.add(filas);
		//registro.close();
		//comando.close();
		// conectar.close();
	}
}catch (SQLException e) {
	JOptionPane.showMessageDialog(null, "Error al consultar base de datos");
}
return datosClientes;
}*/
