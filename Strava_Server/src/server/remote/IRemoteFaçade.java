package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IRemoteFa�ade extends Remote{
	public long login(String email, String pass) throws RemoteException;
	public void logout(long token) throws RemoteException; 

}