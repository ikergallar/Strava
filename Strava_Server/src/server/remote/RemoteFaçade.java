package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import server.data.Deporte;
import server.data.Reto;
import server.data.Sesion;
import server.data.Usuario;
import server.data.dto.RetoAssembler;
import server.data.dto.RetoDTO;
import server.data.dto.SesionAssembler;
import server.data.dto.SesionDTO;
import server.service.SesionService;
import server.service.LoginService;
import server.service.RetoService;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	private LoginService loginService = new LoginService();
	private RetoService retoService = new RetoService();
	private SesionService sesionService = new SesionService();


	public RemoteFaçade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		Usuario user = loginService.login(email, password);
		
		//If login() success user is stored in the Server State
		if (user != null) {
			//If user is not logged in 
			if (!this.serverState.values().contains(user)) {
				Long token = Calendar.getInstance().getTimeInMillis();		
				this.serverState.put(token, user);		
				return(token);
			} else {
				throw new RemoteException("User is already logged in!");
			}
		} else {
			throw new RemoteException("Login fails!");
		}
	}
	
	@Override
	public synchronized void logout(long token) throws RemoteException {
		System.out.println(" * RemoteFacade logout(): " + token);
		
		if (this.serverState.containsKey(token)) {
			//Logout means remove the User from Server State
			this.serverState.remove(token);
		} else {
			throw new RemoteException("User is not logged in!");
		}
	}
	
	@Override
	public ArrayList<RetoDTO> buscarRetos(String nombre, String fecha_ini, String fecha_fin, int distancia) throws RemoteException{
		System.out.println(" * RemoteFaçade busqueda de retos: " + nombre + "/ " + fecha_ini + "/ " + fecha_fin);
		
		ArrayList<Reto> retos = retoService.buscarReto(nombre, fecha_ini, fecha_fin, distancia);
				
		if (retos != null) {
			//Convert domain object to DTO
			return (ArrayList<RetoDTO>) RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("error en buscarRetos()!");
		}
	
	}
	
/*	@Override
	public void crearReto(long token, String nombre, String fecha_ini, String fecha_fin, int distancia, Deporte deporte) throws RemoteException{
		System.out.println(" * RemoteFaçade crear reto: " + nombre + "/ " + fecha_ini + "/ " + fecha_fin + "/ " + deporte+ "/ " + this.serverState.get(token));
	    retoService.crearReto( nombre, fecha_ini, fecha_fin, distancia, deporte, this.serverState.get(token));
		
	}
	
	*/
	
	
	@Override
	public boolean apuntarseReto(long token, String idReto) throws RemoteException{
		System.out.println(" * RemoteFaçade apuntarse a un reto: " + this.serverState.get(token) );
		
		if (this.serverState.containsKey(token)) {						
			//Make the bid using Bid Application Service
			if (retoService.apuntarseReto(this.serverState.get(token), idReto)) {
				return true;
			} else {
				throw new RemoteException("error en apuntarseReto()!");
			}
		} else {
			throw new RemoteException("To place a bid you must first log in");
		}
				
	}

	/*
	@Override
	public ArrayList<SesionDTO> buscarSesiones(String titulo, String fecha_ini, Deporte deporte, int distancia, int duracion) throws RemoteException{
		System.out.println(" * RemoteFaçade busqueda de sesiones: " + titulo + "/ " + fecha_ini + "/ " + distancia + "/ " + deporte);
		
		ArrayList<Sesion> sesiones = sesionService.buscarSesion(titulo, deporte, distancia, fecha_ini, duracion);
				
		if (sesiones != null) {
			//Convert domain object to DTO
			return (ArrayList<SesionDTO>) SesionAssembler.getInstance().sesionToDTO(sesiones);
		} else {
			throw new RemoteException("error en buscarRetos()!");
		}
		
	}
	
	@Override
	public void crearSesion(long token ,String titulo, Deporte deporte, int distancia, String fecha_ini, int duracion) throws RemoteException{
		System.out.println(" * RemoteFaçade crear sesion: " + titulo + "/ " + fecha_ini + "/ " + deporte + "/ " + distancia+ "/ " + this.serverState.get(token));
		sesionService.crearSesion(titulo, deporte, distancia, fecha_ini, duracion, this.serverState.get(token));
		
	}
	*/
	

}