package br.edu.ufape.poo;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class WhrApplicationTests {
	
<<<<<<< HEAD
=======
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
>>>>>>> 05adb9d885c5c4a4453611cbc0a3ca63f1d15da9
}
