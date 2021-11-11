package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import server.data.Usuario;
import server.db.DBManager;
import server.service.LoginService;

public class StravaFa�ade extends UnicastRemoteObject implements IStravaFa�ade{
	
	private static final long serialVersionUID = 1L;
	public static StravaFa�ade instance;
	public Usuario state;

	protected StravaFa�ade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static StravaFa�ade getInstance() {
		if (instance == null) {
			try {
				instance = new StravaFa�ade();
			} catch (Exception ex) {
				System.err.println("# Error creating Fa�ade: " + ex);
			}
		}
		
		return instance;
	}
	
	public boolean login(String email, String password) throws RemoteException {
		System.out.println(" * RemoteFaçade login: " + email + " / " + password);
		this.state = LoginService.getInstance().login(email, password);
		
		return state != null;
	}

	@Override
	public boolean register(String email, String username, String pass) throws RemoteException {
		System.out.println(" * RemoteFaçade register: " + email + " / " + pass);
		Usuario user = new Usuario();
		DBManager.getInstance().registrarUsuario(user);	
		return true;
	}

}