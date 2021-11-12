package server;


import java.rmi.Naming;


import server.remote.IRemoteFa�ade;
import server.remote.RemoteFa�ade;

public class MainProgram{

	public static void main(String[] args) {

		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];

		try {		
			IRemoteFa�ade remoteFa�ade = new RemoteFa�ade();
			Naming.rebind(name, remoteFa�ade);
			System.out.println("* Strava Server '" + name + "' active and waiting...");
		} catch (Exception e) {
			System.err.println("- Exception running the Strava server: " + e.getMessage());
			e.printStackTrace();
		}
	}
	
}