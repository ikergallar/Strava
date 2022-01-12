package client;

import java.rmi.RemoteException;

import client.controller.LoginController;
import client.controller.RetoController;
import client.controller.SesionController;
import client.gui.VentanaLogin;
import client.serviceLocator.ServiceLocator;

public class MainProgram {
	
	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		RetoController retoController = new RetoController(serviceLocator);
		SesionController sesionController = new SesionController(serviceLocator);
		VentanaLogin ventanaLogin = new VentanaLogin(loginController,retoController, sesionController);
		ventanaLogin.setVisible(true);
	}

}
