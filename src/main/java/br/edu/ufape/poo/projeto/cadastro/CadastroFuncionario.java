package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioFuncionario;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.basica.Veiculo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroFuncionario {
	
	@Autowired
	private RepositorioFuncionario repositorioFuncionario;
	
	public CadastroFuncionario(RepositorioFuncionario repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	public RepositorioFuncionario getRepositorioFuncionario() {
		return repositorioFuncionario;
	}
	
	public void setRepositorioFuncionario (RepositorioFuncionario repositorioFuncionario) {
		this.repositorioFuncionario = repositorioFuncionario;
	}
	
	public void adicionarFuncionario (Funcionario f) {
		repositorioFuncionario.adicionarFuncionario(f);
	}
		
	public Funcionario atualizarSalarioFuncionario (Funcionario f, float salario) {
		return repositorioFuncionario.atualizarSalarioFuncionario(f, salario);
	}
	
	public Funcionario atualizarCargoFuncionario(Funcionario f, String cargo) {
		return repositorioFuncionario.atualizarCargoFuncionario(f, cargo);
	}
	
	public Funcionario procurarFuncionarioNome(String nome) {
		return repositorioFuncionario.procurarFuncionarioNome(nome);
	}
	
	public Funcionario procurarFuncionarioCargo (String cargo) {
		return repositorioFuncionario.procurarFuncionarioCargo(cargo);
	}
	
	public void venderVeiculo (OrdemVenda ordem) {
		repositorioFuncionario.venderVeiculo(ordem);
	}
	
	public void cadastrarClienteFisico(ClienteFisico cf) {
		repositorioFuncionario.cadastrarClienteFisico(cf);
	}
	
	public void cadastrarClientejuridico(ClienteJuridico cj) {
		repositorioFuncionario.cadastrarClienteJuridico(cj);
	}
	
	public Veiculo procurarVeiculo (Veiculo v) {
		return repositorioFuncionario.procurarVeiculo(v);
	}

	public List<Funcionario> listarFuncionarios() {
		return repositorioFuncionario.listarFuncionarios();
	}


}
