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
	
	public CadastroOrdemVenda(RepositorioOrdemVenda repositorioOrdemVenda) {
		this.repositorioOrdemVenda = repositorioOrdemVenda;
	}
	
	public RepositorioOrdemVenda getRepositorioOrdemVenda() {
		return repositorioOrdemVenda;
	}
	
	public void setRepositorioOrdemVenda(RepositorioOrdemVenda repositorioOrdemVenda) {
		this.repositorioOrdemVenda = repositorioOrdemVenda;
	}
	
	public OrdemVenda procurarOrdemVenda(String codigoVenda) {
		return repositorioOrdemVenda.procurarOrdemVenda(codigoVenda);
	}

	public OrdemVenda procurarProcurarVendedor(Funcionario f) {
		return repositorioOrdemVenda.procurarVendedor(f);
	}

	public List<OrdemVenda> listarOrdemVendaPessoaJuridica() {
		return repositorioOrdemVenda.listarOrdemVendaPessoaJuridica();
	}
	
	public List<OrdemVenda> listarOrdemVendaPessoaFisica() {
		return repositorioOrdemVenda.listarOrdemVendaPessoaFisica();
	}

}
