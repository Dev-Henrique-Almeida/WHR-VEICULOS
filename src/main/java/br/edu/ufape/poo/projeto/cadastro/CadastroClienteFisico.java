package br.edu.ufape.poo.projeto.cadastro;
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
/*
	public void deleteByCpf(String cpf) {
		repositorioClienteFisico.deleteByCpf(cpf);
	}



	public ClienteFisico findByCpf(String cpf) {
		return repositorioClienteFisico.findByCpf(cpf);
	}
	
	public ClienteFisico findByNomePF(String nome) {
		return repositorioClienteFisico.findByNomePF(nome);
	}
	
	public List<ClienteFisico> findAll() {
		return repositorioClienteFisico.findAll();
	}
		*/

}
