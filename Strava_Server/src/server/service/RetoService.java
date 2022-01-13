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
	
	public void crearReto(String nombre, String fecha_ini, String fecha_fin, int distancia,  String deporte, Usuario creador) {
		
		Reto reto = new Reto();
		reto.setNombre(nombre);
		reto.setFecha_ini(fecha_ini);
		reto.setFecha_fin(fecha_fin);
		reto.setDistancia(distancia);
		reto.setIdCreador(creador.getIdUsuario());
		
		RetoDAO.getInstance().save(reto);
			
	}
	
	public List<Reto> getRetos() {
		
        List<Reto> reto = RetoDAO.getInstance().getRetos();
		
		return reto;
	
	}
	
	public boolean apuntarseReto(Usuario user, int idReto) {
			
		Reto reto = null;
        List<Reto> retos = RetoDAO.getInstance().getRetos();

		for (Reto re : retos) {
			if (re.getIdReto() == idReto ) {
				reto = re;
				break;
			}
		}

		if (reto != null) {
			reto.addParticipante(user);
			RetoDAO.getInstance().save(reto);
			return true;
		} else {
			return false;
		}
	}

}
