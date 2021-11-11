package server;


import java.rmi.Naming;


import server.remote.IStravaFa�ade;
import server.remote.StravaFa�ade;

public class MainProgram{

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IStravaFa�ade remoteFa�ade = StravaFa�ade.getInstance();
			Naming.rebind(name, remoteFa�ade);
			System.out.println("* Strava Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the Strava server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	
}
