package server.db;

import javax.jdo.Extent;
import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.jdo.Transaction;

import server.data.*;

public class DBManager {	
	private static DBManager instance = null;
	private PersistenceManagerFactory pmf = null;
	
	private DBManager() {
		pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");		
	}
	
	public static DBManager getInstance() {
		if (instance == null) {
			instance = new DBManager();
			instance.initializeData();
		}		
		
		return instance;
	}
	
	//GUARDAR OBJETO A BD
	public void registrar(Object obj) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tr = pm.currentTransaction();

		try {
			tr.begin();
			System.out.println("Almacenando en la base de datos...");
			System.out.println(obj);
			pm.makePersistent(obj);
			tr.commit();
		} catch (Exception e) {
			System.out.println("Error en el almacenamiento!!");
		} finally {
			if (tr != null && tr.isActive()) {
				tr.rollback();
			}
			pm.close();
		}
	}
		
	//REGISTRAR USUARIO
	public void registrarUsuario(Usuario user) {
		registrar(user);
	}
	
	//OBTENER USUARIOS
	public Usuario getUsuario(String email) {
		PersistenceManager pm = pmf.getPersistenceManager();
		Transaction tran = pm.currentTransaction();
		
		Usuario usuario = null;
		try {
			System.out.println("Cogiendo usuario con email: " + email);
			tran.begin();
			
			Extent<Usuario> extension = pm.getExtent(Usuario.class, true);
			for (Usuario user : extension) {
				if(user.getEmail().equals(email)) {
					usuario = new Usuario(usuario.getUsername(), usuario.getPass(), usuario.getEmail(), usuario.getBornDate(),  usuario.getPeso(), usuario.getAltura(),usuario.getFrecuenciaCardiacaMax(), usuario.getFrecuenciaCardiacaReposo());
				}
			}
			
			tran.commit();
		} catch (Exception ex) {
			System.out.println(" Error obteniendo usuario: " + ex.getMessage());
		} finally {
			if (tran != null && tran.isActive()) {
				tran.rollback();
			}

			pm.close();
		}

		return usuario;
	}
	
	private void initializeData() {
		System.out.println(" * Initializing data base");
		
		//Datos de ejemplo
		
		Sesion sesion1 = new Sesion("1", "Sesion Nocturna", Deporte.Ciclismo, 80, "12/08/2022", 40);
		Sesion sesion2 = new Sesion("2", "Sesion Express", Deporte.Running, 40, "19/10/2022", 20);
		
		Usuario user1 = new Usuario("aticus", "pass123", "luis@gmail.com", "1/1/1921", 60, 192, 120, 83);
		Usuario user2 = new Usuario("john", "123", "daviuri@gmail.com", "12/11/1991", 70, 172, 114, 73);
		
		Reto reto1 = new Reto("7", "Biking Challenge", "10/05/22", "11/05/22", 50, Deporte.Ciclismo, user1);
		Reto reto2 = new Reto("9", "Impossible Challenge", "23/12/21", "08/01/22", 180, Deporte.Ambos, user2);
			
		try {
			DBManager.getInstance().registrar(user1);
			DBManager.getInstance().registrar(user2);
			DBManager.getInstance().registrar(sesion1);
			DBManager.getInstance().registrar(sesion2);
			DBManager.getInstance().registrar(reto1);
			DBManager.getInstance().registrar(reto2);
			
		} catch (Exception ex) {
			System.out.println(" $ Error initializing data: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	

}
