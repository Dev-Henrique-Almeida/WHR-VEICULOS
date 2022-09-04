package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;

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
		return repositorioFuncionario.findbyNome(nome);
	}
	
	public Funcionario findByCargo(String cargo) {
		return repositorioFuncionario.findByCargo(cargo);
	}
	
	public Veiculo findbyVeiculo(Veiculo v) {
		return repositorioFuncionario.findbyVeiculo(v);
	}
	
	public void delete(Funcionario entity) {
			repositorioFuncionario.delete(entity);
	}
	
	public void deleteByCpf(String cpf) {
		repositorioFuncionario.deleteByCpf(cpf);
	}
		
	public List<Funcionario> findAllFuncionario() {
		return repositorioFuncionario.findAllFuncionario();
	}
	
	public List<Veiculo> findAllVeiculo(){
		return repositorioFuncionario.findAllVeiculo();
	}
}
