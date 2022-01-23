package server.data.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import server.data.domain.Deporte;
import server.data.domain.Usuario;

public class RetoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private int idReto;
	private String nombre;
	private Date fecha_ini;
	private Date fecha_fin;
	private int distancia;

	public RetoDTO(int idReto, String nombre, Date fecha_ini, Date fecha_fin, int distancia) {
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
		this.fecha_ini = null;
		this.fecha_fin = null;
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

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
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
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		String fechaIni= formatter.format(fecha_ini);
		String fechaFin= formatter.format(fecha_fin); 
		return  nombre + ", fecha de inicio: " + fechaIni + ", fecha de expiración: " + fechaFin + ", " +  distancia + "km.";
	}

}
