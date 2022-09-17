package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestModelo {

	/*
	 * @BeforeEach
	 * 
	 * void setUp() throws Exception{ VeiculoNovo vn = new VeiculoNovo(15000, 20000,
	 * false, new Modelo ("Fiat", "Uno", null, 0, null, 0,0,0,0, true,null), true);
	 * VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, new
	 * Modelo("Chevrolet", "Camaro", "V8", 0, "Amarelo", 2012,0,0,0, true,null),
	 * true); VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, new
	 * Modelo("BMW", "M3", null, 0, null, 0,0,0,0, true,null), true); VeiculoNovo
	 * vn4 = new VeiculoNovo(200000, 250000, true, new Modelo ("Ford", "Mustang",
	 * null, 0, null, 0,0,0,0, true,null), true); cvn.save(vn); cvn.save(vn2);
	 * cvn.save(vn3); cvn.save(vn4); }
	 */

	@Autowired
	private CadastroVeiculoNovo cvn;

	@Autowired
	private CadastroModelo cm;

	@Test
	void saveVeiculos() throws ValorVazioExpection, ValorForaRangeException {
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));
		cvn.save(vn2);
		cvn.save(vn3);
		

	}

	@Test
	void findNomeModeloByModelo() {

		List<Modelo> modelos = cm.findByNomeModelo("Camaro");
		for (Modelo v : modelos) {
			System.out.println("MODELO = " + v.toString());
		}
	}

	@Test
	void findAnobyModelo() {
		List<Modelo> modelos = cm.findByAnoFabricado(2012);
		for (Modelo v : modelos) {
			System.out.println("ANO = " + v.toString());
		}
	}

}
