package server;


import java.rmi.Naming;


import server.remote.IStravaFaçade;
import server.remote.StravaFaçade;

public class MainProgram{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IStravaFaçade remoteFaçade = StravaFaçade.getInstance();
			Naming.rebind(name, remoteFaçade);
			System.out.println("* Strava Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the Strava server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
