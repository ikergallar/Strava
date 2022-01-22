package server.data;

public class UsuarioFacebook {

	public String username;
	public String email;
	public String pass;
	public float peso;
	public int altura;
	
	public UsuarioFacebook(String username, String email, String pass, float peso, int altura) {
		super();
		this.username = username;
		this.email = email;
		this.pass = pass;
		this.peso = peso;
		this.altura = altura;
	}

	public UsuarioFacebook() {
		super();
		this.username = "";
		this.email = "";
		this.pass = "";
		this.peso = 0;
		this.altura = 0;

	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public int getAltura() {
		return altura;
	}

	public void setAltura(int altura) {
		this.altura = altura;
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
