package server.data.domain;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;
import javax.jdo.annotations.Unique;

@PersistenceCapable(detachable="true")
public class Usuario {
	
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.INCREMENT)
	private int idUsuario;
	@Unique
	private String username;
	@Unique
	private String email;
	private String pass;
	private String bornDate;
	private float peso;
	private int altura;
	private int frecuenciaCardiacaMax;
	private int frecuenciaCardiacaReposo;
	private String usuarioExt;
	
	@Persistent(defaultFetchGroup="true")
	private Reto reto;

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

	public String getUsuarioExt() {
		return usuarioExt;
	}

	public void setUsuarioExt(String usuarioExt) {
		this.usuarioExt = usuarioExt;
	}

}
