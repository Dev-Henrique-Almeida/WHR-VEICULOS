package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

import br.edu.ufape.poo.projeto.basica.Veiculo;

@Entity
public class VeiculoNovo extends Veiculo {
	private boolean garantiaFabrica;
	
	public VeiculoNovo() {
		super();
	}
	public VeiculoNovo(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo, long id,
			boolean garantiaFabrica) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo, id);
		this.garantiaFabrica = garantiaFabrica;
	}


}
