package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class DataNulaException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataNulaException() {
		super("Erro ao cadastrar, data de nascimento vazia!");
	}

}
