package server.data;

public class UsuarioGoogle {

	public String email;
	public String pass;
	
	
	public UsuarioGoogle(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getpass() {
		return pass;
	}


	public void setpass(String pass) {
		this.pass = pass;
	}
	
}

