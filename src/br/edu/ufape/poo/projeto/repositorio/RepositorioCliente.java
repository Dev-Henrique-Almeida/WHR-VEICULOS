package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.Cliente;
import java.util.List;



public interface RepositorioCliente {

	void adicionarCliente(Cliente c);

	Cliente procurarClienteNome(String nome);

	Cliente procurarClienteCpf(String cpf);

	List<Cliente> listarClientes();

	void atualizarCliente(Cliente c);

}
