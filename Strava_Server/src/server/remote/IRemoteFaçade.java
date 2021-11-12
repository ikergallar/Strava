package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import server.data.domain.Deporte;
import server.data.dto.DeporteDTO;
import server.data.dto.RetoDTO;
import server.data.dto.SesionDTO;

public interface IRemoteFaçade extends Remote{
	public long login(String email, String pass) throws RemoteException;
	public void logout(long token) throws RemoteException; 
	
	public boolean apuntarseReto(long token, String idReto) throws RemoteException;
	public ArrayList<RetoDTO> buscarRetos(String nombre, String fecha_ini, String fecha_fin, int distancia) throws RemoteException;
	public void crearReto(long token, String nombre, String fecha_ini, String fecha_fin, int distancia, String deporte) throws RemoteException;
	
	public ArrayList<SesionDTO> buscarSesiones(String titulo, String fecha_ini, String deporte, int distancia, int duracion) throws RemoteException;
	public void crearSesion(long token ,String titulo, String deporte, int distancia, String fecha_ini, int duracion) throws RemoteException;

}