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

	public UsuarioDTO usuarioToDTO(Usuario user) {
		UsuarioDTO dto = new UsuarioDTO();
		
		dto.setUsername(user.getUsername());
		dto.setEmail(user.getEmail());
		dto.setBornDate(user.getBornDate());
		dto.setPeso(user.getPeso());
		dto.setAltura(user.getAltura());

		return dto;
	}
	
	 public List<UsuarioDTO> usuarioToDTO(List<Usuario> list) {
	    	List <UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
	    	for (Usuario u : list) {
	    		UsuarioDTO dto = new UsuarioDTO();
	    		
	    		dto.setUsername(u.getUsername());
	    		dto.setEmail(u.getEmail());
	    		dto.setBornDate(u.getBornDate());
	    		dto.setPeso(u.getPeso());
	    		dto.setAltura(u.getAltura());
	    		
	    		usuarios.add(dto);
	    	}
	        
	        return usuarios;
	    }

}