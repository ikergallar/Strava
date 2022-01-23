package server.data.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SesionDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private String titulo;
	private int distancia;
	private Date fecha_ini;
	private int duracion;

	public SesionDTO(String titulo, int distancia, Date fecha_ini, int duracion) {
		super();
		this.titulo = titulo;
		this.distancia = distancia;
		this.fecha_ini = fecha_ini;
		this.duracion = duracion;
	}

	public SesionDTO() {
		super();
		this.titulo = "";
		this.distancia = 0;
		this.fecha_ini = null;
		this.duracion = 0;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public Date getFecha_ini() {
		return fecha_ini;
	}

	public void setFecha_ini(Date fecha_ini) {
		this.fecha_ini = fecha_ini;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	@Override
	public String toString() {
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");  
		 String fechaIni= formatter.format(fecha_ini);  
		return  titulo + ", Fecha de inicio:" + fechaIni + ", " + distancia + " km , " + duracion + " minutos.";
	}



}