package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;

@Service
@Transactional
public class CadastroClienteJuridico {

	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;

	public ClienteJuridico save(ClienteJuridico entity)
			throws ClienteJuridicoExistenteException, ValorVazioExpection, ValorForaRangeException {

		if (entity.getEndereco().getNumero() < 0 || entity.getCnpj().length() < 14 || entity.getCnpj().length() > 14
				|| entity.getContato().length() < 15 || entity.getContato().length() > 15
				|| entity.getEndereco().getCep().length() < 8 || entity.getEndereco().getCep().length() > 8) {
			throw new ValorForaRangeException("Erro ao cadastrar, informações inválidas");
		} else {
			if (entity.getNomeEmpresarial().isEmpty() || entity.getNomeFantasia().isEmpty()
					|| entity.getCnpj().isEmpty() || entity.getContato().isEmpty() || entity.getDescricao().isEmpty()
					|| entity.getEndereco().getCidade().isEmpty() || entity.getEndereco().getEstado().isEmpty()
					|| entity.getEndereco().getRua().isEmpty() || entity.getEndereco().getCep().isEmpty()) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {

				if (Objects.isNull(findByCnpj(entity.getCnpj()))) {
					return repositorioClienteJuridico.save(entity);
				} else {
					throw new ClienteJuridicoExistenteException(
							"Erro ao cadastrar, cliente já existe, por favor informe outro CNPJ!");
				}

			}
		}
	}

	public void delete(ClienteJuridico entity) {
		repositorioClienteJuridico.delete(entity);
	}

	public void deleteByCnpj(String cnpj) {
		repositorioClienteJuridico.deleteByCnpj(cnpj);
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
