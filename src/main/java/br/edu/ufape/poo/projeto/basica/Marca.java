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

	private String nomeMarca;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public Marca() {

	}

	public Marca(String nomeMarca) {
		super();
		this.nomeMarca = nomeMarca;
	}

	public long getId() {
		return id;
	}

	public String getNomeMarca() {
		return nomeMarca;
	}

}
