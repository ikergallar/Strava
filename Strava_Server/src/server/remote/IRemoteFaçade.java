package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.data.dto.RetoDTO;
import server.data.dto.SesionDTO;

public interface IRemoteFaçade extends Remote{
	public long login(String email, String pass) throws RemoteException;
	public void logout(long token) throws RemoteException; 
	public void registro(String username, String pass, String email, float peso, int altura) throws RemoteException;
	public boolean existeUsuario(String username, String email)throws RemoteException;

	public boolean apuntarseReto(long token, int idReto) throws RemoteException;
	public ArrayList<RetoDTO> getRetos() throws RemoteException;
	public void crearReto(String nombre, String fecha_ini, String fecha_fin, int distancia, String deporte, long token) throws RemoteException;
	
	public ArrayList<SesionDTO> buscarSesiones(String titulo, int distancia,String fecha_ini,  int duracion) throws RemoteException;
	public void crearSesion(long token ,String titulo, String deporte, int distancia, String fecha_ini, int duracion) throws RemoteException;
	
	public boolean loginGoogle(String email, String pass)throws RemoteException;
	public boolean loginFacebook(String email, String pass)throws RemoteException;
	
	public boolean registroGoogle(String email,String pass) throws RemoteException;
	public void registroFacebook(String email, String pass) throws RemoteException;

}