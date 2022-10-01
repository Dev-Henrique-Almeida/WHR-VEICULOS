package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class VendaSemLucroException extends Exception {

	private static final long serialVersionUID = 1L;

	public VendaSemLucroException() {
		super("Erro ao vender, venda sem lucro!");

	}

}
