package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogleRemote extends Remote{
	public boolean loginGoogle(String email, String contrasenia) throws RemoteException;
	public boolean registrarUsuarioGoogle(String email, String contrasenia) throws RemoteException;

}
