package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;

@SpringBootTest
public class TestFuncionario {

	@Autowired
	private CadastroFuncionario cf;

	@BeforeEach
	void setUp() throws Exception {

	}

	@Test
	void saveFuncionario() {
		Funcionario f = new Funcionario("123-456", "Robert", null, "4002-8922",
				new Endereco("55380-000", "Rua", "ArcoVerde", "PE", 69), 1000, "Vendedor");
		Funcionario f1 = new Funcionario("654-321", "William", null, "4002-8922",
				new Endereco("55380-000", "Rua", "Cachoeirinha", "PE", 69), 4000, "Gerente");
		Funcionario f3 = new Funcionario("123", "Henrique", null, "4002",
				new Endereco("55380-000", "Rua", "Caruaru", "PE", 69), 1000, "Gerente");
		cf.save(f);
		cf.save(f1);
		cf.save(f3);
	}

	@Test
	void findNomeByFuncionario() {
		Funcionario funcionarios = cf.findByNome("William");
		System.out.println("NOME = " + funcionarios.toString());

	}

	@Test
	void findCargoByFuncionario() {
		Funcionario funcionarios = cf.findByCargo("Vendedor");
		System.out.println("CARGO = " + funcionarios.toString());

	}

	@Test
	void deleteCpfByFuncionario() {

		List<Funcionario> funcionarios = cf.findAll();
		for (Funcionario f : funcionarios) {
			System.out.println("EXISTE = " + f.toString());
		}
		cf.deleteByCpf("123");

	}
}
