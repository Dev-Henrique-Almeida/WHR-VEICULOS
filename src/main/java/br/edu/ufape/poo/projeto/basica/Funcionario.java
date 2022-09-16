package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {

	private float salario;
	private String cargo;

	public Funcionario() {
		super();
	}

	public Funcionario(String cpf, String nome, Date dataNascimento, String telefone, Endereco endereco, float salario,
			String cargo) {
		super(cpf, nome, dataNascimento, telefone, endereco);
		this.salario = salario;
		this.cargo = cargo;
	}

	public float getSalario() {
		return salario;
	}

	public String getCargo() {
		return cargo;
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + salario + ", cargo=" + cargo + ", nome=" + getNome() + ", cpf=" + getCpf()
				+ "]";
	}

}
