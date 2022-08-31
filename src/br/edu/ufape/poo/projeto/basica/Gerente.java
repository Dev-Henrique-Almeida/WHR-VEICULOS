package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public class Gerente extends Funcionario {

	public Gerente(String cpf, String nome, Date dataNascimento, String telefone, long id, Endereco endereco,
			float salario) {
		super(cpf, nome, dataNascimento, telefone, id, endereco, salario);
	}

	public void adicionarVeiculoNovo(VeiculoNovo v) {
		
	}
	
	public void adicionarVeiculoUsado(VeiculoUsado v) {
		
	}
	
	public void removerveiculoNovo(VeiculoNovo v) {
		
	}
	
	public void removerveiculoNovo(VeiculoUsado v) {
		
	}

}
