package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa {
	private String cpf;
	private String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@OneToOne(cascade = CascadeType.ALL)
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
		return this.id;
	}
	public String getCpf() {
		return this.cpf;
	}
	public String getNome() {
		return this.nome;
	}
}
