package br.edu.ufape.poo.unitario;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestClienteFisico {

	@Autowired
	private CadastroClienteFisico ccf;

	@SuppressWarnings("deprecation")
	@Test
	void saveClienteFisico() throws DataForaRangeException, ValorNuloExpection, ValorForaRangeException,
			DataNulaException, ClienteFisicoExistenteException {
		ClienteFisico cf = new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(2000 - 1900, 0, 1),
				"(45) 92906-6513", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
		ccf.save(cf);

	}

	@Test
	void findCpfByClienteFisico() {
		ClienteFisico cliente = ccf.findByCpf("26194239964");
		System.out.println("CPF = " + cliente.toString());
	}

	@Test
	void findNomeByClienteFisico() {
		ClienteFisico clientes = ccf.findByNome("Danilo Nelson Nunes");
		System.out.println("NOME = " + clientes.toString());

	}

	@Test
	void deleteCpfByClienteFisico() {

		List<ClienteFisico> clientes = ccf.findAll();
		for (ClienteFisico v : clientes) {
			System.out.println("EXISTE = " + v.toString());
		}
		// ccf.deleteByCpf("123");

	}

}
