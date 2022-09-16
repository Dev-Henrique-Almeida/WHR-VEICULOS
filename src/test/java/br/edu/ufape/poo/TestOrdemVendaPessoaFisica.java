package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestOrdemVendaPessoaFisica {

	@Autowired
	private CadastroOrdemPessoaFisica cof;

	@Test
	void cadastroOrdemPessoaFisica() throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException { //
		OrdemVendaPessoaFisica of = new OrdemVendaPessoaFisica(15000, null, true, null, "Debito", false, false, null,
				null);
		OrdemVendaPessoaFisica of2 = new OrdemVendaPessoaFisica(12000, null, true, null, "Credito", true, false, null,
				null);
		cof.save(of);
		cof.save(of2);
	}

	@Test
	void findPagoByOrdemFisica() {

		List<OrdemVendaPessoaFisica> pessoas = cof.findByPago(true);
		for (OrdemVendaPessoaFisica v : pessoas) {
			System.out.println("PAGO = " + v.toString());
		}
	}

	@Test
	void findCodigoVendaByOrdemFisica() {

		OrdemVendaPessoaFisica pessoas = cof.findById(2);
		System.out.println("CODIGO VENDA = " + pessoas.toString());
	}

	@Test
	void deleteCodVendaByOrdemFisica() {

		List<OrdemVendaPessoaFisica> ordens = cof.findAll();
		for (OrdemVendaPessoaFisica v : ordens) {
			System.out.println("EXISTE = " + v.toString());
		}
		cof.deleteById(1);

	}
}
