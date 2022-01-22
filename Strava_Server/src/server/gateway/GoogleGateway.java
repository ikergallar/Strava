package server.gateway;

import java.rmi.Naming;
import java.rmi.RemoteException;

import server.data.dao.UsuarioDAO;
import server.data.domain.Usuario;
import server.remote.IGoogleRemote;

public class GoogleGateway implements ILoginGateway{
	

	private static GoogleGateway instance;
	private IGoogleRemote googleService;
		
	public GoogleGateway() {
		try {		
			String URL = "//127.0.0.1:1099/GoogleServer";
			this.googleService = (IGoogleRemote) Naming.lookup(URL);
		} catch (Exception ex) {
			System.err.println("# Error locating google gateway: " + ex);
		}
	}
		
	public static GoogleGateway getInstance() {
		if(instance == null) {
			instance = new GoogleGateway();
		}
			
		return instance;
	}
	
	
	public boolean login(String email,String pass) throws RemoteException {
		if (this.googleService.loginGoogle(email, pass)) {
			return true;
		}else{
			return false;
		}
		
	}

	public void registro(String username, String email, String pass, float peso, int altura) throws RemoteException{
		this.googleService.registrarUsuarioGoogle(username, email, pass, peso, altura);
	}
	
}
