package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	private long id;
	private Endereco endereco;
	private Date dataNascimento;
	private String telefone;
	
	public Pessoa(String cpf, String nome, Date dataNascimento,
			String telefone, long id, Endereco endereco){
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.id = id;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}
}
