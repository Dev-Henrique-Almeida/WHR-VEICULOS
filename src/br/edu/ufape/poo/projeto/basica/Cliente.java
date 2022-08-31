package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class Cliente {
	private String idCompras[];
	private long id;
	
	public Cliente(String[] idCompras, long id) {
		super();
		this.idCompras = idCompras;
		this.id = id;
	}

	public Veiculo[] consultarVeiculos(Veiculo[] veiculos) {
		return  null;
	}

	public boolean agendarVisita(Veiculo v, Date d) {
		return false;
	}
	
	public Long getId() {
		return id;
	}
	
	

	
}
