package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Funcionario extends Pessoa {
	private float salario;
	private String cargo;
	
	public Funcionario(String cpf, String nome, Date dataNascimento, String telefone, long id, Endereco endereco,
			float salario) {
		super(cpf, nome, dataNascimento, telefone, id, endereco);
		this.salario = salario;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	

}
