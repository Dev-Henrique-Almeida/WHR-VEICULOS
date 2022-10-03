package br.edu.ufape.poo.unitario;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestFuncionario {

	@Autowired
	private CadastroFuncionario cf;

	@SuppressWarnings("deprecation")
	@Test
	void saveFuncionario() throws DataForaRangeException, ValorForaRangeException, ValorNuloExpection,
			DataNulaException, FuncionarioExistenteException {

		Funcionario f = new Funcionario("13344678721", "Robert Freire de Melo", new Date(2000 - 1900, 0, 1),
				"(81) 94002-4338", new Endereco("55380000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61),
				4000, "Gerente");
		cf.save(f);

	}

}
