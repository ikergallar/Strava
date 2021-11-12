package server.data.domain;

public class Deporte {
	private String idDeporte;
	private String nombre;
	
	
	
	public Deporte(String idDeporte, String nombre) {
		super();
		this.idDeporte = idDeporte;
		this.nombre = nombre;
	}
	
	public Deporte() {
		super();
		this.idDeporte = "";
		this.nombre = "";
	}
	
	public String getIdDeporte() {
		return idDeporte;
	}
	public void setIdDeporte(String idDeporte) {
		this.idDeporte = idDeporte;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
