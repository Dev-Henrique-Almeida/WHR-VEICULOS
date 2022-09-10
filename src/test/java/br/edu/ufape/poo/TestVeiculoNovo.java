package br.edu.ufape.poo;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;

@SpringBootTest
class TestVeiculoNovo {
	
	@Autowired
	private CadastroVeiculoNovo cvn;
		
	 @BeforeEach
	 
	void setUp() throws Exception{
		VeiculoNovo vu = new VeiculoNovo(10000, 20000, true, new Modelo("Fiat", "Uno", "Motor d'agua", 10000, "Branco", 2012, 10, 4, 120, true, "Gasolina" ), true);
		VeiculoNovo vu2 = new VeiculoNovo(150000, 250000, false, new Modelo("Chevrolet", "Camaro", "V6", 0, "Amarelo", 2022, 100, 2, 300, true, "Alcool" ), true);
		VeiculoNovo vu3 = new VeiculoNovo(300000, 400000, false, new Modelo("BMW", "I8", "V8", 0, "Preto", 2022, 150, 4, 330, true, "Diesel" ), false);
		cvn.save(vu);
		cvn.save(vu2);
		cvn.save(vu3);
	}

	 
	@Test
	void saveVeiculoNovo() {
		
		
		VeiculoNovo vu = new VeiculoNovo(10000, 20000, true, new Modelo("Fiat", "Uno", "Motor d'agua", 10000, "Branco", 2012, 10, 4, 120, true, "Gasolina" ), true);
		VeiculoNovo vu2 = new VeiculoNovo(150000, 250000, false, new Modelo("Chevrolet", "Camaro", "V6", 0, "Amarelo", 2022, 100, 2, 300, true, "Alcool" ), true);
		VeiculoNovo vu3 = new VeiculoNovo(300000, 400000, false, new Modelo("BMW", "I8", "V8", 0, "Preto", 2022, 150, 4, 330, true, "Diesel" ), false);
		
		cvn.save(vu);
		cvn.save(vu2);
		cvn.save(vu3);
	
		
		VeiculoNovo veiculo = cvn.save(vu);
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println(veiculo.toString());
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		
		
	}
	
	@Test
	void findValorByVeiculoNovo() {
		
		/*
		VeiculoNovo vu = new VeiculoNovo(101, 500, false, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoNovo vu2 = new VeiculoNovo(3243, 342, true, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoNovo vu3 = new VeiculoNovo(1234201, 32, false, new Modelo("Irinel", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
	*/
		List<VeiculoNovo> veiculos = cvn.findByValorVenda(20000);
		for(VeiculoNovo v: veiculos) {
			System.out.println("VALOR VENDA = " + v.toString());
		}
	
	}
	
	@Test
	void findVendidoByVeiculoNovo() {
		
		
		//VeiculoNovo vu = new VeiculoNovo(101, 500, false, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		//VeiculoNovo vu2 = new VeiculoNovo(3243, 342, true, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		//VeiculoNovo vu3 = new VeiculoNovo(1234201, 32, false, new Modelo("Irinel", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		List<VeiculoNovo> veiculos = cvn.findByVendido(false);
		for(VeiculoNovo v: veiculos) {
			System.out.println("VENDIDO = " + v.toString());
		}
	
	
	}
	@Test
	void findGarantiaByVeiculoNovo() {
		
		/*
		VeiculoNovo vu = new VeiculoNovo(101, 500, false, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoNovo vu2 = new VeiculoNovo(3243, 342, true, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoNovo vu3 = new VeiculoNovo(1234201, 32, false, new Modelo("Irinel", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
	*/
		List<VeiculoNovo> veiculos = cvn.findByGarantiaFabrica(false);
		for(VeiculoNovo v: veiculos) {
			System.out.println("GARANTIA = " + v.toString());
		}
	
	}
	
	
}




