package server.test;

import server.data.dao.DeporteDAO;
import server.data.domain.Deporte;

public class LocalDatabaseTest {

	public static void main(String[] args) {		
		try {
			//Create Users
			Deporte dep = new Deporte();
			dep.setNombre("Running");
			
			Deporte dep1 = new Deporte();
			dep1.setNombre("Ciclismo");			
						
			//Save Users in the DB
			DeporteDAO.getInstance().save(dep);
			DeporteDAO.getInstance().save(dep1);
		} catch (Exception ex) {
			System.out.println("\t$ Error storing data:" + ex.getMessage());
		}			
		
		
	}
}
