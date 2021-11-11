package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IStravaFašade extends Remote{
	public boolean register(String email, String username, String pass) throws RemoteException;
	public boolean login(String email, String pass) throws RemoteException;

}