package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Reto;

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

	@Override
	public void delete(Reto object) {
		super.deleteObject(object);
	}

	@Override
	public List<Reto> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Reto> retos = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Reto> retoExtent = pm.getExtent(Reto.class, true);
			
			for (Reto reto : retoExtent) {
				retos.add(reto);
			}
						
			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error querying all retos: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return retos;
	}

	@Override
	public Reto find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

}