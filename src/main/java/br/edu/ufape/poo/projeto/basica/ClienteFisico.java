package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

import br.edu.ufape.poo.projeto.exceptions.CpfForaRangeException;

@Entity
public class ClienteFisico extends Pessoa implements IClienteFisico {

	public ClienteFisico() {
		super();
	}

	public ClienteFisico(String cpf, String nome, Date dataNascimento, String telefone, Endereco endereco) {
		super(cpf, nome, dataNascimento, telefone, endereco);

	}

	@Override
	public boolean checarCpf(String cpf) throws CpfForaRangeException {
		if (cpf.length() > 14 || cpf.length() < 14) {
			throw new CpfForaRangeException("Erro ao cadastrar cliente, cpf inválido!");
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		return "ClienteFisico [cpf=" + getCpf() + ", nome=" + getNome() + ", endereco=" + getEndereco()
				+ ", dataNascimento=" + getDataNascimento() + ", telefone=" + getTelefone() + "]";
	}

}
