package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class ClienteJuridicoExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ClienteJuridicoExistenteException() {
		super("Erro ao cadastrar, cliente já existe, por favor informe outro CNPJ!");
	}

}
