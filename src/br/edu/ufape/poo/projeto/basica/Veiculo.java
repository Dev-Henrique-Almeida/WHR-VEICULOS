package br.edu.ufape.poo.projeto.basica;

public abstract class Veiculo {
	private float valorCompraVeiculo;
	private float valorVenda;
	private boolean vendido;
	private Modelo modelo;

	
	public Veiculo(float valorCompraVeiculo,float valorVenda, boolean vendido,
			Modelo modelo) {
		this.valorCompraVeiculo = valorCompraVeiculo;
		this.valorVenda = valorVenda;
		this.vendido = vendido;
		this.vendido = vendido;
		this.modelo = modelo;

	}
}
