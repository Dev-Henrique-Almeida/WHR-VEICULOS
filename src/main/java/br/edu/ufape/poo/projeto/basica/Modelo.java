package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;


@Entity
public class Modelo extends Marca {
	
	private String nomeModelo;
	private String motor;
	private float km;
	private String cor;
	private int anoFabricacao;
	private int potencia;
	private int quantidadePassageiros;
	private float cilindradas;
	private boolean cambio;
	private String combustivel;
	
	public Modelo() {
		super();
	}
	
	public Modelo(String nome, String nomeModelo, String motor, float km, String cor, int anoFabricacao,
			int potencia, int quantidadePassageiros, float cilindradas, boolean cambio, String combustivel) {
		super(nome);
		this.nomeModelo = nomeModelo;
		this.motor = motor;
		this.km = km;
		this.cor = cor;
		this.anoFabricacao = anoFabricacao;
		this.potencia = potencia;
		this.quantidadePassageiros = quantidadePassageiros;
		this.cilindradas = cilindradas;
		this.cambio = cambio;
		this.combustivel = combustivel;
	}

	public String getNomeModelo() {
		return nomeModelo;
	}

	public void setNomeModelo(String nomeModelo) {
		this.nomeModelo = nomeModelo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	public int getQuantidadePassageiros() {
		return quantidadePassageiros;
	}

	public void setQuantidadePassageiros(int quantidadePassageiros) {
		this.quantidadePassageiros = quantidadePassageiros;
	}

	public float getCilindradas() {
		return cilindradas;
	}

	public void setCilindradas(float cilindradas) {
		this.cilindradas = cilindradas;
	}

	public boolean isCambio() {
		return cambio;
	}

	public void setCambio(boolean cambio) {
		this.cambio = cambio;
	}

	public String getCombustivel() {
		return combustivel;
	}

	public void setCombustivel(String combustivel) {
		this.combustivel = combustivel;
	}

	
	
}
