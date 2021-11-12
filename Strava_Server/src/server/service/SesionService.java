package server.service;

import java.util.ArrayList;

import server.data.Deporte;
import server.data.Sesion;
import server.data.Usuario;

public class SesionService {
	
private ArrayList<Sesion> sesiones = new ArrayList<Sesion>();
	
	public void crearSesion(String titulo, Deporte deporte, int distancia, String fecha_ini, int duracion, Usuario creador) {
		
		Sesion sesion = new Sesion();
		sesion.setTitulo(titulo);
		sesion.setDeporte(deporte);
		sesion.setDistancia(distancia);
		sesion.setFecha_ini(fecha_ini);
		sesion.setDuracion(duracion);
		sesion.setCreador(creador);
		
		this.sesiones.add(sesion);
		
		
	}
	public ArrayList<Sesion> buscarSesion(String titulo, Deporte deporte, int distancia, String fecha_ini, int duracion) {
		
        ArrayList<Sesion> sesion = new ArrayList<Sesion>();
		
		for (Sesion se : this.sesiones) {
			if (se.getTitulo().equals(titulo) || se.getDeporte() == deporte || se.getDistancia() == distancia || se.getFecha_ini().equals(fecha_ini) || se.getDuracion() == duracion) {
				sesion.add(se);
				break;
			}
		}
		
		return sesion;
	
	}
	
}
