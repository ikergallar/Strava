package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Sesion;
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
	

	@Override
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

}