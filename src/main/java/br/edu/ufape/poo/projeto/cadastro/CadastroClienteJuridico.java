package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;

@Service
@Transactional
public class CadastroClienteJuridico {

	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;

	public ClienteJuridico save(ClienteJuridico entity) throws ValorNuloExpection, ClienteJuridicoExistenteException {

		if (entity.getNomeEmpresarial().isEmpty() || entity.getNomeFantasia().isEmpty() || entity.getCnpj().isEmpty()
				|| entity.getContato().isEmpty() || entity.getDescricao().isEmpty()
				|| entity.getEndereco().getCidade().isEmpty() || entity.getEndereco().getEstado().isEmpty()
				|| entity.getEndereco().getRua().isEmpty() || entity.getEndereco().getCep().isEmpty()) {
			throw new ValorNuloExpection();
		} else {

			if (Objects.isNull(findByCnpj(entity.getCnpj()))) {
				return repositorioClienteJuridico.save(entity);
			} else {
				throw new ClienteJuridicoExistenteException();
			}

		}
	}
	
	public ClienteJuridico update(ClienteJuridico entity) {
		return repositorioClienteJuridico.save(entity);
	}
	
	public void delete(ClienteJuridico entity) {
		repositorioClienteJuridico.delete(entity);
	}

	public void deleteByCnpj(String cnpj) {
		repositorioClienteJuridico.deleteByCnpj(cnpj);
	}
	
	public void deleteById(long id) {
		repositorioClienteJuridico.deleteById(id);
	}

	public ClienteJuridico findById(long id) {
		return repositorioClienteJuridico.findById(id);
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
