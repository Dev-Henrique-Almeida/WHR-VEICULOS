package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;

@SpringBootTest
public class TestOrdemVendaPessoaJuridica {
	
	@Autowired
	private CadastroOrdemPessoaJuridica coj;
	
	@Test
	void cadastroOrdemPessoaJuridica() { //
		OrdemVendaPessoaJuridica oj = new OrdemVendaPessoaJuridica(15000, null, true, null, "Debito", false, false, "1", null, null);
		OrdemVendaPessoaJuridica oj2 = new OrdemVendaPessoaJuridica(12000, null, true, null, "Credito", true, false, "2", null, null);
		coj.save(oj);
		coj.save(oj2);
	}
	
	@Test
	void findCodigoVendaByOrdemJuridica() {
		
		List<OrdemVendaPessoaJuridica> pessoas = coj.findByCodVenda("1");
		for(OrdemVendaPessoaJuridica v: pessoas) {
			System.out.println("CODIGO VENDA = " + v.toString());
		}
	}
	
	@Test
	void findPagoByOrdemJuridica() {
		
		List<OrdemVendaPessoaJuridica> pessoas = coj.findByPago(true);
		for(OrdemVendaPessoaJuridica v: pessoas) {
			System.out.println("PAGO = " + v.toString());
		}
	}
}
