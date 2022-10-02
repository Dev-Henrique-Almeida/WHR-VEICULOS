package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;

@Entity
public class Funcionario extends Pessoa implements IFuncionario {

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
	public boolean checarSalario(float salario) throws ValorNegativoException {
		if (salario < 0) {
			throw new ValorNegativoException("Erro ao cadastrar funcionário, sálario inválido!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Funcionario [salario=" + salario + ", cargo=" + cargo + ", nome=" + getNome() + ", cpf=" + getCpf()
				+ "]";
	}

}
