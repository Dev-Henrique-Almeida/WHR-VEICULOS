package br.edu.ufape.poo.projeto.basica;

public class Modelo extends Marca {
	
	
	private String nomeModelo;
	private String motor;
	private float km;
	private String cor;
	private int anoFabricacao;
	private int potencia;
	private int quantidadePassageiros;
	private float cilindradas;
	private boolean cambio;
	private String combustivel;
	
	public Modelo(String nome) {
		super(nome);
	}

	public Modelo(String nome, String nomeModelo, String motor, float km, String cor, int anoFabricacao, int potencia,
			int quantidadePassageiros, float cilindradas, boolean cambio, String combustivel) {
		super(nome);
		this.nomeModelo = nomeModelo;
		this.motor = motor;
		this.km = km;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.potencia = potencia;
		this.quantidadePassageiros = quantidadePassageiros;
		this.cilindradas = cilindradas;
		this.cambio = cambio;
		this.combustivel = combustivel;
	}
	
	
}
