package br.edu.ufape.poo.projeto.cadastro.exceptions;

public class ValorNuloExpection extends Exception {

	private static final long serialVersionUID = 1L;

	public ValorNuloExpection() {
		super("Erro ao cadastrar, informações inválidas!");
	}

}
