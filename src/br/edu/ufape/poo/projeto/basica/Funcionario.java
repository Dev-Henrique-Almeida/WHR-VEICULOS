package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class Funcionario extends Pessoa {
	private float salario;
	
	public Funcionario(String cpf, String nome, Date dataNascimento, String telefone, long id, Endereco endereco,
			float salario) {
		super(cpf, nome, dataNascimento, telefone, id, endereco);
		this.salario = salario;
	}
	public void venderVeiculo(OrdemVenda venda) {
		
	}
	public void procurarVeiculoNovo(VeiculoNovo veiculo) {
		
	}
	
	public void procurarVeiculoUsado(VeiculoNovo veiculo) {
		
	}

}
