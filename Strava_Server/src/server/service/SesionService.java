package server.service;

import java.util.ArrayList;

import server.data.domain.Deporte;
import server.data.domain.Sesion;
import server.data.domain.Usuario;
import server.data.dto.DeporteDTO;

public class SesionService {
	
private ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
	
	public void crearSesion(String titulo, String deporte, int distancia, String fecha_ini, int duracion, Usuario creador) {
		
		Sesion sesion = new Sesion();
		sesion.setTitulo(titulo);
		sesion.getDeporte().setNombre(deporte);;
		sesion.setDistancia(distancia);
		sesion.setFecha_ini(fecha_ini);
		sesion.setDuracion(duracion);
		sesion.setCreador(creador);
		
		this.sesiones.add(sesion);
		
	}
	public ArrayList<Sesion> buscarSesion(String titulo, String deporte, int distancia, String fecha_ini, int duracion) {
		
        ArrayList<Sesion> sesion = new ArrayList<Sesion>();
		
		for (Sesion se : this.sesiones) {
			if (se.getTitulo().equals(titulo) || se.getDeporte().getNombre().equals(deporte)  || se.getDistancia() == distancia || se.getFecha_ini().equals(fecha_ini) || se.getDuracion() == duracion) {
				sesion.add(se);
				break;		
			}
		}
		
		return sesion;
	}
	
}
