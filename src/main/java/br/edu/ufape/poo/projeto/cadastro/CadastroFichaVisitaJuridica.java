package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.FichaVisitaJuridica;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFichaVisitaJuridica;

@Service
@Transactional
public class CadastroFichaVisitaJuridica {
	
	@Autowired
	private RepositorioFichaVisitaJuridica repositorioFichaVisitaJuridica;

	
	public FichaVisitaJuridica save(FichaVisitaJuridica entity) {
		return repositorioFichaVisitaJuridica.save(entity);
	}
	
	public void delete(FichaVisitaJuridica entity) {
		repositorioFichaVisitaJuridica.delete(entity);
	}

	public List<FichaVisitaJuridica> findAll() {
		return repositorioFichaVisitaJuridica.findAll();
	}

	

	
	
}
