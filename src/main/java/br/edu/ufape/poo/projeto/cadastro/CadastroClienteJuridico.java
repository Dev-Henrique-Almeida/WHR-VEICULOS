package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CadastroClienteJuridico {
	
	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;
	
	public ClienteJuridico save(ClienteJuridico entity) {
			return repositorioClienteJuridico.save(entity);
		}
	
	public void delete(ClienteJuridico entity) {
		repositorioClienteJuridico.delete(entity);
		}

	public void deleteByCnpj(String cnpj) {
		 repositorioClienteJuridico.deleteByCnpj(cnpj);
	}
	
	public List<ClienteJuridico> findByCnpj(String cnpj) {
		return repositorioClienteJuridico.findByCnpj(cnpj);
	}

	public List<ClienteJuridico> findByNomeFantasia(String nomeFantasia) {
		return repositorioClienteJuridico.findByNomeFantasia(nomeFantasia);
	}

	public List<ClienteJuridico> findAll() {
		return repositorioClienteJuridico.findAll();
	}

}
