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
	void savePessoaJuridico() {
		ClienteJuridico cj = new ClienteJuridico("WHR", "WHR Veiculos", "8002-8922", "15749680", null, "Loja de Veiculos");
		ClienteJuridico cj2 = new ClienteJuridico("AMBEV", "AMBEV Bebidas", "1524-8790", "7891535", null, "Distribuidora de Bebidas");
		ClienteJuridico cj3 = new ClienteJuridico("Robert", "Robert", "1524-8790", "120", null, "uma pessoa juridica ai");
		ccj.save(cj);
		ccj.save(cj2);
		ccj.save(cj3);
	}
	
	@Test
	void findCnpjByPessoaJuridica() {
		ClienteJuridico clientes = ccj.findByCnpj("7891535");
		System.out.println("CPNJ = " + clientes.toString());
		
	}
	
	@Test
	void findNomeFantasiaByPessoaJuridica() {
		ClienteJuridico clientes = ccj.findByNomeFantasia("WHR Veiculos");
		System.out.println("NOME FANTASIA = " + clientes.toString());
	}
	
	@Test
	void deleteCnpjByPessoaJuridica() {
		List<ClienteJuridico> clientes1 = ccj.findAll();
		for(ClienteJuridico j: clientes1) {
			System.out.println("EXISTE = " + j.toString());
		}
		ccj.deleteByCnpj("120");
	}
}
