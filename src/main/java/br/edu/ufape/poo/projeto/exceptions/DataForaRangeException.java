package br.edu.ufape.poo.projeto.exceptions;

public class DataForaRangeException extends Exception {

	private static final long serialVersionUID = 1L;

	public DataForaRangeException() {
		super("Erro ao cadastrar, data inválida!");
	}

}
