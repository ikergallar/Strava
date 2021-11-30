package server;

import java.rmi.Naming;

import server.remote.FacebookRemote;
import server.remote.IFacebookRemote;

public class FacebookServer {
	
	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IFacebookRemote remoteObject = FacebookRemote.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * Facebook Server '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # Facebook Server: " + ex.getMessage());
			ex.printStackTrace();
		}

	}

}
