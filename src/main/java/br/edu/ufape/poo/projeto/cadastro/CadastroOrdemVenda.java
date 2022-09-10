package br.edu.ufape.poo.projeto.cadastro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemVenda;

@Service
public class CadastroOrdemVenda {

	@Autowired
	private RepositorioOrdemVenda repositorioOrdemVenda;

	public OrdemVenda save(OrdemVenda entity) {
		return repositorioOrdemVenda.save(entity);
	}
	/*
	public OrdemVenda findbyCodigoVenda(String codigoVenda) {
		return repositorioOrdemVenda.findbyCodigoVenda(codigoVenda);
	}
	
	public void deleteById(Long id) {
		repositorioOrdemVenda.deleteById(id);
	}


	public void deleteBycodigoVenda(String codigoVenda) {
		repositorioOrdemVenda.deleteBycodigoVenda(codigoVenda);
	}
	
	public List<OrdemVenda> findAll() {
		return repositorioOrdemVenda.findAll();
	}
*/
	
	
}
