package br.edu.ufape.poo.factory;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;

public class VeiculoNovoFactory {

	public static VeiculoNovo generate(String cambio) {
		Faker faker = new Faker(new Locale("pt-BR"));
		return new VeiculoNovo(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000),
				false, faker.random().hex(14), "Sim", ModeloFactory.generate(cambio)

		);

	}
}