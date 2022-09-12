package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
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

	@Column(unique = true)
	private String cpf;

	private String nome;

	public Pessoa() {

	}

	public Pessoa(String cpf, String nome, Date dataNascimento, String telefone, Endereco endereco) {
		this.cpf = cpf;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	private Date dataNascimento;
	private String telefone;

	public Long getId() {
		return this.id;
	}

	public String getCpf() {
		return this.cpf;
	}

	public String getNome() {
		return this.nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

}
