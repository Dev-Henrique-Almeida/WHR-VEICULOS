package br.edu.ufape.poo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
class TestVeiculoNovo {

	@Autowired
	private CadastroVeiculoNovo cvn;
	/*
	 * @BeforeEach
	 * 
	 * void setUp() throws Exception{ VeiculoNovo vu = new VeiculoNovo(10000, 20000,
	 * true, new Modelo("Fiat", "Uno", "Motor d'agua", 10000, "Branco", 2012, 10, 4,
	 * 120, true, "Gasolina" ), true); VeiculoNovo vu2 = new VeiculoNovo(150000,
	 * 250000, false, new Modelo("Chevrolet", "Camaro", "V6", 0, "Amarelo", 2022,
	 * 100, 2, 300, true, "Alcool" ), true); VeiculoNovo vu3 = new
	 * VeiculoNovo(300000, 400000, false, new Modelo("BMW", "I8", "V8", 0, "Preto",
	 * 2022, 150, 4, 330, true, "Diesel" ), false); cvn.save(vu); cvn.save(vu2);
	 * cvn.save(vu3); }
	 */

	@Test
	void saveVeiculoNovo() throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {

		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));

		cvn.save(vn2);
		cvn.save(vn3);
		
	}

	@Test
	void findValorByVeiculoNovo() {
/*
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));

		cvn.save(vn2);
		cvn.save(vn3);
*/
		List<VeiculoNovo> veiculos = cvn.findByValorVenda(20000);
		for (VeiculoNovo v : veiculos) {
			System.out.println("VALOR VENDA = " + v.toString());
		}

	}

	@Test
	void findVendidoByVeiculoNovo() {

		/*
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));

		cvn.save(vn2);
		cvn.save(vn3);
*/
		List<VeiculoNovo> veiculos = cvn.findByVendido(false);
		for (VeiculoNovo v : veiculos) {
			System.out.println("VENDIDO = " + v.toString());
		}

	}

	@Test
	void findGarantiaByVeiculoNovo() {

		/*
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));

		cvn.save(vn2);
		cvn.save(vn3);
*/
		List<VeiculoNovo> veiculos = cvn.findByGarantiaFabrica(false);
		for (VeiculoNovo v : veiculos) {
			System.out.println("GARANTIA = " + v.toString());
		}

	}

	/*
	 * @Test void deleteVeiculoByVeiculoNovo() { VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AH S3cyA3 3F 5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm 780Vtl BL sE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));
		cvn.save(vn2);
		cvn.save(vn3); {
	 * System.out.println("EXISTE = " + f.toString()); } cvn.delete(vu3);
	 * 
	 * }
	 * 
	 */
}
