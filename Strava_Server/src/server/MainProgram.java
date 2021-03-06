package server;


import java.rmi.Naming;


import server.remote.IRemoteFašade;
import server.remote.RemoteFašade;

public class MainProgram{

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IRemoteFašade remoteFašade = new RemoteFašade();
			Naming.rebind(name, remoteFašade);
			System.out.println("* Strava Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the Strava server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}