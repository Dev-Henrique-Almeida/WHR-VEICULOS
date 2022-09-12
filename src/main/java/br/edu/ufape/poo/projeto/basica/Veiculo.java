package br.edu.ufape.poo.projeto.basica;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {
	private float valorCompraVeiculo;
	private float valorVenda;
	private boolean vendido;

	@OneToOne(cascade = CascadeType.ALL)
	private Modelo modelo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Veiculo() {
	}

	public Veiculo(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo) {
		this.valorCompraVeiculo = valorCompraVeiculo;
		this.valorVenda = valorVenda;
		this.vendido = vendido;
		this.vendido = vendido;
		this.modelo = modelo;

	}

	public Long getId() {
		return id;
	}

	public float getValorVenda() {
		return valorVenda;
	}

	public float getValorCompraVeiculo() {
		return valorCompraVeiculo;
	}

	public boolean getVendido() {
		return vendido;
	}

	public Modelo getModelo() {
		return modelo;
	}

	@Override
	public String toString() {
		return "Veiculo [valorCompraVeiculo=" + valorCompraVeiculo + ", valorVenda=" + valorVenda + ", vendido="
				+ vendido + ", modelo=" + modelo + "]";
	}

}
