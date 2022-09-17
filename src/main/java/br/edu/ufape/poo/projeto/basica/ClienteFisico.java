package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ClienteFisico extends Pessoa {

	public ClienteFisico() {
		super();
	}

	public ClienteFisico(String cpf, String nome, Date dataNascimento, String telefone, Endereco endereco) {
		super(cpf, nome, dataNascimento, telefone, endereco);

	}

	@Override
	public String toString() {
		return "ClienteFisico [cpf=" + getCpf() + ", nome=" + getNome() + ", endereco=" + getEndereco()
				+ ", dataNascimento=" + getDataNascimento() + ", telefone=" + getTelefone() + "]";
	}

}
