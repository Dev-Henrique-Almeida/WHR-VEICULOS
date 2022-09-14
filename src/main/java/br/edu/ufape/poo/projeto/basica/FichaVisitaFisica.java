package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class FichaVisitaFisica {
		
	private Date data;
	
	@OneToOne
	private ClienteFisico clientePF;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	public FichaVisitaFisica(ClienteFisico clientePF, Date data) {
		super();
		this.data = data;
		this.clientePF = clientePF;
	}

	public FichaVisitaFisica() {
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
		return "FichaVisitaFisica [data=" + data + ", clientePF=" + clientePF + ", id=" + id + "]";
	}

	
	
	

	
}
