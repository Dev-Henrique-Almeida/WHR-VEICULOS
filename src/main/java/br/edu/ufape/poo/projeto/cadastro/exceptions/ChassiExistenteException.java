package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class ChassiExistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	public ChassiExistenteException() {
		super("Erro ao cadastrar veículo, chassi já existe, por favor informe outro Chassi!");
	}

}