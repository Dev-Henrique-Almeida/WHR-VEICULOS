package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoUsado extends Veiculo {
	private String km;
	private String revisado;
	private String unicoDono;

	public VeiculoUsado() {
		super();
	}

	public VeiculoUsado(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo, String km,
			String revisado, String unicoDono) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo);
		this.km = km;
		this.revisado = revisado;
		this.unicoDono = unicoDono;
	}

	public String getKm() {
		return km;
	}

	public String isRevisado() {
		return revisado;
	}

	public String getUnicoDono() {
		return unicoDono;
	}

	@Override
	public String toString() {
		return "VeiculoUsado [modelo=" + getModelo() + ", valorCompraVeiculo=" + getValorCompraVeiculo()
				+ ", valorVenda=" + getValorVenda() + ", vendido=" + getVendido() + ", km=" + km + ", revisado="
				+ revisado + ", unicoDono=" + unicoDono + "]";
	}

}
