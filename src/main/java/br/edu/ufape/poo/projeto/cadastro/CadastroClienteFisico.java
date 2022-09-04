package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import java.util.List;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
>>>>>>> 81d867d41c547bc36a74a9634882a7e516545523
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;

<<<<<<< HEAD
@Service
=======

>>>>>>> 81d867d41c547bc36a74a9634882a7e516545523
public class CadastroClienteFisico {
	
	@Autowired
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
