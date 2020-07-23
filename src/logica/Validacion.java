package logica;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import comun.ClientesT;
import comun.EncomiendasT;
import comun.UsuariosM;
import comun.UsuariosT;
import comun.UsuariosTLogin;
import datos.ClientesC;
import datos.EncomiendasC;
import datos.UsuariosC;
import presentacion.VentanaIngresoA;
import presentacion.VentanaIngresoR;
import presentacion.VentanaLogin;

public  class Validacion implements UsuariosM {

	private  UsuariosC miValidacionLogin =new UsuariosC();
	private  UsuariosC miValidacion =new UsuariosC();	
	UsuariosT miUsuarioLogin =new UsuariosT();
	
	
	private  EncomiendasC miValidacionE =new EncomiendasC();
	private  ClientesC miValidacionC =new ClientesC();
	private  EncomiendasC miValidacionEC =new EncomiendasC();
	private  ClientesC miValidacionCE =new ClientesC();
	

		public Validacion() {
		
	}
//////////////////////////////////////////////////////////////////////
	
		
	public String validarLogin(UsuariosTLogin miUsuarioLogin)  {
		
		 String elTipo=miValidacionLogin.validarLogin(miUsuarioLogin);
		
		 if(!miUsuarioLogin.getNombreusuario().isEmpty() || !miUsuarioLogin.getClaveacceso().isEmpty() ) {  
			 	 
	       miValidacionLogin.validarLogin(miUsuarioLogin);		 
	
				 
		if( elTipo.equals("Administrador") ){
			
			 VentanaIngresoA laVentanaIngresoA= new VentanaIngresoA(miUsuarioLogin);
	            laVentanaIngresoA.setVisible(true);
	            
	            
	           }else if(!elTipo.equals("vacio")|| elTipo.equals("Recepcionista")) { 
	           VentanaIngresoR laVentanaIngresoR= new VentanaIngresoR(miUsuarioLogin);
	          laVentanaIngresoR.setVisible(true);
	         	      						
         } else if (elTipo.equals("vacio")) {
        	       	  
        	 JOptionPane.showMessageDialog(null,"No Existe ese Usuario");	
        	  
         }
		 
		 }
		 else {
		JOptionPane.showMessageDialog(null,"Los casilleros Usuario y/o Clave, no pueden estar vacios");
					 
	}
		return elTipo;
		
}
	
	
	
   public  void crearUsuario(UsuariosT miUsuarioT)  {
		
	String cedulaIdentidad=miUsuarioT.getCedulaUsuario();
    
    if(cedulaIdentidad.length() != 7 && cedulaIdentidad.length() != 8){ 
    	
    	JOptionPane.showMessageDialog(null,"El número de cedula del usuario,"
    			+ " debe tener 7 u 8 cifras. Tiene que agregar el digito verificador sin barra");
    	
    	}else{ 
    	
    	int digVerificador = Integer.parseInt((cedulaIdentidad.charAt(cedulaIdentidad.length() - 1)) + "" ) ; 
    	int[] factores; 
    	if(cedulaIdentidad.length() == 7){                                                               
    	factores = new int[]{9, 8, 7, 6, 3, 4}; 
    	}else{ 
    	factores = new int[]{2, 9, 8, 7, 6, 3, 4}; 
    	} 


    	int suma = 0; 
    	for(int i=0; i<cedulaIdentidad.length()-1; i++ ){ 
    	int digito = Integer.parseInt(cedulaIdentidad.charAt(i) + "" ) ; 
    	suma += digito * factores[i]; 
    	} 

    	int ultimoSuma = suma % 10; 
    	int comparador = 10 - ultimoSuma; 

    	if(comparador == 10 && digVerificador == 0){ 
    		
    		miValidacion.crearUsuario(miUsuarioT);
    		
    		//JOptionPane.showMessageDialog(null,"El número de cedula  es correcto");
    	}else if(comparador == digVerificador ) { 
    		
    		miValidacion.crearUsuario(miUsuarioT);
    		
    		//JOptionPane.showMessageDialog(null,"El número de cedula  es correcto");
    	} else {
    		      		
    		JOptionPane.showMessageDialog(null,"El número de cedula NO es correcto");
    	}           
    	}
    
		
	}
		
		
   

	public void eliminarUsuario(UsuariosT miUsuarioT) {
		
	
		miValidacion.eliminarUsuario(miUsuarioT);
	}


	
	
	
	public void modificarUsuario(String cedulausuario, UsuariosT miUsuarioT) {
		
        miValidacion.modificarUsuario( cedulausuario, miUsuarioT);		
		
	}
	
		
	

	public ArrayList<Object[]> buscarTablaUsuarios() {
		
		return miValidacion.buscarTablaUsuarios();
	}

	
	
	
	
	public  void ingresarClienteC( ClientesT miClienteT) {
				
		miValidacionC.ingresarClienteC( miClienteT);
		
    }

	
	

   public ArrayList<Object[]> traerTablaEncomiendas() {
		
		return miValidacionE.traerTablaEncomiendas();
	}
	

   public ArrayList<Object[]> traerTablaEncomiendasR() {
		
		return miValidacionE.traerTablaEncomiendasR();
	}
   
   
	public void ingresarEncomiendaE(EncomiendasT miEncomiendaT) {
		
		miValidacionE.ingresarEncomiendaE(miEncomiendaT);
	}

	
	
	

   public  void despacharEncomienda(int numerocodigo, EncomiendasT miEncomiendaT) {
		
        miValidacionE.despacharEncomienda( numerocodigo, miEncomiendaT);		
		
	}




   public void cancelarEncomienda(int numerocodigo, EncomiendasT miEncomiendaT) {
	
	 miValidacionE.cancelarEncomienda( numerocodigo, miEncomiendaT);
}




  public ArrayList<Object[]> traerEncomiendasClientes(int numerocodigo, EncomiendasT miEncomiendaT) {
		
		return miValidacionEC.traerEncomiendasClientes(numerocodigo, miEncomiendaT);
	}

  
  

  public ArrayList<Object[]> traerEncomiendasClientesC(String nombreDelRemitente, ClientesT miClienteT) {
		
		return miValidacionCE.traerEncomiendasClientesC(nombreDelRemitente, miClienteT);
	}


	

}	//Es la ultima de la clase
	

