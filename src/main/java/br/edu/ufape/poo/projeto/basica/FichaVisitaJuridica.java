package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class FichaVisitaJuridica {

	private Date data;

	@OneToOne
	private ClienteJuridico clientePJ;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public FichaVisitaJuridica(ClienteJuridico clientePJ, Date data) {
		super();
		this.data = data;
		this.clientePJ = clientePJ;
	}

	public FichaVisitaJuridica() {
		super();
	}

	public Date getData() {
		return data;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "FichaVisitaJuridica [data=" + data + ", clientePJ=" + clientePJ + ", id=" + id + "]";
	}

}
