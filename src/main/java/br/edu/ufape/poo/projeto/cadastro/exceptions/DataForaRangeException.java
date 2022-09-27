package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class DataForaRangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataForaRangeException() {
		super("Erro ao cadastrar, data inválida!");
	}

}
