package br.edu.ufape.poo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestFuncionario {

	@Autowired
	private CadastroFuncionario cf;

	// @BeforeEach
	// void setUp() throws Exception {
//
	// }

	@Test
	void saveFuncionario() throws DateForaRangeException, ValorForaRangeException, ValorVazioExpection {

		try {
			Funcionario f1 = new Funcionario("12345678901", "William Batista Couto dos Santos", null, "4002-8922",
					new Endereco("55380-000", "Rua", "Cachoeirinha", "PE", 23), 4000, "Gerente");
			cf.save(f1);
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Funcionario f3 = new Funcionario("10987654321", "Henrique De Almeida Silva", null, "4002-8922",
					new Endereco("55380-000", "Rua", "Cachoeirinha", "PE", 65), 4000, "Gerente");
			cf.save(f3);
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Funcionario f = new Funcionario("13344678701", "Robert Freire de Melo", null, "4002-8922",
					new Endereco("55380-000", "Rua", "Arcoverde", "PE", 61), 4000, "Gerente");
			cf.save(f);
		} catch (FuncionarioExistenteException e) {
			System.out.println(e.getMessage());
		}

	}
	/*
	 * @Test void findNomeByFuncionario() { Funcionario funcionarios =
	 * cf.findByNome("William"); System.out.println("NOME = " +
	 * funcionarios.toString());
	 * 
	 * }
	 * 
	 * @Test void findCargoByFuncionario() { Funcionario funcionarios =
	 * cf.findByCargo("Vendedor"); System.out.println("CARGO = " +
	 * funcionarios.toString());
	 * 
	 * }
	 * 
	 * @Test void deleteCpfByFuncionario() {
	 * 
	 * List<Funcionario> funcionarios = cf.findAll(); for (Funcionario f :
	 * funcionarios) { System.out.println("EXISTE = " + f.toString()); }
	 * cf.deleteByCpf("123");
	 * 
	 * }
	 */
}
