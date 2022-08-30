package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class Pessoa {
	private String cpf;
	private String nome;
	//private Endereco endereco;
	private Date dataNascimento;
	private String telefone;
	
	public Pessoa(String cpf, String nome, Date dataNascimento,
			String telefone){
		this.cpf = cpf;
		this.nome = nome;
		//this.endereco = endereco;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}
}
