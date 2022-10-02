package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VendaSemLucroException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Veiculo implements IVeiculo {

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

	@Override
	public boolean compraNegativa(float valorCompra) throws ValorNegativoException {
		if (valorCompra > 0) {
			return true;
		} else {
			throw new ValorNegativoException("Erro ao cadastrar, valor de compra negativo!");
		}
	}

	@Override
	public boolean vendaNegativa(float valorVenda) throws ValorNegativoException {
		if (valorVenda > 0) {
			return true;
		} else {
			throw new ValorNegativoException("Erro ao cadastrar, valor de venda negativo!");
		}
	}

	@Override
	public boolean checarKm(float km) throws ValorNegativoException {
		if (km > 0) {
			return true;
		} else {
			throw new ValorNegativoException("Erro ao cadastrar, km's inválidos!");
		}
	}

	@Override
	public boolean checarChassi(String chassi) throws ChassiForaRangeException {
		if (chassi.length() < 14 || chassi.length() > 14) {
			throw new ChassiForaRangeException("Erro ao cadastrar, chassi inválido!");
		} else {
			return false;
		}
	}
	
	@Override
	public boolean checarValorCompra(float valorCompra, float valorVenda) throws VendaSemLucroException {
		valorCompra = this.valorCompraVeiculo;
		valorVenda = this.valorVenda;
		if(valorCompra > valorVenda) {
			throw new VendaSemLucroException();			
		}
		return false;
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

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
	}

	public float getKm() {
		return km;
	}

	public String getChassi() {
		return chassi;
	}

	public void setVendido(boolean vendido) {
		this.vendido = vendido;
	}

	@Override
	public String toString() {
		return "Veiculo [valorCompraVeiculo=" + valorCompraVeiculo + ", valorVenda=" + valorVenda + ", vendido="
				+ vendido + ", km=" + km + ", chassi=" + chassi + ", modelo=" + modelo + ", id=" + id + "]";
	}

}
