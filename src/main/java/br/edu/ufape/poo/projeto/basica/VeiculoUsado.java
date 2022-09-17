package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoUsado extends Veiculo {
	private String revisado;
	private String unicoDono;
	private String placa;

	public VeiculoUsado() {
		super();
	}

	public VeiculoUsado(float valorCompraVeiculo, float valorVenda, boolean vendido, float km, String chassi,
			Modelo modelo, String revisado, String unicoDono, String placa) {
		super(valorCompraVeiculo, valorVenda, vendido, km, chassi, modelo);
		this.revisado = revisado;
		this.unicoDono = unicoDono;
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public String getRevisado() {
		return revisado;
	}

	public String getUnicoDono() {
		return unicoDono;
	}

	@Override
	public String toString() {
		return "VeiculoUsado [revisado=" + revisado + ", unicoDono=" + unicoDono + ", placa=" + placa + ", valorVenda="
				+ getValorVenda() + ", vendido()=" + getVendido() + ", km=" + getKm() + ", chassi=" + getChassi()
				+ "]";
	}

}
