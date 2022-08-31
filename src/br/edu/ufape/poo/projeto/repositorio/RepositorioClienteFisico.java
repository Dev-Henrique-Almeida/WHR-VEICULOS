package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import java.util.List;



public interface RepositorioClienteFisico {

	void adicionarClienteFisico(ClienteFisico c);

	ClienteFisico procurarClienteFisicoNome(String nome);

	ClienteFisico procurarClienteFisicoCpf(String cpf);

	List<ClienteFisico> listarClientesFisico();

	void atualizarClienteFisico(ClienteFisico c);

}
