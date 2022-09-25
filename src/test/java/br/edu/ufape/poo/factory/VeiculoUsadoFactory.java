package br.edu.ufape.poo.factory;

import java.util.Locale;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;

public class VeiculoUsadoFactory {

	public static VeiculoUsado generate(String cambio) {
		Faker faker = new Faker(new Locale("pt-BR"));
		return new VeiculoUsado(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000),
				faker.bool().bool(), faker.number().numberBetween(0, 100000), faker.random().hex(14),
				ModeloFactory.generate(cambio), "Não", "Não", faker.random().hex(7)

		);

	}
}