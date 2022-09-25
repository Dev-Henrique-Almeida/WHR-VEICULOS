package br.edu.ufape.poo.factory;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;

public class FuncionarioFactory {

	public static Funcionario generate(String cargo) {
		Faker faker = new Faker(new Locale("pt-BR"));
		if (cargo == "Gerente") {
			return new Funcionario(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65),
					faker.phoneNumber().cellPhone(),
					new Endereco(faker.number().digits(8), faker.address().streetName(), faker.address().city(),
							faker.address().state(), faker.number().randomDigit()),
					faker.number().numberBetween(3000, 5000), "Gerente");
		} else {
			return new Funcionario(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65),
					faker.phoneNumber().cellPhone(),
					new Endereco(faker.number().digits(8), faker.address().streetName(), faker.address().city(),
							faker.address().state(), faker.number().randomDigit()),
					faker.number().numberBetween(3000, 5000), "Vendedor");
		}

	}

}
