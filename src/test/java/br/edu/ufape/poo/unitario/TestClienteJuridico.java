package br.edu.ufape.poo.unitario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestClienteJuridico {

	@Autowired
	private CadastroClienteJuridico ccj;

	@Test
	void savePessoaJuridico() throws ValorNuloExpection, ValorForaRangeException, ClienteJuridicoExistenteException {
		ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos",
				"(11) 27965-9032", "15373024000163", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864),
				"Loja de Veiculos");
		ccj.save(cj);

	}

	@Test
	void findCnpjByPessoaJuridica() {
		ClienteJuridico clientes = ccj.findByCnpj("15373024000163");
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
		// ccj.deleteByCnpj("120");
	}

}
