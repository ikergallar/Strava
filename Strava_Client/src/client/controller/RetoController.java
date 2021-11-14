package client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import client.serviceLocator.ServiceLocator;
import server.data.dto.RetoDTO;

public class RetoController {
	
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public void crearReto(String nombre, String fecha_ini, String fecha_fin, int distancia, String deporte, long token) {
		try {
			this.serviceLocator.getService().crearReto(nombre, fecha_ini, fecha_fin, distancia, deporte, token);
		} catch (RemoteException e) {
			System.out.println("# Error creando un reto: " + e);		
		}	
	}
	
	public boolean apuntarseReto(long token, int idReto) {
		try {
			return this.serviceLocator.getService().apuntarseReto(token, idReto);
		}catch (RemoteException e){
			System.out.println("# Error aceptando un reto: " + e);
			return false;			
		}
	}
	
	public ArrayList<RetoDTO> buscarRetos(String nombre, String fecha_ini, String fecha_fin, int distancia){
		try {
			return this.serviceLocator.getService().buscarRetos(nombre, fecha_ini, fecha_fin, distancia);
		}catch (RemoteException e){
			System.out.println("# Error buscando retos: " + e);
			return null;			
		}
	}
}
