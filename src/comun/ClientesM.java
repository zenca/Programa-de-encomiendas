package comun;

import java.util.ArrayList;

public interface ClientesM {
	
	public  void ingresarClienteC(ClientesT miClienteT); 
		
	public ArrayList<Object[]> traerEncomiendasClientesC(String nombreDelRemitente, ClientesT miClienteT);
	 
	 	 
	}
	