package br.edu.ufape.poo.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestClienteJuridico {

	@Autowired
	private CadastroClienteJuridico ccj;

	@Test
	void clienteExistente() throws ValorNuloExpection, ClienteJuridicoExistenteException  {
		try {
			ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos",
					"(11) 27965-9032", "15373024000163", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864),
					"Loja de Veiculos");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj = new ClienteJuridico("Coca Cola Ltda", "Coca Cola",
					"(11) 27965-4321", "15373024000163", new Endereco("85819190", "Rua Pombos", "Garanhuns", "PE", 864),
					"Distribuidora de bebidas");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

}
