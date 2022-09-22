package br.edu.ufape.poo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFichaVisitaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestFichaFisica {

	@Autowired
	private CadastroFichaVisitaFisica cfv;

	@Autowired
	private CadastroClienteFisico ccf;

	@Test
	@SuppressWarnings("deprecation")
	void saveFichaFisica() throws ClienteFisicoExistenteException, DataForaRangeException, ValorNuloExpection,
			ValorForaRangeException, DataNulaException {

		ClienteFisico cf = new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(2000 - 1900, 0, 1),
				"(45) 92906-6513", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
		ccf.save(cf);

		FichaVisitaFisica fv = new FichaVisitaFisica(cf, new Date());
		cfv.save(fv);

	}
}
