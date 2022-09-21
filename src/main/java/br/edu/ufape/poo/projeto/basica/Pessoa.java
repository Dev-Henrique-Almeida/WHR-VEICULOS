package br.edu.ufape.poo.projeto.basica;

import java.util.Calendar;
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

import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pessoa implements IPessoa {

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

	private Date dataNascimento;
	private String telefone;

	@Override
	public boolean checarIdade(Date dataNascimento) throws DateForaRangeException {
		Calendar cData = Calendar.getInstance();
		Calendar cHoje = Calendar.getInstance();
		cData.setTime(dataNascimento);
		cData.set(Calendar.YEAR, cHoje.get(Calendar.YEAR));
		int idade = cData.after(cHoje) ? -1 : 0;
		cData.setTime(dataNascimento);
		idade += cHoje.get(Calendar.YEAR) - cData.get(Calendar.YEAR);

		if (idade >= 18) {
			return true;
		} else {
			throw new DateForaRangeException("Erro ao cadastrar, data inválida");
		}
	}

	public long getId() {
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
		return this.telefone;
	}

}
