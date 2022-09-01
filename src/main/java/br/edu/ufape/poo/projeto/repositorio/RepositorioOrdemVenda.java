package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.basica.Funcionario;


import java.util.List;

public interface RepositorioOrdemVenda {
	public OrdemVenda procurarOrdemVenda(String codigoVenda);
	public OrdemVenda procurarVendedor(Funcionario f);
	public float procurarOrdemVEndaEntre(float a, float b);
	public List<OrdemVenda> listarOrdemVendaPessoaFisica();
	public List<OrdemVenda> listarOrdemVendaPessoaJuridica();

}
