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
public abstract class Veiculo {
	private float valorCompraVeiculo;
	private float valorVenda;
	private boolean vendido;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Modelo modelo;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
