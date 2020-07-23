package comun;

public class ClientesT {
	private String nombreremitente;
	private String nombredestinatario;
	private String direccion;
	private String telefono;
	private String cedulacliente;
	
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getNombreremitente() {
		return nombreremitente;
	}
	public void setNombreremitente(String nombreremitente) {
		this.nombreremitente = nombreremitente;
	}
	public String getNombredestinatario() {
		return nombredestinatario;
	}
	public void setNombredestinatario(String nombredestinatario) {
		this.nombredestinatario = nombredestinatario;
	}
	
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCedulacliente() {
		return cedulacliente;
	}
	public void setCedulacliente(String cedulacliente) {
		this.cedulacliente = cedulacliente;
	}
	
}
