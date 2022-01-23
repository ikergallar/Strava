package server.service;

import java.util.List;

import server.data.dao.DeporteDAO;
import server.data.domain.Deporte;

public class DeporteService {
	
	private static DeporteService instance;

	public DeporteService() { }
	
	public static DeporteService getInstance() {
		if (instance == null) {
			instance = new DeporteService();
		}
		
		return instance;
	}
	
	public List<String> getNombres() {
        return DeporteDAO.getInstance().getNombre();	
	}
	
	public Deporte getDeporte(String deporte) {
        return DeporteDAO.getInstance().getDeporte(deporte);
	}
	
	
}
