package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogleRemote extends Remote{
	public boolean loginGoogle(String email, String contrasenia) throws RemoteException;
	public void registrarUsuarioGoogle(String username, String email, String contrasenia, int peso, int altura) throws RemoteException;

}
