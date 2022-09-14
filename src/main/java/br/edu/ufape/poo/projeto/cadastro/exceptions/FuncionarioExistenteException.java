package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class FuncionarioExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public FuncionarioExistenteException(String message) {
		super(message);
	}

}