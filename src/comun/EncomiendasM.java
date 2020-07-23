package comun;
import java.util.ArrayList;

import comun.EncomiendasT;

public interface EncomiendasM {
	
	public  void ingresarEncomiendaE(EncomiendasT miEncomiendaT);
	
	public  void despacharEncomienda(int numerocodigo, EncomiendasT miEncomiendaT);
	
	public  void cancelarEncomienda(int numerocodigo,EncomiendasT miEncomiendaT);
	
	public ArrayList<Object[]> traerTablaEncomiendas();

    public ArrayList<Object[]> traerEncomiendasClientes(int numerocodigo, EncomiendasT miEncomiendaT);
    
    public ArrayList<Object[]> traerTablaEncomiendasR();
 
}

//public  void modificarEncomienda(String cedulacliente, EncomiendasT miEncomiendaT);