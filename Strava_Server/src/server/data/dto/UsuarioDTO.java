package server.data.dto;

import java.io.Serializable;


public class UsuarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String username;
	private String email;
	private String bornDate;
	private float peso;
	private int altura;
	private int frecuenciaCardiacaMax;
	private int frecuenciaCardiacaReposo;
	
	public UsuarioDTO(String username, String email, String bornDate, float peso, int altura, int frecuenciaCardiacaMax,
			int frecuenciaCardiacaReposo) {
		super();
		this.username = username;
		this.email = email;
		this.bornDate = bornDate;
		this.peso = peso;
		this.altura = altura;
		this.frecuenciaCardiacaMax = frecuenciaCardiacaMax;
		this.frecuenciaCardiacaReposo = frecuenciaCardiacaReposo;
	}

	public UsuarioDTO() {
		super();
		this.username = "";
		this.email = "";
		this.bornDate = "";
		this.peso = 0;
		this.altura = 0;
		this.frecuenciaCardiacaMax = 0;
		this.frecuenciaCardiacaReposo = 0;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
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

}
