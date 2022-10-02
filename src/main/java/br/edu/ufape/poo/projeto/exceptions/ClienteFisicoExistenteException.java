package br.edu.ufape.poo.projeto.exceptions;

public class ClienteFisicoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteFisicoExistenteException() {
		super("Erro ao cadastrar, cliente já existe, por favor informe outro CPF!");
	}

}