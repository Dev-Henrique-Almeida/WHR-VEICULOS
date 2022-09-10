package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;

@SpringBootTest
public class TestClienteJuridico {

	@Autowired
	private CadastroClienteJuridico ccj;
	
	@Test
	void cadastroPessoaJuridico() {
		ClienteJuridico cj = new ClienteJuridico("WHR", "WHR Veiculos", "8002-8922", "15749680", null, "Loja de Veiculos");
		ClienteJuridico cj2 = new ClienteJuridico("AMBEV", "AMBEV Bebidas", "1524-8790", "7891535", null, "Distribuidora de Bebidas");
		ClienteJuridico cj3 = new ClienteJuridico("Robert", "Robert", "1524-8790", "120", null, "uma pessoa juridica ai");
		ccj.save(cj);
		ccj.save(cj2);
		ccj.save(cj3);
	}
	
	@Test
	void findCnpjByPessoaJuridica() {
		List<ClienteJuridico> clientes = ccj.findByCnpj("7891535");
		for(ClienteJuridico j: clientes) {
			System.out.println("CPNJ = " + j.toString());
		}
	}
	
	@Test
	void findNomeFantasiaByPessoaJuridica() {
		List<ClienteJuridico> clientes = ccj.findByNomeFantasia("WHR Veiculos");
		for(ClienteJuridico j: clientes) {
			System.out.println("NOME FANTASIA = " + j.toString());
		}
	}
	
	/*@Test
	void deleteCnpjByPessoaJuridica() {
		List<ClienteJuridico> clientes1 = ccj.findAll();
		ccj.deleteByCnpj("120");
		for(ClienteJuridico j: clientes1) {
			System.out.println("EXISTE = " + j.toString());
		}
	}
	*/
}
