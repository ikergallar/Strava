package server.service;

import java.util.ArrayList;
import java.util.List;

import server.data.dao.RetoDAO;
import server.data.domain.Deporte;
import server.data.domain.Reto;
import server.data.domain.Usuario;

public class RetoService {
	
	private static RetoService instance;

	public RetoService() { }
	
	public static RetoService getInstance() {
		if (instance == null) {
			instance = new RetoService();
		}
		
		return instance;
	}
	
	private ArrayList<Reto> retos = new ArrayList<Reto>();
		
	public void crearReto(String nombre, String fecha_ini, String fecha_fin, int distancia,  String deporte, Usuario creador) {
		
		Reto reto = new Reto();
		reto.setNombre(nombre);
		reto.setFecha_ini(fecha_ini);
		reto.setFecha_fin(fecha_fin);
		reto.setDistancia(distancia);
		reto.setIdCreador(creador.getIdUsuario());
		
		RetoDAO.getInstance().save(reto);
			
	}
	
	public List<Reto> buscarReto(String nombre, String fecha_ini, String fecha_fin, int distancia) {
		
        List<Reto> reto = RetoDAO.getInstance().getFiltros(nombre, fecha_ini, fecha_fin, distancia);
		
		return reto;
	
	}
	
	public boolean apuntarseReto(Usuario user, int idReto) {
			
		Reto reto = null;
		
		for (Reto re : this.retos) {
			if (re.getIdReto() == idReto ) {
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
