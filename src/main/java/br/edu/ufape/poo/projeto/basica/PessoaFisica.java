package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PessoaFisica extends Pessoa {

	public PessoaFisica(String cpf, String nome, Date dataNascimento, String telefone, long id, Endereco endereco) {
		super(cpf, nome, dataNascimento, telefone, id, endereco);
	}



}
