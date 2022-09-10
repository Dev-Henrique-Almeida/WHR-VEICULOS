package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String cep;
	private String rua;
	private String cidade;
	private String estado;
	private int numero;
	
	public Endereco() {
	}
	
	public Endereco(String cep, String rua, String cidade, String estado, int numero) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}


	public long getId() {
		return id;
	}


	public String getCep() {
		return cep;
	}


	public String getRua() {
		return rua;
	}


	public String getCidade() {
		return cidade;
	}


	public String getEstado() {
		return estado;
	}


	public int getNumero() {
		return numero;
	}
	


	
	
	
}
