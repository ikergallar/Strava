package server.data.dao;

import java.util.ArrayList;
import java.util.List;

import javax.jdo.Extent;
import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.jdo.Transaction;

import server.data.domain.Reto;
import server.data.domain.Sesion;

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
	
	public List<Reto> getFiltros(String nombre, String fechaIni, String fechaFin, int distancia) {
        PersistenceManager pm = pmf.getPersistenceManager();
        Transaction tx = pm.currentTransaction();

        List<Reto> retos = new ArrayList<Reto>();

        try {
            System.out.println("* Viendo todos las Retos filtrados");
            tx.begin();

            Extent<Reto> retoExtent = pm.getExtent(Reto.class, true);

            for (Reto reto : retoExtent) {           
                    
            	Reto r = new Reto(reto.getNombre(), reto.getFecha_ini(), reto.getFecha_fin(), reto.getDistancia(), 
                null, reto.getIdCreador());  
           	 
           	   int cont = 0;
               int contV = 0;
                
           	 if (!r.getNombre().equals("")) {
                    cont++;
                    if (r.getNombre().contains(nombre) || r.getNombre().toLowerCase().contains(nombre)) {
                        contV++;
                    }
             }
           	 
           	 if (!r.getFecha_ini().equals("")) {
                    cont++;
                    if (r.getFecha_ini().contains(fechaIni) || r.getFecha_ini().toLowerCase().contains(fechaIni)) {
                        contV++;
                    }
             }
           	 
           	if (!r.getFecha_fin().equals("")) {
                cont++;
                if (r.getFecha_fin().contains(fechaIni) || r.getFecha_fin().toLowerCase().contains(fechaIni)) {
                    contV++;
                }
           	}
           	 
           	 if (distancia != 0) {
                    cont ++;
                    if (r.getDistancia() == distancia) {
                        contV++;
                    }
             }
           	      	 
           	 if (cont == contV) {
           		 retos.add(r);
           	 }
                    
           }

            tx.commit();
        } catch (Exception ex) {
            System.out.println("$ Error viendo todos Anuncios: " + ex.getMessage());
        } finally {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }

            pm.close();
        }
        
        return retos;

    }

}