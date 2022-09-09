package br.edu.ufape.poo.projeto.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;

@Service
public class Concessionaria {
	@Autowired
	private CadastroClienteFisico cadastroClienteFisico;

	public ClienteFisico save(ClienteFisico entity) {
		return cadastroClienteFisico.save(entity);
	}

	//public void deleteByCpf(String cpf) {
	//	cadastroClienteFisico.deleteByCpf(cpf);
	//}

	public void delete(ClienteFisico entity) {
		cadastroClienteFisico.delete(entity);
	}
	
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
