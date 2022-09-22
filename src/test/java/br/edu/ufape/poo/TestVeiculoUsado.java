package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
class TestVeiculoUsado {

	@Autowired
	private CadastroVeiculoUsado cvu;

	/*
	 * @BeforeEach
	 * 
	 * void setUp() throws Exception { VeiculoUsado vu = new VeiculoUsado(13000,
	 * 20000, false, new Modelo("Fiat", "Uno", "1.0", 10000, "Preto", 2010, 77, 5,
	 * 100, "Manual", "Gasolina"), "Sim", "Não"); cvu.save(vu);
	 * 
	 * VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, new
	 * Modelo("Chevrolet", "Celta", "1.0", 12000, "Azul Escuro", 2010, 78, 5, 110,
	 * "Manual", "Gasolina"), "Não", "Sim"); cvu.save(vu2); // VeiculoUsado vu3 =
	 * new VeiculoUsado(1234201, 32, false, new Modelo("Gol", // "carrinhooo",
	 * "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" // ),"100km",
	 * true, true); cvu.save(vu); cvu.save(vu2); // cvu.save(vu3); }
	 */
	@Test
	void saveVeiculoUsado() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, PlacaExistenteException {

		VeiculoUsado vu = new VeiculoUsado(13000, 20000, false, 10000, "7bm 780Vtl BL sE1253",
				new Modelo("Fiat", "Uno", "1.0", "Preto", 2010, 77, 5, 100, "Manual", "Gasolina"), "Sim", "Não",
				"MTT-7197");
		cvu.save(vu);

		VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, 12000, "39j F3arae xA VR1406",
				new Modelo("Chevrolet", "Celta", "1.0", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"), "Não",
				"Sim", "HPJ-6477");
		cvu.save(vu2);

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
		 * VeiculoUsado vu = new VeiculoUsado(13000, 20000, false, 10000,
		 * "7bm 780Vtl BL sE1253", "Sim", "Não", "MTT-7197", new Modelo("Fiat", "Uno",
		 * "1.0", "Preto", 2010, 77, 5, 100, "Manual", "Gasolina")); cvu.save(vu);
		 * 
		 * VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, 12000,
		 * "39j F3arae xA VR1406", "Não", "Sim", "HPJ-6477", new Modelo("Chevrolet",
		 * "Celta", "1.0", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"));
		 * cvu.save(vu2);
		 */
		List<VeiculoUsado> veiculos = cvu.findByValorVenda(20000);
		for (VeiculoUsado v : veiculos) {
			System.out.println("VALOR VENDA = " + v.toString());
		}

	}

	@Test
	void findVendidoByVeiculoUsado() {
		/*
		 * VeiculoUsado vu = new VeiculoUsado(13000, 20000, false, 10000,
		 * "7bm 780Vtl BL sE1253", "Sim", "Não", "MTT-7197", new Modelo("Fiat", "Uno",
		 * "1.0", "Preto", 2010, 77, 5, 100, "Manual", "Gasolina")); cvu.save(vu);
		 * 
		 * VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, 12000,
		 * "39j F3arae xA VR1406", "Não", "Sim", "HPJ-6477", new Modelo("Chevrolet",
		 * "Celta", "1.0", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"));
		 * cvu.save(vu2);
		 * 
		 * List<VeiculoUsado> veiculos = cvu.findByVendido(false); for (VeiculoUsado v :
		 * veiculos) { System.out.println("VENDIDO = " + v.toString()); }
		 */
	}

}
