package server;


import java.rmi.Naming;


import server.remote.IRemoteFaçade;
import server.remote.RemoteFaçade;

public class MainProgram{

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IRemoteFaçade remoteFaçade = new RemoteFaçade();
			Naming.rebind(name, remoteFaçade);
			System.out.println("* Strava Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the Strava server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}