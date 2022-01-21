package server.data;

public class UsuarioFacebook {

	public String email;
	public String pass;

	public UsuarioFacebook(String email, String pass) {
		super();
		this.email = email;
		this.pass = pass;
	}

	public UsuarioFacebook() {
		super();
		this.email = "";
		this.pass = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean checkPassword(String password) {
		return this.pass.equals(password);
	}

}
