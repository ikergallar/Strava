package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.domain.Reto;

public class RetoAssembler {
	
	private static RetoAssembler instance;

    private RetoAssembler() { }

    public static RetoAssembler getInstance() {
        if (instance == null) {
            instance = new RetoAssembler();
        }

        return instance;
    }
    
    public RetoDTO reto(Reto reto) {
    	RetoDTO dto = new RetoDTO();

    	dto.setIdReto(reto.getIdReto());
    	dto.setNombre(reto.getNombre());
		dto.setFecha_ini(reto.getFecha_ini());
        dto.setFecha_fin(reto.getFecha_fin());
        dto.setDistancia(reto.getDistancia());

        return dto;
    }
    
    public List<RetoDTO> retoToDTO(List<Reto> list) {
    	List <RetoDTO> retos = new ArrayList<RetoDTO>();
    	for (Reto r : list) {
    		RetoDTO dto = new RetoDTO();
    		
        	dto.setIdReto(r.getIdReto());
    		dto.setNombre(r.getNombre());
    		dto.setFecha_ini(r.getFecha_ini());
            dto.setFecha_fin(r.getFecha_fin());
            dto.setDistancia(r.getDistancia());
            
            retos.add(dto);
    	}
        
        return retos;
    }

}
