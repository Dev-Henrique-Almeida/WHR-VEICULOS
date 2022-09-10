package br.edu.ufape.poo.projeto.cadastro;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;

@Service
@Transactional
public class CadastroFuncionario {
	
	@Autowired
	private RepositorioFuncionario repositorioFuncionario;
	
	public Funcionario save(Funcionario entity) {
		return repositorioFuncionario.save(entity);
	}
		
	public void delete(Funcionario entity) {
		repositorioFuncionario.delete(entity);
	}
	
	public List<Funcionario> findByNome(String nome) {
		return repositorioFuncionario.findByNome(nome);
	}
	
	public List<Funcionario> findByCargo(String cargo) {
		return repositorioFuncionario.findByCargo(cargo);
	}
	
	public List<Funcionario> findAll() {
		return repositorioFuncionario.findAll();
	}
	
	public List<Funcionario> deleteByCpf(String cpf) {
		return repositorioFuncionario.deleteByCpf(cpf);
	}
	 
	
}
