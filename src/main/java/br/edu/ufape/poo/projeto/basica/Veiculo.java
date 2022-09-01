package br.edu.ufape.poo.projeto.basica;

public abstract class Veiculo {
	private float valorCompraVeiculo;
	private float valorVenda;
	private boolean vendido;
	private Modelo modelo;
	private long id;

	
	public Veiculo(float valorCompraVeiculo,float valorVenda, boolean vendido,
			Modelo modelo, long id) {
		this.valorCompraVeiculo = valorCompraVeiculo;
		this.valorVenda = valorVenda;
		this.vendido = vendido;
		this.vendido = vendido;
		this.modelo = modelo;
		this.id = id;

	}
	
	public Long getId() {
		return id;
	}
}
