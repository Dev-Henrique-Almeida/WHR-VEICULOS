package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.List;



public interface RepositorioClienteJuridico {

	void adicionarClienteJuridico(ClienteJuridico c);

	ClienteJuridico procurarClienteJuridicoNome(String nome);

	ClienteJuridico procurarClienteJuridicoCnpj(String cpf);

	List<ClienteJuridico> listarClientesJuridico();

	void atualizarClienteJuridico(ClienteJuridico c);

}
