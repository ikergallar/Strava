package server.data.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable
public class Usuario {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idUsuario;
	@Unique
	private String username;
	private String pass;
	@Unique
	private String email;
	private String bornDate;
	private float peso;
	private int altura;
	private int frecuenciaCardiacaMax;
	private int frecuenciaCardiacaReposo;

	public Usuario(String username, String pass, String email, String bornDate, float peso, int altura,
		int frecuenciaCardiacaMax, int frecuenciaCardiacaReposo) {
		super();
		this.username = username;
		this.pass = pass;
		this.email = email;
		this.bornDate = bornDate;
		this.peso = peso;
		this.altura = altura;
		this.frecuenciaCardiacaMax = frecuenciaCardiacaMax;
		this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
	}
	
	public Usuario() {
			super();
			this.username = "";
			this.pass = "";
			this.email = "";
			this.bornDate = null;
			this.peso = 0;
			this.altura = 0;
			this.frecuenciaCardiacaMax = 0;
			this.frecuenciaCardiacaReposo = 0;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getBornDate() {
		return bornDate;
	}

	public void setBornDate(String bornDate) {
		this.bornDate = bornDate;
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

	public int getFrecuenciaCardiacaMax() {
		return frecuenciaCardiacaMax;
	}

	public void setFrecuenciaCardiacaMax(int frecuenciaCardiacaMax) {
		this.frecuenciaCardiacaMax = frecuenciaCardiacaMax;
	}

	public int getFrecuenciaCardiacaReposo() {
		return frecuenciaCardiacaReposo;
	}

	public void setFrecuenciaCardiacaReposo(int frecuenciaCardiacaReposo) {
		this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
	}
	
	public boolean checkPassword(String password) {
		return this.pass.equals(password);
	}

}
