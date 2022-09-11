package br.edu.ufape.poo.projeto.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;

@Service
public class Concessionaria {
	@Autowired
	private CadastroClienteFisico cadastroClienteFisico;
	
	@Autowired
	private CadastroFuncionario cadastroFuncionario;


	public ClienteFisico save(ClienteFisico entity) throws ClienteFisicoExistenteException {
		return cadastroClienteFisico.save(entity);
	}
	
	public Funcionario save(Funcionario entity) {
		return cadastroFuncionario.save(entity);
	}

	public List<ClienteFisico> findAll() {
		return cadastroClienteFisico.findAll();
	}

	//public void deleteByCpf(String cpf) {
	//	cadastroClienteFisico.deleteByCpf(cpf);
	//}

	//public void delete(ClienteFisico entity) {
	//	cadastroClienteFisico.delete(entity);
	//}
	
	public ClienteFisico findByCpf(String cpf) {
		return cadastroClienteFisico.findByCpf(cpf);
	}
	
	//public ClienteFisico findByNomePF(String nome) {
	//	return cadastroClienteFisico.findByNomePF(nome);
	//}
	/*
	public List<ClienteFisico> findAll() {
		return cadastroClienteFisico.findAll();
	}*/
	
	
}
