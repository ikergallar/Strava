package server.data.domain;

import java.util.ArrayList;
import java.util.List;

public class Reto {
	
	private int idReto;
	private String nombre;
	private String fecha_ini;
	private String fecha_fin;
	private int distancia;
	private Deporte deporte;
	private Usuario creador;
	private List<Usuario> participantes = new ArrayList<>();

	
	public Reto(int idReto, String nombre, String fecha_ini, String fecha_fin, int distancia, Deporte deporte, Usuario creador) {
		super();
		this.idReto = idReto;
		this.nombre = nombre;
		this.fecha_ini = fecha_ini;
		this.fecha_fin = fecha_fin;
		this.distancia = distancia;
		this.deporte = deporte;
		this.creador = creador;
	}

	public Reto() {
		super();
		this.idReto = 0;
		this.nombre = "";
		this.fecha_ini = null;
		this.fecha_fin = null;
		this.distancia = 0;
		this.deporte = null;
		this.creador= null;
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

	public Usuario getCreador() {
		return creador;
	}

	public void setCreador(Usuario creador) {
		this.creador = creador;
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
