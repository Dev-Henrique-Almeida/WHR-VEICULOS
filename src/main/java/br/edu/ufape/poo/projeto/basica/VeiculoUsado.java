package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoUsado extends Veiculo {
	private String revisado;
	private String unicoDono;

	public VeiculoUsado() {
		super();
	}

	public VeiculoUsado(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo, String revisado,
			String unicoDono) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo);
		this.revisado = revisado;
		this.unicoDono = unicoDono;
	}

	public String getRevisado() {
		return revisado;
	}

	public String getUnicoDono() {
		return unicoDono;
	}

	@Override
	public String toString() {
		return "VeiculoUsado [modelo=" + getModelo() + ", valorCompraVeiculo=" + getValorCompraVeiculo()
				+ ", valorVenda=" + getValorVenda() + ", vendido=" + getVendido() + ", revisado=" + revisado
				+ ", unicoDono=" + unicoDono + "]";
	}

}
