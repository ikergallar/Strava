package server.remote;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import server.data.dto.DeporteDTO;
import server.data.dto.RetoDTO;
import server.data.dto.SesionDTO;

public interface IRemoteFaçade extends Remote{
	public long login(String email, String pass) throws RemoteException;
	public void logout(long token) throws RemoteException; 
	public void registro(String username, String email, String pass, float peso, int altura) throws RemoteException;
	public boolean existeUsuario(String username, String email)throws RemoteException;
	public String getUserTipo(String email)throws RemoteException;
	
	public boolean apuntarseReto(long token, int idReto) throws RemoteException;
	public ArrayList<RetoDTO> getRetos() throws RemoteException;
	public void crearReto(String nombre, Date fecha_ini, Date fecha_fin, int distancia, DeporteDTO deporte, long token) throws RemoteException;
	
	public ArrayList<SesionDTO> buscarSesiones(String titulo, int distancia,Date fecha_ini,  int duracion) throws RemoteException;
	public void crearSesion(long token ,String titulo, DeporteDTO deporte, int distancia, Date fecha_ini, int duracion) throws RemoteException;
	
	public boolean loginGoogle(String email, String pass)throws RemoteException;
	public boolean loginFacebook(String email, String pass)throws RemoteException;
	
	public void registroGoogle(String username, String email, String pass, float peso, int altura) throws RemoteException;
	public void registroFacebook(String username, String email, String pass, float peso, int altura) throws RemoteException;
	
	public List<String> getNombres()throws RemoteException;
	public DeporteDTO getDeporte(String deporte)throws RemoteException;
}