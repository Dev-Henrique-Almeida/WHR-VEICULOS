package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import java.util.List;

import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;


public class CadastroClienteFisico {
	private RepositorioClienteFisico repositorioClienteFisico;
	
	public CadastroClienteFisico(RepositorioClienteFisico repositorioClienteFisico) {
		this.repositorioClienteFisico = repositorioClienteFisico;
	}
	
	public RepositorioClienteFisico getRepositorioClienteFisico() {
		return repositorioClienteFisico;
	}
	
	public void setRepositorioClienteFisico(RepositorioClienteFisico repositorioClienteFisico) {
		this.repositorioClienteFisico = repositorioClienteFisico;
	}
	
	public void adicionarClienteFisico(ClienteFisico c) {
		repositorioClienteFisico.adicionarClienteFisico(c);
	}
	
	public void atualizarClienteFisico(ClienteFisico c) {
		repositorioClienteFisico.atualizarClienteFisico(c);
	}
	
	public ClienteFisico procurarClienteNome(String nome) {
		return repositorioClienteFisico.procurarClienteFisicoNome(nome);
	}

	public ClienteFisico procurarClienteFisicoCpf(String cpf) {
		return repositorioClienteFisico.procurarClienteFisicoCpf(cpf);
	}

	public List<ClienteFisico> listarClientesFisico() {
		return repositorioClienteFisico.listarClientesFisico();
	}


}
