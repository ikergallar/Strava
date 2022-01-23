package server.data.dao;

import java.util.ArrayList;
import java.util.Date;
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



	
	 public List<Sesion> getFiltros(String titulo, int distancia, Date fechaIni, int duracion) {
         PersistenceManager pm = pmf.getPersistenceManager();
         Transaction tx = pm.currentTransaction();

         List<Sesion> sesiones = new ArrayList<Sesion>();
 

         try {
             System.out.println("* Viendo todas las Sesiones filtradas");
             tx.begin();

             Extent<Sesion> sesionExtent = pm.getExtent(Sesion.class, true);

             for (Sesion sesion : sesionExtent) {           
                     
            	 Sesion s = new Sesion(sesion.getTitulo(), null, sesion.getDistancia(), sesion.getFecha_ini(), 
                 sesion.getDuracion(),sesion.getIdCreador());  
            	 
            	 int cont = 0;
                 int contV = 0;
                 
            	 if (!s.getTitulo().equals("")) {
                     cont++;
                     if (s.getTitulo().contains(titulo) || s.getTitulo().toLowerCase().contains(titulo)) {
                         contV++;
                     }
                 }
            	 
        //    	 if (!s.getFecha_ini().equals("")) {
          //           cont++;
            //         if (s.getFecha_ini().contains(fechaIni) || s.getFecha_ini().toLowerCase().contains(fechaIni)) {
              //           contV++;
                //     }
                 //}
            	 
            	 if (distancia != 0) {
                     cont ++;
                     if (s.getDistancia() == distancia) {
                         contV++;
                     }
                 }
            	 
            	 if (duracion != 0) {
                     cont ++;
                     if (s.getDuracion() == duracion) {
                         contV++;
                     }
                 }
            	 
            	 if (cont == contV) {
            		 sesiones.add(s);
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
         
         return sesiones;

     }

}