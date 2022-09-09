package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroFuncionario {
	
	@Autowired
	private RepositorioFuncionario repositorioFuncionario;
	
	public Funcionario save(Funcionario entity) {
		return repositorioFuncionario.save(entity);
	}
	
	public ClienteFisico save(ClienteFisico entity) {
		return repositorioFuncionario.save(entity);
	}
	
	public ClienteJuridico save(ClienteJuridico entity) {
		return repositorioFuncionario.save(entity);
	}

	public Funcionario findByNome(String nome) {
		return repositorioFuncionario.findByNome(nome);
	}
	
	public Funcionario findByCargo(String cargo) {
		return repositorioFuncionario.findByCargo(cargo);
	}
	
	/*public Veiculo findByVeiculo(Veiculo v) {
		return repositorioFuncionario.findByVeiculo(v);
	}
	*/
	public void delete(Funcionario entity) {
			repositorioFuncionario.delete(entity);
	}

	public List<Funcionario> findAll() {
		return repositorioFuncionario.findAll();
	}
	
	public void deleteByCpf(String cpf) {
		repositorioFuncionario.deleteByCpf(cpf);
	}
		
	public List<Funcionario> findAllFuncionario() {
		return repositorioFuncionario.findAll();
	}
	/*
	public List<Veiculo> findAllVeiculo(){
		return repositorioFuncionario.findAllVeiculo();
	}*/
	
	
}
