package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class Modelo extends Marca {

	private String nomeModelo;
	private String motor;
	private float km;
	private String cor;
	private int anoFabricado;
	private int potencia;
	private int quantidadePassageiros;
	private float cilindradas;
	private String cambio;
	private String combustivel;

	public Modelo() {
		super();
	}

	public Modelo(String nomeMarca, String nomeModelo, String motor, float km, String cor, int anoFabricado,
			int potencia, int quantidadePassageiros, float cilindradas, String cambio, String combustivel) {
		super(nomeMarca);

		this.nomeModelo = nomeModelo;
		this.motor = motor;
		this.km = km;
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

	public float getKm() {
		return km;
	}

	public String getCor() {
		return cor;
	}

	public int getanoFabricado() {
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
	public String toString() {
		return "Modelo [marca=" + getNomeMarca() + ", nomeModelo=" + nomeModelo + ", motor=" + motor + ", km=" + km
				+ ", cor=" + cor + ", anoFabricado=" + anoFabricado + ", potencia=" + potencia
				+ ", quantidadePassageiros=" + quantidadePassageiros + ", cilindradas=" + cilindradas + ", cambio="
				+ cambio + ", combustivel=" + combustivel + "]";
	}

}
