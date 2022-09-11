package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class ClienteFisicoExistenteException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ClienteFisicoExistenteException() {
		super("Cliente Já Existe, por favor informe outro CPF!");
	}

}
