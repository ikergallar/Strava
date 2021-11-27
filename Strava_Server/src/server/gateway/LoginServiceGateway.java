package server.gateway;

import java.rmi.Naming;


public class LoginServiceGateway {
	

	private static LoginServiceGateway instance;
	private ILogin currencyConvService;
		
	private LoginServiceGateway() {
		try {		
			String URL = "//127.0.0.1:1099/Login";
			this.currencyConvService = (ICurrencyExchange) Naming.lookup(URL);			} catch (Exception ex) {
			System.err.println("# Error locating remote fa�ade: " + ex);
		}
	}
		
	public static LoginServiceGateway getInstance() {
		if(instance == null) {
			instance = new LoginServiceGateway();
		}
			
		return instance;
	}
	

}
