package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemVenda;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroOrdemVenda {

	@Autowired
	private RepositorioOrdemVenda repositorioOrdemVenda;

	public OrdemVenda findbyCodigoVenda(String codigoVenda) {
		return repositorioOrdemVenda.findbyCodigoVenda(codigoVenda);
	}

	public void deleteBycodigoVenda(String codigoVenda) {
		repositorioOrdemVenda.deleteBycodigoVenda(codigoVenda);
	}

	public OrdemVenda save(OrdemVenda entity) {
		return repositorioOrdemVenda.save(entity);
	}

	public List<OrdemVenda> findAll() {
		return repositorioOrdemVenda.findAll();
	}

	public void deleteById(Long id) {
		repositorioOrdemVenda.deleteById(id);
	}
	
}
