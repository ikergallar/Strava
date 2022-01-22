package server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.data.dao.RetoDAO;
import server.data.dao.SesionDAO;
import server.data.domain.Deporte;
import server.data.domain.Reto;
import server.data.domain.Sesion;
import server.data.domain.Usuario;
import server.data.dto.DeporteDTO;

public class SesionService {
	
	private static SesionService instance;
	
	private SesionService() { }

	public static SesionService getInstance() {
		if (instance == null) {
			instance = new SesionService();
		}
		
		return instance;
	}
	
	public void crearSesion(String titulo, String deporte, int distancia, Date fecha_ini, int duracion, Usuario creador) {
		
		Sesion sesion = new Sesion();
		sesion.setTitulo(titulo);
		sesion.setDistancia(distancia);
		sesion.setFecha_ini(fecha_ini);
		sesion.setDuracion(duracion);
		sesion.setIdCreador(creador.getIdUsuario());
		
		SesionDAO.getInstance().save(sesion);
		
	}
	public List<Sesion> buscarSesion(String titulo, int distancia, Date fecha_ini, int duracion) {
		
        List<Sesion> sesion = SesionDAO.getInstance().getFiltros(titulo, distancia, fecha_ini, duracion);
		
		return sesion;
	}
	
}
