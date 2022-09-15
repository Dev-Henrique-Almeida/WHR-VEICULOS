package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoNovo extends Veiculo {
	private String garantiaFabrica;

	public VeiculoNovo() {
		super();
	}

	public VeiculoNovo(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo,
			String garantiaFabrica) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo);
		this.garantiaFabrica = garantiaFabrica;
	}

	public String getGarantiaFabrica() {
		return garantiaFabrica;
	}

	@Override
	public String toString() {
		return "VeiculoNovo [garantiaFabrica=" + garantiaFabrica + ", valorCompraVeiculo=" + getValorVenda()
				+ ", vendido=" + getVendido() + ", modelo=" + getModelo() + "]";
	}

}
