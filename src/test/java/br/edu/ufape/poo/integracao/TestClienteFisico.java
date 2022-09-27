package br.edu.ufape.poo.integracao;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestClienteFisico {

	@Autowired
	private CadastroClienteFisico ccf;

	@SuppressWarnings("deprecation")
	@Test
	void clienteExistente() throws DataNulaException, ValorNuloExpection {
		try {
			ClienteFisico cf = new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(2000 - 1900, 0, 1),
					"(45) 92906-6513", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
			ccf.save(cf);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteFisico cf1 = new ClienteFisico("26194239964", "Roberto De Azevedo", new Date(2000 - 1900, 0, 1),
					"(45) 92906-4321", new Endereco("85819190", "Rua Pombos", "Caruaru", "PE", 864));
			ccf.save(cf1);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	@Test
	void dataNula() throws DataNulaException, ValorNuloExpection, ClienteFisicoExistenteException {
		try {
			
			ClienteFisico cf = new ClienteFisico("26194239965", "Danilo Nelson Nunes", new Date(2000 - 1900, 0, 1),
					"(45) 92906-6513", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
			ccf.save(cf);
		} catch (DataNulaException | ValorNuloExpection e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ClienteFisico cf = new ClienteFisico("26194239934", "Ronaldo Almeida", null,
					"(45) 92906-4321", new Endereco("85819190", "Rua Pombos", "Cascavel", "PE", 864));
			ccf.save(cf);
		} catch (DataNulaException | ValorNuloExpection e) {
			System.out.println(e.getMessage());
		}


	}
}
