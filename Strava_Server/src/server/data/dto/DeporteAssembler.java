package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.domain.Deporte;

public class DeporteAssembler {
	
	private static DeporteAssembler instance;

	private DeporteAssembler() { }
	
	public static DeporteAssembler getInstance() {
		if (instance == null) {
			instance = new DeporteAssembler();
		}
		
		return instance;
	}

	public DeporteDTO deporteToDTO(Deporte deporte) {
		DeporteDTO dto = new DeporteDTO();		
		dto.setNombre(deporte.getNombre());
		return dto;
	}
	
	public Deporte DTOTodeporte(DeporteDTO dto) {
		Deporte deporte = new Deporte();		
		deporte.setNombre(dto.getNombre());
		return deporte;
	}

	public List<DeporteDTO> deporteToDTO(List<Deporte> deportes) {		
		List<DeporteDTO> dtos = new ArrayList<>();
		
		for (Deporte dep : deportes) {
			dtos.add(this.deporteToDTO(dep));
		}
		
		return dtos;
	}
}
