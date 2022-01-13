package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Reto;
import server.data.domain.Sesion;
import server.data.domain.Usuario;

public class RetoDAO extends DataAccessObjectBase implements IDataAccessObject<Reto> {

	private static RetoDAO instance;	
	
	private RetoDAO() { }
	
	public static RetoDAO getInstance() {
		if (instance == null) {
			instance = new RetoDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(Reto object) {
		super.saveObject(object);
	}
	
	public List<Reto> getRetos() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Reto> retos = new ArrayList<>();
		
		try {
			tx.begin();
			
			Extent<Reto> extent = pm.getExtent(Reto.class, true);

			for (Reto reto : extent) {
				retos.add(reto);
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all retos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return retos;
	}

}