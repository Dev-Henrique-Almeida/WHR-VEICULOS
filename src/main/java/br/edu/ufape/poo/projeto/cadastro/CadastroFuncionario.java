package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;

@Service
@Transactional
public class CadastroFuncionario {

	@Autowired
	private RepositorioFuncionario repositorioFuncionario;

	public Funcionario save(Funcionario entity) throws FuncionarioExistenteException {
			if (Objects.isNull(findByCpf(entity.getCpf()))) {
 
				return repositorioFuncionario.save(entity);
			} else {

				throw new FuncionarioExistenteException("Erro ao cadastrar, cliente já existe, por favor informe outro CPF!");

			}
	}

	public void delete(Funcionario entity) {
		repositorioFuncionario.delete(entity);
	}

	public Funcionario findByNome(String nome) {
		return repositorioFuncionario.findByNome(nome);
	}

	public Funcionario findByCpf(String cpf) {
		return repositorioFuncionario.findByCpf(cpf);
	}
	
	public Funcionario findByCargo(String cargo) {
		return repositorioFuncionario.findByCargo(cargo);
	}

	public List<Funcionario> findAll() {
		return repositorioFuncionario.findAll();
	}

	public void deleteByCpf(String cpf) {
		repositorioFuncionario.deleteByCpf(cpf);
	}

}
