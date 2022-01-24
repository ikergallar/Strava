package server.test;

import java.text.SimpleDateFormat;

import server.data.dao.DeporteDAO;
import server.data.domain.Deporte;
import server.data.domain.Sesion;
import server.data.domain.Usuario;
import server.service.LoginService;


public class LocalDatabaseTest {
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");


	public static void main(String[] args) {		
		try {
			//Create Data
			Deporte dep = new Deporte();
			dep.setNombre("Running");
			
			Deporte dep1 = new Deporte();
			dep1.setNombre("Ciclismo");	
			
			Usuario u = new Usuario();
			u.setUsername("Xabster");
			u.setEmail("xabster@gmail.com");
			u.setPass("123");
			u.setAltura(177);
			u.setPeso(73);
			
			Usuario u1 = new Usuario();
			u1.setUsername("Aticus");
			u1.setEmail("aticus@gmail.com");
			u1.setPass("1234");
			u1.setAltura(174);
			u1.setPeso(64);
			
			Usuario u2 = new Usuario();
			u2.setUsername("Jhonny");
			u2.setEmail("davila@gmail.com");
			u2.setPass("abcd");
			u2.setAltura(176);
			u2.setPeso(68);
			
			Sesion s = new Sesion();
			s.setTitulo("Contrareloj");
			s.setDeporte("Ciclismo");
			s.setFecha_ini(sdf.parse("12/02/2022"));
			s.setDuracion(27);
			s.setDistancia(37);
			s.setIdCreador(u1.getIdUsuario());
			
			//Save Data in the DB
			DeporteDAO.getInstance().save(dep);
			DeporteDAO.getInstance().save(dep1);
			
			LoginService.getInstance().registro(u.getUsername(), u.getEmail(), u.getPass(), u.getPeso(), u.getAltura(), "Google");
			LoginService.getInstance().registroGoogle(u.getUsername(), u.getEmail(), u.getPass(), u.getPeso(), u.getAltura());
			
			LoginService.getInstance().registro(u1.getUsername(), u1.getEmail(), u1.getPass(), u1.getPeso(), u1.getAltura(), "Facebook");
			LoginService.getInstance().registroFacebook(u1.getUsername(), u1.getEmail(), u1.getPass(), u1.getPeso(), u1.getAltura());

			LoginService.getInstance().registro(u2.getUsername(), u2.getEmail(), u2.getPass(), u2.getPeso(), u2.getAltura(), "Email");

				
		} catch (Exception ex) {
			System.out.println("\t$ Error storing data:" + ex.getMessage());
		}			
		
		
	}
}
