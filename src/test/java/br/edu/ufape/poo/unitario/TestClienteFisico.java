package br.edu.ufape.poo.unitario;

import java.util.Date;

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

}
