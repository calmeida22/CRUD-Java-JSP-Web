package com.crudjsp.bean;

public class Usuario {
	
	private int id;
	private String nome;
	private String password;
	private String email;
	private String sexo;
	private String pais;
	
	//Getters e Setters
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getPassword() {
		return this.password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return this.email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSexo() {
		return this.sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getPais() {
		return this.pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	
}
