package br.edu.ufape.poo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;

@SpringBootTest
public class TestClienteFisico {

	@Autowired
	private CadastroClienteFisico ccf;
	
	@Test
	void cadastroPessoaFisica() {
		ClienteFisico cf = new ClienteFisico("123454", "Will", null, null, new Endereco(null, null, "Garanhuns", null, 0));
		ccf.save(cf);
	}
}
