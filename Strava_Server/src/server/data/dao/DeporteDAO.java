package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import server.data.domain.Deporte;

public class DeporteDAO extends DataAccessObjectBase implements IDataAccessObject<Deporte> {

	private static DeporteDAO instance;	
	
	private DeporteDAO() { }
	
	public static DeporteDAO getInstance() {
		if (instance == null) {
			instance = new DeporteDAO();
		}		
		
		return instance;
	}	
	
	@Override
	public void save(Deporte object) {
		super.saveObject(object);
	}
	
	public Deporte getDeporte(String deporte) {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		Deporte deportes = new Deporte();
		
		try {
			tx.begin();
			
			Extent<Deporte> extent = pm.getExtent(Deporte.class, true);

			for (Deporte dep : extent) {
				if(dep.getNombre().equals(deporte)) {
					deportes = dep;
				}
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all deportes: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return deportes;
	}
	
	public List<String> getNombre() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<String> nombres = new ArrayList<String>();
		
		try {
			tx.begin();
			
			Extent<Deporte> extent = pm.getExtent(Deporte.class, true);

			for (Deporte dep : extent) {
				nombres.add(dep.getNombre());		
			}

			tx.commit();
		} catch (Exception ex) {
			System.out.println("  $ Error retrieving all deportes: " + ex.getMessage());
		} finally {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}

			pm.close();
		}

		return nombres;
	}




	
	 

}


