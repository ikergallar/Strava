package server.data.domain;

import java.util.Date;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Sesion {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idSesion;
	private String titulo;
	private String deporte;
	private int distancia;
	private Date fecha_ini;
	private int duracion;
	@ForeignKey
	private int idCreador;
	
	public Sesion(String titulo, String deporte, int distancia, Date fecha_ini, int duracion, int idCreador) {
		super();
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fecha_ini = fecha_ini;
		this.duracion = duracion;
		this.idCreador = idCreador;

	}
	
	public Sesion() {
		super();
		this.titulo = "";
		this.deporte = "";
		this.distancia = 0;
		this.fecha_ini = null;
		this.duracion = 0;
		this.idCreador = 0;
	}

	public int getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(int idSesion) {
		this.idSesion = idSesion;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDeporte() {
		return deporte;
	}

	public void setDeporte(String deporte) {
		this.deporte = deporte;
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

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}
	
}
