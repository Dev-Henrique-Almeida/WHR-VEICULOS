package br.edu.ufape.poo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import antlr.collections.List;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@SpringBootTest
class TesteCadastrOVeiculoUsado {

	@Autowired
	private CadastroVeiculoUsado cvu;
	
	@Autowired
	private RepositorioVeiculoUsado rvu;
	
	@Test
	void criarCarros() {
		
		
		VeiculoUsado vu = new VeiculoUsado(101, 500, false, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoUsado vu2 = new VeiculoUsado(3243, 342, true, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		VeiculoUsado vu3 = new VeiculoUsado(1234201, 32, false, new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" ),"100km", true, true);
		
		cvu.save(vu);
		cvu.save(vu2);
		cvu.save(vu3);
	
		/*
		VeiculoUsado veiculo = cvu.findByModelo(new Modelo("Gol", "carrinhooo", "motoe foda", 100, "rosinha", 2022, 10, 4, 10, true, "Disel" );
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		System.out.println(veiculo.toString());
		System.out.println("---------------------------------------");
		System.out.println("---------------------------------------");
		*/
		
	}
	
}



