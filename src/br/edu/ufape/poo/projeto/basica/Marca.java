package br.edu.ufape.poo.projeto.basica;

public abstract class Marca {
	private String nome;
	private long id;

	public Marca(String nome, long id) {
		super();
		this.nome = nome;
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
}

