package br.edu.ufape.poo.factory;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;

public class ClienteJuridicoFactory {

	public static ClienteJuridico generate() {
		Faker faker = new Faker(new Locale("pt-BR"));
		return new ClienteJuridico(faker.company().name(), faker.company().buzzword(), faker.phoneNumber().cellPhone(),
				faker.number().digits(14), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()),
				faker.company().industry());
	}

}
