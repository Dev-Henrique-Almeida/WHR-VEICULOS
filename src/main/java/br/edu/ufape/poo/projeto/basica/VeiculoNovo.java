package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoNovo extends Veiculo {
	private String garantiaFabrica;

	public VeiculoNovo() {
		super();
	}

	public VeiculoNovo(float valorCompraVeiculo, float valorVenda, boolean vendido, String chassi,
			String garantiaFabrica, Modelo modelo) {
		super(valorCompraVeiculo, valorVenda, vendido, 0, chassi, modelo);
		this.garantiaFabrica = garantiaFabrica;
	}

	public String getGarantiaFabrica() {
		return garantiaFabrica;
	}

	@Override
	public String toString() {
		return "VeiculoNovo [garantiaFabrica=" + garantiaFabrica + ", valorVenda=" + getValorVenda()
				+ ", valorCompraVeiculo=" + getValorCompraVeiculo() + ", modelo=" + getModelo() + ", km=" + getKm()
				+ ", chassi=" + getChassi() + "]";
	}

}
