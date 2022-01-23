package client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.serviceLocator.ServiceLocator;
import server.data.dto.DeporteDTO;
import server.data.dto.RetoDTO;

public class RetoController {
	
	private ServiceLocator serviceLocator;
	
	public RetoController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public void crearReto(String nombre, Date fecha_ini, Date fecha_fin, int distancia, DeporteDTO deporte, long token) {
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
	
	public ArrayList<RetoDTO> getRetos(){
		try {
			return this.serviceLocator.getService().getRetos();
		}catch (RemoteException e){
			System.out.println("# Error buscando retos: " + e);
			return null;			
		}
	}
}
