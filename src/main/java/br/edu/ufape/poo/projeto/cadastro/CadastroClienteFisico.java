package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;

@Service
@Transactional
public class CadastroClienteFisico {

	@Autowired
	private RepositorioClienteFisico repositorioClienteFisico;

	public ClienteFisico save(ClienteFisico entity)
			throws DataNulaException, ValorNuloExpection, ClienteFisicoExistenteException {

		if (Objects.isNull(entity.getDataNascimento())) {
			throw new DataNulaException("Erro ao cadastrar, data de nascimento vazia!");
		} else {
			if (Objects.isNull(entity.getNome()) || Objects.isNull(entity.getCpf())
					|| Objects.isNull(entity.getEndereco().getCidade())
					|| Objects.isNull(entity.getEndereco().getEstado()) || Objects.isNull(entity.getEndereco().getRua())
					|| Objects.isNull(entity.getEndereco().getCep()) || Objects.isNull(entity.getEndereco().getNumero())
					|| Objects.isNull(entity.getTelefone())) {
				throw new ValorNuloExpection("Erro ao cadastrar, informações inválidas!");
			} else {
				if (Objects.isNull(findByCpf(entity.getCpf()))) {
					return repositorioClienteFisico.save(entity);
				} else { 
					throw new ClienteFisicoExistenteException(
							"Erro ao cadastrar, cliente já existe, por favor informe outro CPF!");
				}
			}
		}
	}

	public void delete(ClienteFisico entity) {
		repositorioClienteFisico.delete(entity);
	}

	public ClienteFisico findByCpf(String cpf) { // mudar o find em outras classes
		return repositorioClienteFisico.findByCpf(cpf);
	}

	public ClienteFisico findByNome(String nome) {
		return repositorioClienteFisico.findByNome(nome);
	}

	public ClienteFisico findById(long id) {
		return repositorioClienteFisico.findById(id);
	}

	public List<ClienteFisico> findAll() {
		return repositorioClienteFisico.findAll();
	}

	public void deleteByCpf(String cpf) {
		repositorioClienteFisico.deleteByCpf(cpf);
	}

}
