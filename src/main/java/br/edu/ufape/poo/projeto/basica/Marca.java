package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Marca {
	
	private String nome;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Marca(String nome) {
		super();
		this.nome = nome;
	}
	
	public Marca() {
		
	}

	public Long getId() {
		return id;
	}

	public String getNomeMarca() {
		return nome;
	}

}

