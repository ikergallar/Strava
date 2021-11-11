package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.Reto;

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

    	dto.setNombre(reto.getNombre());
		dto.setFecha_ini(reto.getFecha_ini());
        dto.setFecha_fin(reto.getFecha_fin());
        dto.setDistancia(reto.getDistancia());
        dto.setDeporte(reto.getDeporte());
        dto.setCreador(reto.getCreador());

        return dto;
    }
    
    public List<RetoDTO> entityToDTO(List<Reto> list) {
    	List <RetoDTO> retos = new ArrayList<RetoDTO>();
    	for (Reto r : list) {
    		RetoDTO dto = new RetoDTO();
    		
    		dto.setNombre(r.getNombre());
    		dto.setFecha_ini(r.getFecha_ini());
            dto.setFecha_fin(r.getFecha_fin());
            dto.setDistancia(r.getDistancia());
            dto.setDeporte(r.getDeporte());
            dto.setCreador(r.getCreador());
            
            retos.add(dto);
    	}
        
        return retos;
    }

}
