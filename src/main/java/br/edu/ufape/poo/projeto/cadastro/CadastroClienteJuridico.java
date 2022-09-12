package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;

@Service
@Transactional
public class CadastroClienteJuridico {

	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;

	public ClienteJuridico save(ClienteJuridico entity) throws ClienteJuridicoExistenteException {
		if (Objects.isNull(findByCnpj(entity.getCnpj()))) {
			return repositorioClienteJuridico.save(entity);
		} else {
			throw new ClienteJuridicoExistenteException("Erro ao cadastrar, cliente já existe, por favor informe outro CNPJ!");
		}

	}

	public void delete(ClienteJuridico entity) {
		repositorioClienteJuridico.delete(entity);
	}

	public void deleteByCnpj(String cnpj) {
		repositorioClienteJuridico.deleteByCnpj(cnpj);
	}

	public ClienteJuridico findByCnpj(String cnpj) {
		return repositorioClienteJuridico.findByCnpj(cnpj);
	}

	public ClienteJuridico findByNomeFantasia(String nomeFantasia) {
		return repositorioClienteJuridico.findByNomeFantasia(nomeFantasia);
	}

	public List<ClienteJuridico> findAll() {
		return repositorioClienteJuridico.findAll();
	}

}
