package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.data.Usuario;
import server.db.DBManager;
import server.service.LoginService;

public class StravaFašade extends UnicastRemoteObject implements IStravaFašade{
	
	private static final long serialVersionUID = 1L;
	public static StravaFašade instance;
	public Usuario state;

	protected StravaFašade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static StravaFašade getInstance() {
		if (instance == null) {
			try {
				instance = new StravaFašade();
			} catch (Exception ex) {
				System.err.println("# Error creating Fašade: " + ex);
			}
		}
		
		return instance;
	}
	
	public boolean login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFa├žade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	@Override
	public boolean register(String email, String username, String pass) throws RemoteException {
		System.out.println(" * RemoteFa├žade register: " + email + " / " + pass);
		Usuario user = new Usuario();
		DBManager.getInstance().registrarUsuario(user);	
		return true;
	}

}