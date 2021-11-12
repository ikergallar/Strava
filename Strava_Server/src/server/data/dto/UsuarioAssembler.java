package server.data.dto;

import java.util.ArrayList;
import java.util.List;

import server.data.domain.Usuario;

public class UsuarioAssembler {
	
	private static UsuarioAssembler instance;

	private UsuarioAssembler() { }
	
	public static UsuarioAssembler getInstance() {
		if (instance == null) {
			instance = new UsuarioAssembler();
		}

		return instance;
	}

	public UsuarioDTO usuario(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setBornDate(user.getBornDate());
		dto.setPeso(user.getPeso());
		dto.setAltura(user.getAltura());
		dto.setFrecuenciaCardiacaMax(user.getFrecuenciaCardiacaMax());
		dto.setFrecuenciaCardiacaReposo(user.getFrecuenciaCardiacaReposo());

		return dto;
	}
	
	 public List<UsuarioDTO> usuario(List<Usuario> list) {
	    	List <UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
	    	for (Usuario u : list) {
	    		UsuarioDTO dto = new UsuarioDTO();
	    		
	    		dto.setUsername(u.getUsername());
	    		dto.setEmail(u.getEmail());
	    		dto.setBornDate(u.getBornDate());
	    		dto.setPeso(u.getPeso());
	    		dto.setAltura(u.getAltura());
	    		dto.setFrecuenciaCardiacaMax(u.getFrecuenciaCardiacaMax());
	    		dto.setFrecuenciaCardiacaReposo(u.getFrecuenciaCardiacaReposo());

	    		usuarios.add(dto);
	    	}
	        
	        return usuarios;
	    }

}
