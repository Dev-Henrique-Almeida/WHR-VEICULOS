package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
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
	
	@BeforeEach
	/* 
	void setUp() throws Exception{
		ClienteFisico cf = new ClienteFisico("123454", "Will", null, null, new Endereco(null, null, "Garanhuns", null, 0));
		ClienteFisico cf2 = new ClienteFisico("12931", "Henrique", null, null, new Endereco(null, null, "Cachoeirinha", null, 0));
		ClienteFisico cf3 = new ClienteFisico("123", "Robert", null, null, new Endereco(null, null, "Arcoverde", null, 0));
		ccf.save(cf);
		ccf.save(cf2);
		ccf.save(cf3);
	}
	*/
	
	@Test
	void saveClienteFisico() {
		ClienteFisico cf = new ClienteFisico("123454", "Will", null, null, new Endereco(null, null, "Garanhuns", null, 0));
		ClienteFisico cf2 = new ClienteFisico("12931", "Henrique", null, null, new Endereco(null, null, "Cachoeirinha", null, 0));
		ClienteFisico cf3 = new ClienteFisico("123", "Robert", null, null, new Endereco(null, null, "Arcoverde", null, 0));
		ccf.save(cf);
		ccf.save(cf2);
		ccf.save(cf3);
	}
	
	@Test
	void findCpfByClienteFisico() {
		List<ClienteFisico> clientes = ccf.findByCpf("123454");
		for(ClienteFisico v: clientes) {
			System.out.println("CPF = " + v.toString());
		}
	}
	
	@Test
	void findNomeByClienteFisico() {
		List<ClienteFisico> clientes = ccf.findByNome("Henrique");
		for(ClienteFisico v: clientes) {
			System.out.println("NOME = " + v.toString());
		}
	}
	
	/*
	@Test
	void deleteCpfByClienteFisico() {
		
		List<ClienteFisico> clientes = ccf.findByNome("Henrique");
		for(ClienteFisico v: clientes) {
			System.out.println("NOME = " + v.toString());
		}
		ccf.deleteByCpf("123");

	}
	*/
}
