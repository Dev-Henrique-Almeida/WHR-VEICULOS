package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;

@SpringBootTest
public class TestOrdemVendaPessoaFisica {
	
	@Autowired
	private CadastroOrdemPessoaFisica cof;
	
	@Test
	void cadastroOrdemPessoaFisica() { //
		OrdemVendaPessoaFisica of = new OrdemVendaPessoaFisica(15000, null, true, null, "Debito", false, false, "1", null, null);
		OrdemVendaPessoaFisica of2 = new OrdemVendaPessoaFisica(12000, null, true, null, "Credito", true, false, "2", null, null);
		cof.save(of);
		cof.save(of2);
	}
	
	@Test
	void findCodigoVendaByOrdemFisica() {
		
		OrdemVendaPessoaFisica pessoas = cof.findByCodVenda("1");
		System.out.println("CODIGO VENDA = " + pessoas.toString());
	}
	
	@Test
	void findPagoByOrdemFisica() {
		
		List<OrdemVendaPessoaFisica> pessoas = cof.findByPago(true);
		for(OrdemVendaPessoaFisica v: pessoas) {
			System.out.println("PAGO = " + v.toString());
		}
	}
	
	@Test
	void deleteCodVendaByOrdemFisica() {
		
		List<OrdemVendaPessoaFisica> ordens = cof.findAll();
		for(OrdemVendaPessoaFisica v: ordens) {
			System.out.println("EXISTE = " + v.toString());
		}
		cof.deleteByCodVenda("1");

	}
}
