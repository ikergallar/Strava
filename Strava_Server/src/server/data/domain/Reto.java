package server.data.domain;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.annotations.ForeignKey;
import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.Inheritance;
import javax.jdo.annotations.InheritanceStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class Reto {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idReto;
	private String nombre;
	private String fecha_ini;
	private String fecha_fin;
	private int distancia;
	private Deporte deporte;
	@ForeignKey
	private int idCreador;
	private List<Usuario> participantes = new ArrayList<>();

	public Reto(String nombre, String fecha_ini, String fecha_fin, int distancia, Deporte deporte, int idCreador) {
		super();
		this.nombre = nombre;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.distancia = distancia;
		this.deporte = deporte;
		this.idCreador = idCreador;
	}

	public Reto() {
		super();
		this.nombre = "";
		this.fecha_ini = null;
		this.fecha_fin = null;
		this.distancia = 0;
		this.deporte = null;
		this.idCreador= 0;
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

	public Deporte getDeporte() {
		return deporte;
	}

	public void setDeporte(Deporte deporte) {
		this.deporte = deporte;
	}

	public int getIdCreador() {
		return idCreador;
	}

	public void setIdCreador(int idCreador) {
		this.idCreador = idCreador;
	}
	
	public List<Usuario> getParticipantes() {
		return participantes;
	}

	public void setParticipantes(List<Usuario> participantes) {
		this.participantes = participantes;
	}
	
	public void addParticipante(Usuario user) {
		if (user != null && !this.participantes.contains(user)) {
		    this.participantes.add(user);
		}
	}
	
}
