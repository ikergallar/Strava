package server.data.dto;

import java.io.Serializable;

import server.data.domain.Deporte;
import server.data.domain.Usuario;

public class RetoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idReto;
	private String nombre;
	private String fecha_ini;
	private String fecha_fin;
	private int distancia;

	public RetoDTO(int idReto, String nombre, String fecha_ini, String fecha_fin, int distancia) {
		super();
		this.idReto = idReto;
		this.nombre = nombre;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.distancia = distancia;
	}

	public RetoDTO() {
		super();
		this.idReto = 0;
		this.nombre = "";
		this.fecha_ini = "";
		this.fecha_fin = "";
		this.distancia = 0;
	}

	public int getIdReto() {
		return idReto;
	}

	public void setIdReto(int idReto) {
		this.idReto = idReto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(String fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public String getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(String fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	@Override
	public String toString() {
		return "RetoDTO [nombre=" + nombre + ", fecha_ini=" + fecha_ini + ", fecha_fin=" + fecha_fin + ", distancia="
				+ distancia + "]";
	}

}
