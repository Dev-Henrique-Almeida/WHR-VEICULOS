package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteJuridico {
	
	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;

	public ClienteJuridico findBycnpj(String cnpj) {
		return repositorioClienteJuridico.findBycnpj(cnpj);
	}

	public void deleteByCnpj(String cnpj) {
		repositorioClienteJuridico.deleteByCnpj(cnpj);
	}
	public void delete(ClienteJuridico entity) {
		repositorioClienteJuridico.delete(entity);
	}

	public ClienteJuridico findByNomeFantasia(String nomeFantasia) {
		return repositorioClienteJuridico.findByNomeCnpj(nomeFantasia);
	}

	public ClienteJuridico save(ClienteJuridico entity) {
		return repositorioClienteJuridico.save(entity);
	}

	public List<ClienteJuridico> findAll() {
		return repositorioClienteJuridico.findAll();
	}

}
