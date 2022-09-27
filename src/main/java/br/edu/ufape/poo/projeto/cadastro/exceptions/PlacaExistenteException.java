package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class PlacaExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public PlacaExistenteException() {
		super("Erro ao cadastrar, placa já existe, por favor informe outra Placa!");
	}

	
	
}
