package br.edu.ufape.poo.projeto.fachada;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;

@Service
public class Concessionaria {
	@Autowired
	private CadastroClienteFisico cadastroClienteFisico;
	
	@Autowired
	private CadastroFuncionario cadastroFuncionario;


	public ClienteFisico save(ClienteFisico entity) {
		return cadastroClienteFisico.save(entity);
	}
	
	public Funcionario save(Funcionario entity) {
		return cadastroFuncionario.save(entity);
	}

	//public void deleteByCpf(String cpf) {
	//	cadastroClienteFisico.deleteByCpf(cpf);
	//}

	//public void delete(ClienteFisico entity) {
	//	cadastroClienteFisico.delete(entity);
	//}
	
	//public ClienteFisico findByCpf(String cpf) {
	//	return cadastroClienteFisico.findByCpf(cpf);
	//}
	
	//public ClienteFisico findByNomePF(String nome) {
	//	return cadastroClienteFisico.findByNomePF(nome);
	//}
	/*
	public List<ClienteFisico> findAll() {
		return cadastroClienteFisico.findAll();
	}*/
	
	
}
