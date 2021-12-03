package server.factory;

import server.gateway.FacebookGateway;
import server.gateway.GoogleGateway;
import server.gateway.ILoginGateway;

public class FactoryGatewayLogin {

public static FactoryGatewayLogin instance = null;
	
	public static FactoryGatewayLogin getInstance() {
		if(instance == null) {
			instance = new FactoryGatewayLogin();
		}
		return instance;
	}
	
	public static ILoginGateway create(LoginEnum login) {
		
		if(login == LoginEnum.GOOGLE) {
			return new GoogleGateway();
		}else if (login == LoginEnum.FACEBOOK) {
			return new FacebookGateway();
		}else
			return null;
	}
	
}