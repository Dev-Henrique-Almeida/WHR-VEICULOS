package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaJuridica;

@Service
public class CadastroOrdemPessoaJuridica {

	@Autowired
	private RepositorioOrdemPessoaJuridica repositorioOrdemPessoaJuridica;

	public OrdemVendaPessoaJuridica save(OrdemVendaPessoaJuridica entity) {
		return repositorioOrdemPessoaJuridica.save(entity);
	}

	public void delete(OrdemVendaPessoaJuridica entity) {
		repositorioOrdemPessoaJuridica.delete(entity);
	}

	public List<OrdemVendaPessoaJuridica> findAll() {
		return repositorioOrdemPessoaJuridica.findAll();
	}

	public void deleteById(long id) {
		repositorioOrdemPessoaJuridica.deleteById(id);
	}

	public OrdemVendaPessoaJuridica findById(long id) {
		return repositorioOrdemPessoaJuridica.findById(id);
	}

	public List<OrdemVendaPessoaJuridica> findByPago(boolean pago) {
		return repositorioOrdemPessoaJuridica.findByPago(pago);
	}

}
