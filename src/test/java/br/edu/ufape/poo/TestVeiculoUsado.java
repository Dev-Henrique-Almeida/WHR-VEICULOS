package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;

@SpringBootTest
class TestVeiculoUsado {

	@Autowired
	private CadastroVeiculoUsado cvu;

	@BeforeEach

	void setUp() throws Exception {
		VeiculoUsado vu = new VeiculoUsado(10000, 20000, true,
				new Modelo("Fiat", "Uno", "Motor d'agua", 10000, "Branco", 2012, 10, 4, 120, "automatico", "Gasolina"), "100km",
				"sim", "sim");
		VeiculoUsado vu2 = new VeiculoUsado(150000, 250000, false,
				new Modelo("Chevrolet", "Camaro", "V6", 0, "Amarelo", 2022, 100, 2, 300, "automatico", "Alcool"), "100km", "sim", "não");
		// VeiculoUsado vu3 = new VeiculoUsado(1234201, 32, false, new Modelo("Gol",
		// "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel"
		// ),"100km", true, true);
		cvu.save(vu);
		cvu.save(vu2);
		// cvu.save(vu3);
	}

	@Test
	void saveVeiculoUsado() {

		VeiculoUsado vu = new VeiculoUsado(101, 500, false,
				new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, "automatico", "Disel"), "100km",
				"sim", "sim");
		VeiculoUsado vu2 = new VeiculoUsado(3243, 342, true,
				new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, "automatico", "Disel"), "100km",
				"não", "sim");
		VeiculoUsado vu3 = new VeiculoUsado(123, 32, false,
				new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, "automatico", "Disel"), "100km",
				"sim", "sim");

		cvu.save(vu);
		cvu.save(vu2);
		cvu.save(vu3);

		VeiculoUsado veiculo = cvu.save(vu);
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println(veiculo.toString());
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");

	}

	@Test
	void findValorByVeiculoUsado() {

		/*
		 * VeiculoUsado vu = new VeiculoUsado(101, 500, false, new Modelo("Gol",
		 * "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel"
		 * ),"100km", true, true); VeiculoUsado vu2 = new VeiculoUsado(3243, 342, true,
		 * new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4,
		 * 10, true, "Disel" ),"100km", true, true); VeiculoUsado vu3 = new
		 * VeiculoUsado(1234201, 32, false, new Modelo("Irinel", "carrinhooo",
		 * "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true,
		 * true);
		 */
		List<VeiculoUsado> veiculos = cvu.findByValorVenda(20000);
		for (VeiculoUsado v : veiculos) {
			System.out.println("VALOR VENDA = " + v.toString());
		}

	}

	@Test
	void findVendidoByVeiculoUsado() {

		// VeiculoUsado vu = new VeiculoUsado(101, 500, false, new Modelo("Gol",
		// "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel"
		// ),"100km", true, true);
		// VeiculoUsado vu2 = new VeiculoUsado(3243, 342, true, new Modelo("Gol",
		// "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel"
		// ),"100km", true, true);
		// VeiculoUsado vu3 = new VeiculoUsado(1234201, 32, false, new Modelo("Irinel",
		// "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel"
		// ),"100km", true, true);
		List<VeiculoUsado> veiculos = cvu.findByVendido(false);
		for (VeiculoUsado v : veiculos) {
			System.out.println("VENDIDO = " + v.toString());
		}

	}

}
