package br.edu.ufape.poo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;

@SpringBootTest
public class TestClienteJuridico {

	@Autowired
	private CadastroClienteJuridico ccj;

	@Test
	void savePessoaJuridico() {
		try {
			ClienteJuridico cj = new ClienteJuridico("WHR", "WHR Veiculos", "8002-8922", "15749680", null,
					"Loja de Veiculos");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj2 = new ClienteJuridico("AMBEV", "AMBEV Bebidas", "1524-8790", "7891535", null,
					"Distribuidora de Bebidas");
			ccj.save(cj2);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ClienteJuridico cj3 = new ClienteJuridico("Robert", "Corno", "telefone", "1111", null,
					"juridico igual");
			ccj.save(cj3);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj4 = new ClienteJuridico("Teste Igual", "Igual", "telefone", "5858", null,
					"juridico igual");
			ccj.save(cj4);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
	/*
	@Test
	void findCnpjByPessoaJuridica() {
		ClienteJuridico clientes = ccj.findByCnpj("1111");
		System.out.println("CNPJ = " + clientes.toString());

	}

	@Test
	void findNomeFantasiaByPessoaJuridica() {
		ClienteJuridico clientes = ccj.findByNomeFantasia("WHR Veiculos");
		System.out.println("NOME FANTASIA = " + clientes.toString());
	}

	
	@Test
	void deleteCnpjByPessoaJuridica() {
		List<ClienteJuridico> clientes = ccj.findAll();
		for (ClienteJuridico j : clientes) {
			System.out.println("EXISTE = " + j.toString());
		}
		ccj.deleteByCnpj("120");
	}
	*/
}
