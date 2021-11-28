package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IFacebookRemote extends Remote{
	
	public boolean loginFacebook(String email, String pass) throws RemoteException;

}
