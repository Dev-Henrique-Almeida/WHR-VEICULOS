package br.edu.ufape.poo.projeto.basica;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import br.edu.ufape.poo.projeto.cadastro.exceptions.CilindradasForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PassageirosForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PotenciaForaRangeException;

@Entity
public class Modelo extends Marca implements IModelo {

	private String nomeModelo;
	private String motor;

	private String cor;
	private int anoFabricado;
	private int potencia;
	private int quantidadePassageiros;
	private float cilindradas;
	private String cambio;
	private String combustivel;

	@OneToMany(mappedBy = "modelo")
	private List<Veiculo> veiculos;

	public Modelo() {
		super();
	}

	public Modelo(String nomeMarca, String nomeModelo, String motor, String cor, int anoFabricado, int potencia,
			int quantidadePassageiros, float cilindradas, String cambio, String combustivel) {
		super(nomeMarca);

		this.nomeModelo = nomeModelo;
		this.motor = motor;
		this.cor = cor;
		this.anoFabricado = anoFabricado;
		this.potencia = potencia;
		this.quantidadePassageiros = quantidadePassageiros;
		this.cilindradas = cilindradas;
		this.cambio = cambio;
		this.combustivel = combustivel;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public String getMotor() {
		return motor;
	}

	public String getCor() {
		return cor;
	}

	public int getAnoFabricado() {
		return anoFabricado;
	}

	public int getPotencia() {
		return potencia;
	}

	public int getQuantidadePassageiros() {
		return quantidadePassageiros;
	}

	public float getCilindradas() {
		return cilindradas;
	}

	public String getCambio() {
		return cambio;
	}

	public String getCombustivel() {
		return combustivel;
	}

	@Override
	public boolean checarPassageiros(int quantidade) throws PassageirosForaRangeException {
		if (quantidade < 0) {
			throw new PassageirosForaRangeException("Erro ao cadastrar modelo, quantidade de passageiros inválida!");
		} else {
			return true;
		}

	}

	@Override
	public boolean checarAno(int ano) throws DataForaRangeException {
		if (ano < 0) {
			throw new DataForaRangeException("Erro ao cadastrar modelo, ano fabricado inválido!");
		} else {
			return true;
		}
	}

	@Override
	public boolean chegarPotencia(int potencia) throws PotenciaForaRangeException {
		if (potencia < 0) {
			throw new PotenciaForaRangeException("Erro ao cadastrar modelo, valor da potencia inválida!");
		} else {
			return true;
		}
	}

	@Override
	public boolean chegarCilindradas(int cilindradas) throws CilindradasForaRangeException {
		if (cilindradas < 0) {
			throw new CilindradasForaRangeException("Erro ao cadastrar modelo, valor de cilindradas inválido!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Modelo [marca=" + getNomeMarca() + ", nomeModelo=" + nomeModelo + ", motor=" + motor + ", cor=" + cor
				+ ", anoFabricado=" + anoFabricado + ", potencia=" + potencia + ", quantidadePassageiros="
				+ quantidadePassageiros + ", cilindradas=" + cilindradas + ", cambio=" + cambio + ", combustivel="
				+ combustivel + "]";
	}

}
