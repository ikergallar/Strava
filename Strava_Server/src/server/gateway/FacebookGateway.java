package server.gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

import server.remote.IFacebookRemote;

public class FacebookGateway implements ILoginGateway{
	
	private static FacebookGateway instance;
	private IFacebookRemote facebookService;
		
	private FacebookGateway() {
		try {		
			String URL = "//127.0.0.1:1099/FacebookServer";
			this.facebookService = (IFacebookRemote) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating facebook gateway: " + ex);
		}
	}
		
	public static FacebookGateway getInstance() {
		if(instance == null) {
			instance = new FacebookGateway();
		}
			
		return instance;
	}
	
	
	public boolean login(String email,String pass) throws RemoteException {
		if (this.facebookService.loginFacebook(email, pass)) {
			return true;
		}else{
			return false;
		}
		
	}

}
