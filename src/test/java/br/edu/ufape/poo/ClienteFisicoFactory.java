package br.edu.ufape.poo;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;

public class ClienteFisicoFactory {

	public static ClienteFisico generate() {
		Faker faker = new Faker(new Locale("pt-BR"));
		return new ClienteFisico(
				faker.number().digits(11), faker.name().fullName(),
				faker.date().birthday(18, 65), faker.phoneNumber().cellPhone(),
				new Endereco(faker.number().digits(8), faker.address().streetName(), faker.address().city(),
						faker.address().state(), faker.number().randomDigit())
			);
	}

}
