package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.repositorio.RepositorioModelo;

@Service
public class CadastroModelo {
	
	@Autowired
	private RepositorioModelo repositorioModelo;

	public Modelo save(Modelo entity) {
		return repositorioModelo.save(entity);
	}

	public void delete(Modelo entity) {
		repositorioModelo.delete(entity);
	}
	
	public List<Modelo> findAll() {
		return repositorioModelo.findAll();
	}

	public List<Modelo> findByNomeModelo(String nomeModelo) {	
		return repositorioModelo.findByNomeModelo(nomeModelo);
	}
	
	public List<Modelo> findByAnoFabricado(int anoFabricado) {
		return repositorioModelo.findByAnoFabricado(anoFabricado);
	}
		

}
