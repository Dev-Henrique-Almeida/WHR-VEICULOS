package br.edu.ufape.poo.integracao;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestFuncionario {

	@Autowired
	private CadastroFuncionario cf;

	@SuppressWarnings("deprecation")
	@Test
	void funcionarioExistente() throws ValorNuloExpection, DataNulaException, DataForaRangeException {
		try {
			Funcionario f = new Funcionario("13344678721", "Robert Freire de Melo", new Date(2000 - 1900, 0, 1),
					"(81) 94002-4338", new Endereco("55380000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61),
					4000, "Gerente");
			cf.save(f);
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Funcionario f1 = new Funcionario("13344678721", "Henrique de Almeida Silva", new Date(2000 - 1900, 0, 1),
					"(81) 94002-4321", new Endereco("55380000", "Rua Pombos", "Caruaru", "PE", 61),
					4000, "Gerente");
			cf.save(f1);
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	@SuppressWarnings("deprecation")
	@Test
	void dataNula() throws DataNulaException, ValorNuloExpection, ClienteFisicoExistenteException, FuncionarioExistenteException, DataForaRangeException {
		try {
			
			Funcionario f = new Funcionario("13344678725", "Henrique Almeida", new Date(2000 - 1900, 0, 1),
					"(81) 94002-4338", new Endereco("55380000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61),
					4000, "Gerente");
			cf.save(f);
		} catch (DataNulaException | ValorNuloExpection e) {
			System.out.println(e.getMessage());
		}
		
		try {
			Funcionario f = new Funcionario("13344678723", "William Batista", null,
					"(81) 94002-4321", new Endereco("55380000", "Rua Pombos", "Caruaru", "PE", 61),
					4000, "Gerente");
			cf.save(f);
		} catch (DataNulaException | ValorNuloExpection e) {
			System.out.println(e.getMessage());
		}


	}

}
