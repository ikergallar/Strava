package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.Sesion;


public class SesionAssembler {
	
	private static SesionAssembler instance;

    private SesionAssembler() { }

    public static SesionAssembler getInstance() {
        if (instance == null) {
            instance = new SesionAssembler();
        }

        return instance;
    }
    
    public SesionDTO sesion(Sesion sesion) {
    	SesionDTO dto = new SesionDTO();

    	dto.setTitulo(sesion.getTitulo());
        dto.setDeporte(sesion.getDeporte());
        dto.setDistancia(sesion.getDistancia());
		dto.setFecha_ini(sesion.getFecha_ini());
        dto.setDuracion(sesion.getDuracion());

        return dto;
    }
    
    public List<SesionDTO> sesionToDTO(List<Sesion> list) {
    	List <SesionDTO> sesiones = new ArrayList<SesionDTO>();
    	for (Sesion s : list) {
    		SesionDTO dto = new SesionDTO();
    		
    		dto.setTitulo(s.getTitulo());
            dto.setDeporte(s.getDeporte());
            dto.setDistancia(s.getDistancia());
    		dto.setFecha_ini(s.getFecha_ini());
            dto.setDuracion(s.getDuracion());
            
            sesiones.add(dto);
    	}
        
        return sesiones;
    }


}
