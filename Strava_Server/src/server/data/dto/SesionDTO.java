package server.data.dto;

import java.io.Serializable;

import server.data.Deporte;

public class SesionDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	private String titulo;
	private Deporte deporte;
	private int distancia;
	private String fecha_ini;
	private int duracion;
	
	public SesionDTO(String titulo, Deporte deporte, int distancia, String fecha_ini, int duracion) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fecha_ini = fecha_ini;
		this.duracion = duracion;
	}
	
	public SesionDTO() {
		super();
		this.titulo = "";
		this.deporte = null;
		this.distancia = 0;
		this.fecha_ini = "";
		this.duracion = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
}