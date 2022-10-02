package br.edu.ufape.poo.projeto.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;

@Service
@Transactional
public class CadastroFuncionario {

	@Autowired
	private RepositorioFuncionario repositorioFuncionario;

	public Funcionario save(Funcionario entity)
			throws FuncionarioExistenteException, ValorNuloExpection, DataNulaException, DataForaRangeException {

		if (entity.getNome().isEmpty() || entity.getCpf().isEmpty() || entity.getTelefone().isEmpty()
				|| entity.getCargo().isEmpty() || entity.getEndereco().getCidade().isEmpty()
				|| entity.getEndereco().getEstado().isEmpty() || entity.getEndereco().getRua().isEmpty()
				|| entity.getEndereco().getCep().isEmpty()) {
			throw new ValorNuloExpection();
		} else {
			if (Objects.isNull(entity.getDataNascimento())) {
				throw new DataNulaException();
			} else {
				if (Objects.isNull(entity.getDataNascimento().after(new Date()))) {
					throw new DataForaRangeException();
				} else {
					if (Objects.isNull(findByCpf(entity.getCpf()))) {

						return repositorioFuncionario.save(entity);
					} else {

						throw new FuncionarioExistenteException();
					}
				}
			}
		}
	}

	public Funcionario update(Funcionario entity) {
		return repositorioFuncionario.save(entity);
	}

	public void delete(Funcionario entity) {
		repositorioFuncionario.delete(entity);
	}
	
	public void deleteByCpf(String cpf) {
		repositorioFuncionario.deleteByCpf(cpf);
	}

	public void deleteById(long id) {
		repositorioFuncionario.deleteById(id);
	}
	
	public Funcionario findByNome(String nome) {
		return repositorioFuncionario.findByNome(nome);
	}

	public Funcionario findByCpf(String cpf) {
		return repositorioFuncionario.findByCpf(cpf);
	}

	public Funcionario findBySalario(float salario) {
		return repositorioFuncionario.findBySalario(salario);
	}

	public Funcionario findByCargo(String cargo) {
		return repositorioFuncionario.findByCargo(cargo);
	}

	public Funcionario findById(long id) {
		return repositorioFuncionario.findByCpf(id);
	}

	public List<Funcionario> findAll() {
		return repositorioFuncionario.findAll();
	}

}
