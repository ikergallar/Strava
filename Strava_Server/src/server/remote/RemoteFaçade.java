package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import server.data.domain.Usuario;
import server.service.LoginService;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	private LoginService loginService = new LoginService();

	public RemoteFaçade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		Usuario user = loginService.login(email, password);
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}

}