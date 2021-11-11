package client;

import client.controller.LoginController;
import client.gui.VentanaLogin;
import client.serviceLocator.ServiceLocator;

public class MainProgram {
	
	public static void main(String[] args) {	
		ServiceLocator serviceLocator = new ServiceLocator();
		serviceLocator.setService(args[0], args[1], args[2]);
		
		LoginController loginController = new LoginController(serviceLocator);
		VentanaLogin ventanaLogin = new VentanaLogin();
		ventanaLogin.setVisible(true);
	}

}
