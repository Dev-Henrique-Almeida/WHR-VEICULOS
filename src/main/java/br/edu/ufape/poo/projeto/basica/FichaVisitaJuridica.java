package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;

@Entity
public class FichaVisitaJuridica implements IFichaVisita {

	private Date data;

	@OneToOne
	private ClienteJuridico clientePJ;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public FichaVisitaJuridica() {
		super();
	}

	public FichaVisitaJuridica(ClienteJuridico clientePJ, Date data) {
		super();
		this.data = data;
		this.clientePJ = clientePJ;
	}

	public Date getData() {
		return data;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean checarData(Date data) throws DataForaRangeException {
		if (this.data.before(new Date())) {
			throw new DataForaRangeException("Erro ao agendar, data inválida!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "FichaVisitaJuridica [data=" + data + ", clientePJ=" + clientePJ + ", id=" + id + "]";
	}

}
