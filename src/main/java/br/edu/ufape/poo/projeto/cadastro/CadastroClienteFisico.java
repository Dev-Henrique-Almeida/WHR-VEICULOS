package br.edu.ufape.poo.projeto.cadastro;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;


@Service
@Transactional
public class CadastroClienteFisico {
	
	@Autowired
	private RepositorioClienteFisico repositorioClienteFisico;

	public ClienteFisico save(ClienteFisico entity) throws ClienteFisicoExistenteException {
		if(findByCpf(entity.getCpf()) == null) {
			return repositorioClienteFisico.save(entity);
		}
		else {
			throw new ClienteFisicoExistenteException();
			
		}
	}

	public void delete(ClienteFisico entity) {
		repositorioClienteFisico.delete(entity);
	}
	
	public ClienteFisico findByCpf(String cpf) {   // mudar o find em outras classes
		return repositorioClienteFisico.findByCpf(cpf);
	}
	
	public List<ClienteFisico> findAll() {
		return repositorioClienteFisico.findAll();
	}
	
	public ClienteFisico findByNome(String nome){
		return repositorioClienteFisico.findByNome(nome);
	}

	public void deleteByCpf(String cpf) {
		repositorioClienteFisico.deleteByCpf(cpf);
	}

	
	

}
