package comun;
import java.util.ArrayList;

import comun.UsuariosT;
public interface UsuariosM {
	
	public  void eliminarUsuario(UsuariosT miUsuarioT);
	
	public  void modificarUsuario(String cedulausuario, UsuariosT miUsuarioT);
	
	public ArrayList<Object[]> buscarTablaUsuarios();
	
	public String validarLogin(UsuariosTLogin miUsuarioLogin);
	
}