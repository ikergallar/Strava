package server.test;

import java.util.List;

import server.data.dao.UsuarioDAO;
import server.data.domain.Sesion;
import server.data.domain.Usuario;

public class LocalDataBaseTest {

	public static void main(String[] args) {		
		try {
			//Create Users
			Usuario user0 = new Usuario();
			user0.setEmail("aticus@gmail.com");
			user0.setUsername("Aticus");
			user0.setPass("raticus");			
							
			Usuario user1 = new Usuario();
			user1.setEmail("misaga@gmail.com");
			user1.setUsername("Micho");
			user1.setPass("rasaga");	
			
			Usuario user2 = new Usuario();
			user2.setEmail("xabster@gmail.com");
			user2.setUsername("Xabster");
			user2.setPass("rabster");	
			
			
			Sesion sesion = new Sesion();		
			sesion.setTitulo("aaa");
			sesion.setFecha_ini("12/12/12");
			sesion.setDistancia(12);
			sesion.setDuracion(13);
			sesion.setCreador(user0);
			
			
			//Save Users in the DB
			UsuarioDAO.getInstance().save(user0);
			UsuarioDAO.getInstance().save(user1);
			UsuarioDAO.getInstance().save(user2);
		} catch (Exception ex) {
			System.out.println("\t$ Error storing data:" + ex.getMessage());
		}			
		
		//Make several Queries
		try {

			System.out.println(" - Retreiving all users ...");
			List<Usuario> users = UsuarioDAO.getInstance().getAll();
			System.out.println("\t- " + users.size() + " users retreived!");
			
			for (Usuario user : users) {
				System.out.println("\t- " + user);
			}
			
			Usuario user = null;
		
			if (!users.isEmpty()) {
				System.out.println(" - Retreiving an user by email '" + users.get(0).getEmail() + "' ...");
				user = UsuarioDAO.getInstance().find(String.valueOf(users.get(0).getEmail()));
				
				if (user != null) {
					System.out.println("\t- " + user);
				}				
			}
			
			
			
			System.out.println(" - Retreiving all users ...");
			users = UsuarioDAO.getInstance().getAll();
			System.out.println("\t- " + users.size() + " users retreived!");
			
			
		} catch (Exception ex) {
			System.out.println("\t$ Testing DAO: " + ex.getMessage());
		}
	}
}