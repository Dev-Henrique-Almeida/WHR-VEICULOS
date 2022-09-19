package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo {

	private float valorCompraVeiculo;
	private float valorVenda;
	private boolean vendido;
	private float km;
	private String chassi;

	@ManyToOne
	@JoinColumn(name = "modelo_id")
	private Modelo modelo;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Veiculo() {
	}

	public Veiculo(float valorCompraVeiculo, float valorVenda, boolean vendido, float km, String chassi,
			Modelo modelo) {
		this.valorCompraVeiculo = valorCompraVeiculo;
		this.valorVenda = valorVenda;
		this.vendido = vendido;
		this.km = km;
		this.chassi = chassi;
		this.modelo = modelo;

	}

	public long getId() {
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

	public float getKm() {
		return km;
	}

	public String getChassi() {
		return chassi;
	}

	@Override
	public String toString() {
		return "Veiculo [valorCompraVeiculo=" + valorCompraVeiculo + ", valorVenda=" + valorVenda + ", vendido="
				+ vendido + ", km=" + km + ", chassi=" + chassi + ", modelo=" + modelo + ", id=" + id + "]";
	}

}
