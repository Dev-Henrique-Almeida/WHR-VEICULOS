package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteJuridico {
	
	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;
	
	public CadastroClienteJuridico(RepositorioClienteJuridico repositorioClienteJuridico) {
		this.repositorioClienteJuridico = repositorioClienteJuridico;
	}
	
	public RepositorioClienteJuridico getRepositorioClienteJuridico() {
		return repositorioClienteJuridico;
	}
	
	public void setRepositorioClienteJuridico(RepositorioClienteJuridico repositorioClienteJuridico) {
		this.repositorioClienteJuridico = repositorioClienteJuridico;
	}
	
	public void adicionarClienteJuridico(ClienteJuridico c) {
		repositorioClienteJuridico.adicionarClienteJuridico(c);
	}
	
	public void atualizarClienteJuridico(ClienteJuridico c) {
		repositorioClienteJuridico.atualizarClienteJuridico(c);
	}
	
	public ClienteJuridico procurarClienteNome(String nome) {
		return repositorioClienteJuridico.procurarClienteJuridicoNome(nome);
	}

	public ClienteJuridico procurarClienteJuridicoCpf(String cnpj) {
		return repositorioClienteJuridico.procurarClienteJuridicoCnpj(cnpj);
	}

	public List<ClienteJuridico> listarClientesJuridico() {
		return repositorioClienteJuridico.listarClientesJuridico();
	}


}
