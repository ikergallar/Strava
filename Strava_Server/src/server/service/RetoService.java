package server.service;

import java.util.ArrayList;

import server.data.Deporte;
import server.data.Reto;
import server.data.Usuario;

public class RetoService {
	
	private ArrayList<Reto> retos = new ArrayList<Reto>();
	
	public void crearReto(String nombre, String fecha_ini, String fecha_fin, int distancia,  Deporte deporte, Usuario creador) {
		
		Reto reto = new Reto();
		reto.setNombre(nombre);
		reto.setFecha_ini(fecha_ini);
		reto.setFecha_fin(fecha_fin);
		reto.setDeporte(deporte);
		reto.setDistancia(distancia);
		reto.setDeporte(deporte);
		reto.setCreador(creador);
		
		this.retos.add(reto);
		
		
	}
	public ArrayList<Reto> buscarReto(String nombre, String fecha_ini, String fecha_fin, int distancia) {
		
        ArrayList<Reto> reto = new ArrayList<Reto>();
		
		for (Reto re : this.retos) {
			if (re.getNombre().equals(nombre) || re.getFecha_ini().equals(fecha_ini) || re.getFecha_fin().equals(fecha_fin) || re.getDistancia() == distancia) {
				reto.add(re);
				break;
			}
		}
		
		return reto;
	
	}
	
	public boolean apuntarseReto(Usuario user, String idReto) {
			
		Reto reto = null;
		
		for (Reto re : this.retos) {
			if (re.getIdReto().equals(idReto) ) {
				reto = re;
				break;
			}
		}

		if (reto != null) {
			reto.addParticipante(user);
			
			return true;
		} else {
			return false;
		}
	}

}
