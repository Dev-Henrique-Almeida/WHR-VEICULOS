package br.edu.ufape.poo.factory;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.Modelo;

public class ModeloFactory {

	public static Modelo generate(String cambio) {
		Faker faker = new Faker(new Locale("pt-BR"));
		if (cambio == "Automático") {
			return new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(),
					faker.color().name(), faker.number().numberBetween(1900, 2023),
					faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25),
					faker.number().numberBetween(100, 1000), "Automático", "Flex(Gasolina/Álcool)");
		} else if (cambio == "Manual") {
			return new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(),
					faker.color().name(), faker.number().numberBetween(1900, 2023),
					faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25),
					faker.number().numberBetween(100, 1000), "Manual", "Gasolina");
		} else {
			return new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(),
					faker.color().name(), faker.number().numberBetween(1900, 2023),
					faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25),
					faker.number().numberBetween(100, 1000), "Semi-Automático", "Flex(Gasolina/Álcool)");
		}
	}

}
