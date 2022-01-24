package client.controller;

import java.rmi.RemoteException;
import java.util.List;

import client.serviceLocator.ServiceLocator;
import server.data.dto.DeporteDTO;

public class DeporteController {
	private ServiceLocator serviceLocator;
	
	public DeporteController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public List<String> getNombres(){
	        try {
	            return this.serviceLocator.getService().getNombres();
	        }catch (RemoteException e){
	            System.out.println("# Error buscando nombres de deportes: " + e);
	            return null;
	        }
	    }
	public DeporteDTO getDeporte(String deporte) {
		try {
			return this.serviceLocator.getService().getDeporte(deporte);
		}catch (RemoteException e){
			System.out.println("# Error obteniendo deportes: " + e);
			return null;
		}
	}
}
