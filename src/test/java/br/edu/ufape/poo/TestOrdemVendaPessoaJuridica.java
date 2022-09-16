package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestOrdemVendaPessoaJuridica {

	@Autowired
	private CadastroOrdemPessoaJuridica coj;

	@Test
	void cadastroOrdemPessoaJuridica() throws DateForaRangeException, ValorForaRangeException, ValorVazioExpection { //
		OrdemVendaPessoaJuridica oj = new OrdemVendaPessoaJuridica(15000, null, true, null, "Debito", false, false,
				null, null);
		OrdemVendaPessoaJuridica oj2 = new OrdemVendaPessoaJuridica(12000, null, true, null, "Credito", true, false,
				null, null);
		coj.save(oj);
		coj.save(oj2);
	}

	@Test
	void findCodigoVendaByOrdemJuridica() {

		OrdemVendaPessoaJuridica pessoas = coj.findById(2);
		System.out.println("CODIGO VENDA = " + pessoas.toString());

	}

	@Test
	void findPagoByOrdemJuridica() {

		List<OrdemVendaPessoaJuridica> pessoas = coj.findByPago(true);
		for (OrdemVendaPessoaJuridica v : pessoas) {
			System.out.println("PAGO = " + v.toString());
		}
	}

	@Test
	void deleteCodVendaByOrdemJuridica() {

		List<OrdemVendaPessoaJuridica> ordens = coj.findAll();
		for (OrdemVendaPessoaJuridica v : ordens) {
			System.out.println("EXISTE = " + v.toString());
		}
		coj.deleteById(1);

	}

}
