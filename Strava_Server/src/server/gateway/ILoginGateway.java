package server.gateway;

import java.rmi.RemoteException;

public interface ILoginGateway {
	
	public boolean login(String email,String pass) throws RemoteException;
	public void registro(String username, String email, String pass, float peso, int altura) throws RemoteException;
}
