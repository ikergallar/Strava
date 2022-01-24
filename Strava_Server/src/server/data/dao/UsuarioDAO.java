package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Usuario;

//This class implements Singleton and DAO patterns
public class UsuarioDAO extends DataAccessObjectBase implements IDataAccessObject<Usuario>{

	private static UsuarioDAO instance;	
	
	private UsuarioDAO() { }
	
	public static UsuarioDAO getInstance() {
		if (instance == null) {
			instance = new UsuarioDAO();
		}		
		
		return instance;
	}	
	
	public void save(Usuario object) {
		super.saveObject(object);
	}
	
	public Usuario find(String email) {		
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Usuario result = null; 

		try {
			tx.begin();
			
			Query<?> query = pm.newQuery("SELECT FROM " + Usuario.class.getName() + " WHERE email =='" + email + "'");
			query.setUnique(true);
            result = (Usuario) query.execute();
			
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying a User: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return result;
	}
	
	public static List<Usuario> getUsuarios() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Usuario> usuarios = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Usuario> extent = pm.getExtent(Usuario.class, true);

			for (Usuario usuario : extent) {
				usuarios.add(usuario);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all users: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return usuarios;
	}
	
	public static boolean existeUsuario(String username, String email) {

		boolean existe = false;
		List<Usuario> usuarios = getUsuarios();

		for (Usuario user : usuarios) {
			if (user.getUsername().equals(username) || user.getEmail().equals(email)) {
				existe = true;
			}
		}
		return existe;
	}
	
	public static String getUserTipo(String email) {
		List<Usuario> usuarios = getUsuarios();

		for (Usuario user : usuarios) {
			if (user.getEmail().equals(email)) {
				return user.getUsuarioExt();
			}
		}
		return "";
	}
	
}