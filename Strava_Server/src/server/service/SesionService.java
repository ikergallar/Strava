package server.service;

import java.util.ArrayList;

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

	private ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
	
	public void crearSesion(String titulo, String deporte, int distancia, String fecha_ini, int duracion, Usuario creador) {
		
		Sesion sesion = new Sesion();
		sesion.setTitulo(titulo);
		sesion.setDistancia(distancia);
		sesion.setFecha_ini(fecha_ini);
		sesion.setDuracion(duracion);
		sesion.setCreador(creador);
		
		SesionDAO.getInstance().save(sesion);
		
	}
	public ArrayList<Sesion> buscarSesion(String titulo, int distancia, String fecha_ini, int duracion) {
		
        ArrayList<Sesion> sesion = new ArrayList<Sesion>();
		
		for (Sesion se : this.sesiones) {
			if (se.getTitulo().equals(titulo) ||   se.getDistancia() == distancia || se.getFecha_ini().equals(fecha_ini) || se.getDuracion() == duracion) {
				sesion.add(se);
				break;		
			}
		}
		
		return sesion;
	}
	
}
