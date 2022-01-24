package server.remote;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import server.data.domain.Deporte;
import server.data.domain.Reto;
import server.data.domain.Sesion;
import server.data.domain.Usuario;
import server.data.dto.DeporteAssembler;
import server.data.dto.DeporteDTO;
import server.data.dto.RetoAssembler;
import server.data.dto.RetoDTO;
import server.data.dto.SesionAssembler;
import server.data.dto.SesionDTO;
import server.service.SesionService;
import server.service.DeporteService;
import server.service.LoginService;
import server.service.RetoService;

public class RemoteFaçade extends UnicastRemoteObject implements IRemoteFaçade{
	
	private static final long serialVersionUID = 1L;
	
	private Map<Long, Usuario> serverState = new HashMap<>();
	
	public RemoteFaçade() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public synchronized long login(String email, String password) throws RemoteException {
		Usuario user = LoginService.getInstance().login(email, password);
		
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
	public void registro(String username, String email, String pass, int peso, int altura) throws RemoteException{
		System.out.println(" * RemoteFaçade registrar usuario: " + username + "/ " + pass + "/ " + email + "/ " + peso+ "/ " + altura);
	    LoginService.getInstance().registro(username, email, pass, peso, altura, "Email");
		
	}
	
	@Override
	public boolean existeUsuario(String username, String email)throws RemoteException{
		System.out.println(" * RemoteFacade get ExisteUsuario");
		return LoginService.getInstance().existeUsuario(username,email);
		}
	
	@Override
	public String getUserTipo(String email)throws RemoteException{
		System.out.println(" * RemoteFacade get getUserTipo" + LoginService.getInstance().getUserTipo(email));
		return LoginService.getInstance().getUserTipo(email);
	}
	
	@Override
	public ArrayList<RetoDTO> getRetos() throws RemoteException{
		System.out.println(" * RemoteFaçade busqueda de retos: " );
		
		List<Reto> retos = RetoService.getInstance().getRetos();
				
		if (retos != null) {
			//Convert domain object to DTO
			return (ArrayList<RetoDTO>) RetoAssembler.getInstance().retoToDTO(retos);
		} else {
			throw new RemoteException("error en buscarRetos()!");
		}
	
	}
	
	@Override
	public void crearReto(String nombre, Date fecha_ini, Date fecha_fin, int distancia, DeporteDTO deporte, long token) throws RemoteException{
		Deporte dep = DeporteAssembler.getInstance().DTOTodeporte(deporte);
		System.out.println(" * RemoteFaçade crear reto: " + nombre + "/ " + fecha_ini + "/ " + fecha_fin + "/ " + deporte+ "/ " + this.serverState.get(token));
	    RetoService.getInstance().crearReto( nombre, fecha_ini, fecha_fin, distancia, dep, this.serverState.get(token));
		
	}
	
	
	@Override
	public boolean apuntarseReto(long token, int idReto) throws RemoteException{
		System.out.println(" * RemoteFaçade apuntarse a un reto: " + idReto + this.serverState.get(token) );
		
		if (this.serverState.containsKey(token)) {	
			if (RetoService.getInstance().apuntarseReto(this.serverState.get(token), idReto)) {
				return true;
			} else {
				throw new RemoteException("error en apuntarseReto()!");
			}
		} else {
			throw new RemoteException("To place a bid you must first log in");
		}
				
	}

	
	@Override
	public ArrayList<SesionDTO> buscarSesiones(String titulo,String deporte, int distancia, Date fecha_ini, int duracion) throws RemoteException{
		System.out.println(" * RemoteFaçade busqueda de sesiones: " + titulo + "/ " + distancia + "/ " + fecha_ini + "/ " + duracion + "/ ");
		
		List<Sesion> sesiones = SesionService.getInstance().buscarSesion(titulo,deporte, distancia, fecha_ini, duracion);
				
		if (sesiones != null) {
			//Convert domain object to DTO
			return (ArrayList<SesionDTO>) SesionAssembler.getInstance().sesionToDTO(sesiones);
		} else {
			throw new RemoteException("error en buscarRetos()!");
		}
		
	}
	
	@Override
	public void crearSesion(long token ,String titulo, DeporteDTO deporte, int distancia, Date fecha_ini, int duracion) throws RemoteException{
		Deporte dep = DeporteAssembler.getInstance().DTOTodeporte(deporte);
		System.out.println(" * RemoteFaçade crear sesion: "  + titulo + "/ " + deporte + "/ " + distancia + "/ " + fecha_ini+ "/ " + duracion+ "/" +this.serverState.get(token));
		SesionService.getInstance().crearSesion(titulo,dep,distancia,fecha_ini,duracion,this.serverState.get(token));
		
	}
	
	@Override
	public boolean loginGoogle(String email, String pass)throws RemoteException{
		System.out.println(" * RemoteFacade get Google Login");
		
		if(LoginService.getInstance().loginGoogle(email, pass)) {
			return true;
		}else {
			throw new RemoteException("loginGoogle() fails!");
		}		
	}
	
	@Override
	public boolean loginFacebook(String email, String pass)throws RemoteException{
		System.out.println(" * RemoteFacade get Facebook Login");
		
		if(LoginService.getInstance().loginFacebook(email, pass)) {
			return true;
		}else {
			throw new RemoteException("loginFacebook() fails!");
			
		}	
	}
	
	@Override
	public void registroGoogle(String username, String email, String pass, int peso, int altura) throws RemoteException {
		System.out.println(" * RemoteFaçade registrar usuario de Google: " + email + "/ " + pass + "/ ");
	    LoginService.getInstance().registroGoogle(username, email, pass, peso, altura);
	    LoginService.getInstance().registro(username, email, pass, peso, altura, "Google");
	}
	
	@Override
	public void registroFacebook(String username, String email, String pass, int peso, int altura) throws RemoteException{
		System.out.println(" * RemoteFaçade registrar usuario de Facebook: " + email + "/ " + pass + "/ ");
		LoginService.getInstance().registroFacebook(username, email, pass, peso, altura);
	    LoginService.getInstance().registro(username, email, pass, peso, altura, "Facebook");
	}
	
	@Override
	public List<String> getNombres()throws RemoteException{
		System.out.println(" * RemoteFacade get Nombre de deportes");
		return DeporteService.getInstance().getNombres();
	}
	
	@Override
	public DeporteDTO getDeporte(String deporte)throws RemoteException{
		System.out.println(" * RemoteFacade get Deportes");
		return DeporteAssembler.getInstance().deporteToDTO(DeporteService.getInstance().getDeporte(deporte));
	}
}