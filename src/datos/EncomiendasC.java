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



public    class EncomiendasC extends Conexion implements EncomiendasM {
	
	Connection conectar = Conexion();
	Statement comando = null;
	ResultSet registro=null;
	
		
	public void ingresarEncomiendaE(EncomiendasT miEncomiendaT) {
					
	try {	      
		comando = conectar.createStatement();
		
		comando.executeUpdate("INSERT INTO encomiendas (estado,origen,destino,fecharecibido,tipo,fk_cedulacliente,observaciones,fk_cedulausuario) values  ('"+miEncomiendaT.getEstado()+"','"+miEncomiendaT.getOrigen()+"','"+miEncomiendaT.getDestino()+"','"+miEncomiendaT.getFechahorarecibida()+"','"+miEncomiendaT.getTipoE()+"','"+miEncomiendaT.getCedulacliente()+"','"+miEncomiendaT.getObservaciones()+"','"+miEncomiendaT.getCedulausuario()+"')");
		
	}catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"No se pudo registrar la encomienda");
		}
	}
	
		
   public  ArrayList<Object[]> traerTablaEncomiendas() {
		
		ArrayList<Object[]> datosEncomiendas=new ArrayList<Object[]>();
		
		try {
			comando=conectar.createStatement();
			registro=comando.executeQuery("Select * from encomiendas");
			
			while(registro.next()) {
				Object[] filas=new Object[10];
				for(int f=0;f<10;f++) {
					filas[f]=registro.getObject(f+1);
					
				}
				datosEncomiendas.add(filas);
				//registro.close();
				//comando.close();
				// conectar.close();
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar base de datos");
		}
		return datosEncomiendas;
	}

	
   public  ArrayList<Object[]> traerTablaEncomiendasR() {
		
		ArrayList<Object[]> datosEncomiendas=new ArrayList<Object[]>();
		
		try {
			comando=conectar.createStatement();
			registro=comando.executeQuery("Select * from encomiendas where estado='pendiente'");
			
			while(registro.next()) {
				Object[] filas=new Object[10];
				for(int f=0;f<10;f++) {
					filas[f]=registro.getObject(f+1);
					
				}
				datosEncomiendas.add(filas);
				//registro.close();
				//comando.close();
				// conectar.close();
			}
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al consultar base de datos");
		}
		return datosEncomiendas;
	}
   
   
     
   
	
	public void despacharEncomienda(int numerocodigo, EncomiendasT miEncomiendaT) {
		
		
	try {	      
		comando = conectar.createStatement();
		
		comando.executeUpdate("UPDATE encomiendas SET  estado='"+miEncomiendaT.getEstado()+"',"+"fechaentregado='"+miEncomiendaT.getFechahoraentregada()+"'"+ "WHERE codigopaquete='"+miEncomiendaT.getCodigopaquete()+"'");
	}catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"No se pudo modificar el usuariosario");
		}

	}

	
	
	 public  ArrayList<Object[]> traerEncomiendasClientes(int numerocodigo,EncomiendasT miEncomiendaT) {
			
			ArrayList<Object[]> datosEncomiendasClientes=new ArrayList<Object[]>();
			
			try {
				comando=conectar.createStatement();
				registro=comando.executeQuery("SELECT codigopaquete,estado,origen,destino,fecharecibido,fechaentregado,fk_cedulausuario,fk_cedulacliente,nombreremitente,telefono,direccion,nombredestinatario from encomiendas join clientes on fk_cedulacliente=cedulacliente where codigopaquete='"+miEncomiendaT.getCodigopaquete()+"'");
							
							
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


	
	public void cancelarEncomienda(int numerocodigo, EncomiendasT miEncomiendaT) {
		
		
		try {	      
			comando = conectar.createStatement();
			
			comando.executeUpdate("UPDATE encomiendas SET  estado='"+miEncomiendaT.getEstado()+"',"+"fechaentregado='"+miEncomiendaT.getFechahoraentregada()+"'"+ "WHERE codigopaquete='"+miEncomiendaT.getCodigopaquete()+"'");
		}catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"No se pudo modificar el usuariosario");
			}
		
		
	}


	

		
}//Ultima de a clase


/*public void modificarEncomienda(String cedulacliente, EncomiendasT miEncomiendaT) {
	try {	      
		comando = conectar.createStatement();
		
		comando.executeUpdate("UPDATE encomiendas SET origen='"+miEncomiendaT.getOrigen()+"',"+"destino='"+miEncomiendaT.getDestino()+"',"+" tipo='"+miEncomiendaT.getTipoE()+"',"+"observaciones='"+miEncomiendaT.getObservaciones()+"'"+ "WHERE fk_cedulacliente='"+miEncomiendaT.getCedulacliente()+"'");
	}catch (SQLException e) {
		JOptionPane.showMessageDialog(null,"No se pudo modificar el usuariosario");
		}
	
}	*/
	
	

