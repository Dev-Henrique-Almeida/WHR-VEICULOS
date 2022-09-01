package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.basica.Veiculo;

public interface RepositorioFuncionario {
	public void adicionarFuncionario(Funcionario f);
	public Funcionario atualizarSalarioFuncionario(Funcionario f, float salario);
	public Funcionario atualizarCargoFuncionario(Funcionario f, String cargo);
	public Funcionario procurarFuncionarioNome(String nome);
	public Funcionario procurarFuncionarioCargo(String cargo);
	public Veiculo procurarVeiculo (Veiculo v);
	public void venderVeiculo (OrdemVenda venda);
	public void cadastrarClienteFisico (ClienteFisico cf);
	public void cadastrarClienteJuridico (ClienteJuridico cj);
	
	public List<Funcionario> listarFuncionarios();
	
	
}
