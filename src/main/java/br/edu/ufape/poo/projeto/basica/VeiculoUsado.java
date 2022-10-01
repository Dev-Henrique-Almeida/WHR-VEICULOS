package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaForaRangeException;

@Entity
public class VeiculoUsado extends Veiculo implements IVeiculoUsado {
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
	public boolean checarPlaca(String placa) throws PlacaForaRangeException {
		if (placa.length() > 8 || placa.length() < 8) {
			throw new PlacaForaRangeException("Erro ao cadastrar, placa inválida!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "VeiculoUsado [revisado=" + revisado + ", unicoDono=" + unicoDono + ", placa=" + placa + ", valorVenda="
				+ getValorVenda() + ", vendido()=" + getVendido() + ", km=" + getKm() + ", chassi=" + getChassi() + "]";
	}

}
