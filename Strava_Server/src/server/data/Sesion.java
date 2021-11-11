package server.data;

public class Sesion {
	
	private String idSesion;
	private String titulo;
	private Deporte deporte;
	private int distancia;
	private String fecha_ini;
	private int duracion;
	
	public Sesion(String idSesion, String titulo, Deporte deporte, int distancia, String fecha_ini, int duracion) {
		super();
		this.idSesion = idSesion;
		this.titulo = titulo;
		this.deporte = deporte;
		this.distancia = distancia;
		this.fecha_ini = fecha_ini;
		this.duracion = duracion;
	}
	
	public Sesion() {
		super();
		this.idSesion = "";
		this.titulo = "";
		this.deporte = null;
		this.distancia = 0;
		this.fecha_ini = "";
		this.duracion = 0;
	}

	public String getIdSesion() {
		return idSesion;
	}

	public void setIdSesion(String idSesion) {
		this.idSesion = idSesion;
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
