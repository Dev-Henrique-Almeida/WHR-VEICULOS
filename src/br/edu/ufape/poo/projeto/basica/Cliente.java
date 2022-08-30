package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class Cliente {
	private String idCompras[];
	
	public Cliente(String[] idCompras) {
		super();
		this.idCompras = idCompras;
	}

	public Veiculo[] consultarVeiculos(Veiculo[] veiculos) {
		return  null;
	}

	public boolean agendarVisita(Veiculo v, Date d) {
		return false;
	}
	

	
}
