package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFichaVisitaFisica;

@Service
@Transactional
public class CadastroFichaVisitaFisica {

	@Autowired
	private RepositorioFichaVisitaFisica repositorioFichaVisitaFisica;

	public FichaVisitaFisica save(FichaVisitaFisica entity) {
		return repositorioFichaVisitaFisica.save(entity);
	}

	public void delete(FichaVisitaFisica entity) {
		repositorioFichaVisitaFisica.delete(entity);
	}

	public List<FichaVisitaFisica> findAll() {
		return repositorioFichaVisitaFisica.findAll();
	}

}
