package br.edu.ufape.poo.projeto.cadastro;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;


@Service
public class CadastroClienteFisico {
	
	@Autowired
	private RepositorioClienteFisico repositorioClienteFisico;

	public ClienteFisico save(ClienteFisico entity) {
		return repositorioClienteFisico.save(entity);
	}

	public void delete(ClienteFisico entity) {
		repositorioClienteFisico.delete(entity);
	}
	
	public List<ClienteFisico> findByCpf(String cpf) {
		return repositorioClienteFisico.findByCpf(cpf);
	}
	
	public List<ClienteFisico> findAll() {
		return repositorioClienteFisico.findAll();
	}
	
	public List<ClienteFisico> findByNome(String nome){
		return repositorioClienteFisico.findByNome(nome);
	}

	public void deleteByCpf(String cpf) {
		repositorioClienteFisico.deleteByCpf(cpf);
	}

	
	

}
