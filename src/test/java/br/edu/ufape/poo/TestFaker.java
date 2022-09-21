package br.edu.ufape.poo;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestFaker  {
	
	@Autowired
	private CadastroClienteFisico ccf;
	
	@Autowired
	private CadastroClienteJuridico ccj;
	
	Faker faker = new Faker(new Locale("pt-BR"));
	
	@Test
	void saveClienteFisico() throws ClienteFisicoExistenteException, DateForaRangeException, ValorVazioExpection, ValorForaRangeException {
		

		ClienteFisico cf = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf);
		
		ClienteFisico cf2 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf2);
		
		ClienteFisico cf3 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf3);
		
		ClienteFisico cf4 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf4);

		ClienteFisico cf5 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf5);	
	}
	
	@Test
	void saveClienteJuridico() throws ClienteJuridicoExistenteException, ValorVazioExpection, ValorForaRangeException {
		
		ClienteJuridico cj = new ClienteJuridico(faker.company().name(), faker.company().buzzword(), faker.phoneNumber().cellPhone(), faker.number().digits(14),
				new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.company().industry());
		ccj.save(cj);
	}
	
	
	
	
	

}
