package server.data.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
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
	
	public List<Reto> getRetos() {				
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tx = pm.currentTransaction();

		List<Reto> retos = new ArrayList<>();
		
		SimpleDateFormat formatter= new SimpleDateFormat("dd/mm/yyyy 'at' HH:mm:ss z");
		Date date = new Date(System.currentTimeMillis());
		String fechaString = formatter.format(date);
		Date today = null;
		try {
			today = formatter.parse(fechaString);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			tx.begin();
			
			Extent<Reto> extent = pm.getExtent(Reto.class, true);

			for (Reto reto : extent) {
				if(reto.getFecha_fin().after(today)) {
					retos.add(reto);
				}
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