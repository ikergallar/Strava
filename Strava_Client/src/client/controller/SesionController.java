package client.controller;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import client.serviceLocator.ServiceLocator;
import server.data.dto.SesionDTO;

public class SesionController {
	
	private ServiceLocator serviceLocator;
	
	public SesionController(ServiceLocator serviceLocator) {
		this.serviceLocator = serviceLocator; 
	}
	
	public ArrayList<SesionDTO> buscarSesiones(String titulo, int distancia,Date fecha_ini, int duracion){
	        try {
	            return this.serviceLocator.getService().buscarSesiones(titulo,distancia,fecha_ini,duracion);
	        }catch (RemoteException e){
	            System.out.println("# Error buscando sesiones: " + e);
	            return null;
	        }
	    }
	public void crearSesion(long token ,String titulo, String deporte, int distancia, Date fecha_ini, int duracion) {
		try {
			this.serviceLocator.getService().crearSesion(token, titulo, deporte, distancia, fecha_ini, duracion);
		}catch (RemoteException e){
			System.out.println("# Error creando sesiones: " + e);
		}
	}
}
