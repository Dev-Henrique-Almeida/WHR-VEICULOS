package br.edu.ufape.poo.projeto.exceptions;

public class NomeUnicoException extends Exception {

	private static final long serialVersionUID = 1L;

	public NomeUnicoException() {
		super("Erro ao cadastrar, nome da marca e nome do modelo devem ser diferentes!");
	}

}
