package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import server.data.domain.Sesion;

public class SesionDAO extends DataAccessObjectBase implements IDataAccessObject<Sesion> {

	private static SesionDAO instance;	
	
	private SesionDAO() { }
	
	public static SesionDAO getInstance() {
		if (instance == null) {
			instance = new SesionDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(Sesion object) {
		super.saveObject(object);
	}

	@Override
	public void delete(Sesion object) {
		super.deleteObject(object);
	}

	@Override
	public List<Sesion> getAll() {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();
		
		List<Sesion> sesiones = new ArrayList<>();

		try {
			tx.begin();
			
			Extent<Sesion> sesionExtent = pm.getExtent(Sesion.class, true);
			
			for (Sesion sesion : sesionExtent) {
				sesiones.add(sesion);
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

		return sesiones;
	}

	@Override
	public Sesion find(String param) {
		// TODO Auto-generated method stub
		return null;
	}

	
}