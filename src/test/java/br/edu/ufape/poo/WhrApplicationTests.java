package br.edu.ufape.poo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculo;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculo;

@SpringBootTest
class WhrApplicationTests {

	@Autowired
	private CadastroClienteFisico ccf;
	
	@Autowired
	private CadastroVeiculo cvn;
	
	@Autowired
	private RepositorioVeiculo rv;
	
	@Test
	void contextLoads() {
	}
	@Test
	void cadastroPessoaFisica() {
		ClienteFisico cf = new ClienteFisico("123454", "Will", new Date(), null, 0, new Endereco(null, null, "Garanhuns", null, 0));
		ccf.save(cf);
	}/*
	@Test
	void merda() {
		
		VeiculoNovo vn = new VeiculoNovo(50000, 5, true, new Modelo("Celta", 0, "Confusão de jovens desocupados", null, 0, null, 0,0,0,0, true,null), 0, true);
		VeiculoNovo vn2 = new VeiculoNovo(10000, 5, true, new Modelo("Gol", 0, "Confusão de jovens desocupados", null, 0, null, 0,0,0,0, true,null), 0, true);
		VeiculoNovo vn3 = new VeiculoNovo(10000, 5, true, new Modelo("Celta", 0, "Confusão de jovens desocupados", null, 0, null, 0,0,0,0, true,null), 0, true);
		cvn.save(vn);
		cvn.save(vn2);
		cvn.save(vn3);
	}/*
/*
	@Test
	void findVeiculosByModelo() {
		List<Veiculo> veiculos = cvn.findByModelo(new Modelo("Celta", 13, "Confusão de jovens desocupados", null, 0, null, 0,0,0,0, true,null));
		for(Veiculo v: veiculos) {
			System.out.println(v.toString());
		}
	}*/
}
