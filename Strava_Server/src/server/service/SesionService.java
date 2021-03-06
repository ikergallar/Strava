package server.service;

import java.util.Date;
import java.util.List;

import server.data.dao.SesionDAO;
import server.data.domain.Deporte;
import server.data.domain.Sesion;
import server.data.domain.Usuario;

public class SesionService {
	
	private static SesionService instance;
	
	private SesionService() { }

	public static SesionService getInstance() {
		if (instance == null) {
			instance = new SesionService();
		}
		
		return instance;
	}
	
	public void crearSesion(String titulo, Deporte deporte, int distancia, Date fecha_ini, int duracion, Usuario creador) {
		
		Sesion sesion = new Sesion();
		sesion.setTitulo(titulo);
		sesion.setDeporte(deporte.getNombre());
		sesion.setDistancia(distancia);
		sesion.setFecha_ini(fecha_ini);
		sesion.setDuracion(duracion);
		sesion.setIdCreador(creador.getIdUsuario());
		
		SesionDAO.getInstance().save(sesion);
		
	}
	public List<Sesion> buscarSesion(String titulo, String deporte, int distancia, Date fecha_ini, int duracion) {
		
        List<Sesion> sesion = SesionDAO.getInstance().getFiltros(titulo, deporte, distancia, fecha_ini, duracion);
		
		return sesion;
	}
	
}
