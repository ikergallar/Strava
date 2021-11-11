package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.data.Usuario;
import server.db.DBManager;
import server.service.LoginService;

public class StravaFaçade extends UnicastRemoteObject implements IStravaFaçade{
	
	private static final long serialVersionUID = 1L;
	public static StravaFaçade instance;
	public Usuario state;

	protected StravaFaçade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static StravaFaçade getInstance() {
		if (instance == null) {
			try {
				instance = new StravaFaçade();
			} catch (Exception ex) {
				System.err.println("# Error creating Façade: " + ex);
			}
		}
		
		return instance;
	}
	
	public boolean login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFaÃ§ade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	@Override
	public boolean register(String email, String username, String pass) throws RemoteException {
		System.out.println(" * RemoteFaÃ§ade register: " + email + " / " + pass);
		Usuario user = new Usuario();
		DBManager.getInstance().registrarUsuario(user);	
		return true;
	}

}