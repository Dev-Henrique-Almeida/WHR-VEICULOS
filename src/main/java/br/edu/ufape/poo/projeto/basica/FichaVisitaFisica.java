package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;

@Entity
public class FichaVisitaFisica implements IFichaVisita {

	private Date data;

	@OneToOne
	private ClienteFisico clientePF;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	public FichaVisitaFisica() {
		super();
	}

	public FichaVisitaFisica(ClienteFisico clientePF, Date data) {
		super();
		this.data = data;
		this.clientePF = clientePF;
	}

	public Date getData() {
		return data;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean checarData(Date data) throws DataForaRangeException {
		if (data.before(new Date())) {
			throw new DataForaRangeException("Erro ao agendar, data inválida!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "FichaVisitaFisica [data=" + data + ", clientePF=" + clientePF + ", id=" + id + "]";
	}

}
