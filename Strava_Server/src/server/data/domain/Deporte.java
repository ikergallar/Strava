package server.data.domain;

import javax.jdo.annotations.PersistenceCapable;

@PersistenceCapable()
public class Deporte {

	private String nombre;
	
	public Deporte(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public Deporte() {
		super();
		this.nombre = "";
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
