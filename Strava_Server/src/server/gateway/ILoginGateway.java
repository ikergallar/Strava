package server.gateway;

import java.rmi.RemoteException;

public interface ILoginGateway {
	
	public boolean login(String email,String pass) throws RemoteException;

}
