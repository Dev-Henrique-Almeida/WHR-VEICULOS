package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoNovo extends Veiculo {
	private boolean garantiaFabrica;
	
	public VeiculoNovo() {
		super();
	}
	
	public VeiculoNovo(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo,
			boolean garantiaFabrica) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo);
		this.garantiaFabrica = garantiaFabrica;
	}
	
	public boolean getGarantiaFabrica() {
		return garantiaFabrica;
	}
	@Override
	public String toString() {
		return "VeiculoNovo [garantiaFabrica=" + garantiaFabrica + ", valorCompraVeiculo=" + getValorVenda()
				+ ", vendido=" + getVendido() + ", modelo=" + getModelo() + "]";
	}
	
	
	


}
