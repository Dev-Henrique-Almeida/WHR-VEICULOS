package br.edu.ufape.poo;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoNuloException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
class TestApresentacao {

	@Autowired
	private CadastroClienteFisico ccf;
	
	@Autowired
	private CadastroClienteJuridico ccj;
		
	@Autowired
	private CadastroVeiculoNovo cvn;
	
	@Autowired
	private CadastroVeiculoUsado cvu;

	@Autowired
	private CadastroOrdemPessoaFisica cof;
	
	@Autowired
	private CadastroOrdemPessoaJuridica coj;

	
	/////////////////////// SAVE CLIENTE FISICO  ///////////////////////////
	
	@Test		
	void saveClienteFisico() throws ClienteFisicoNuloException, DateForaRangeException, ValorVazioExpection, ValorForaRangeException {
		try {
			ClienteFisico cf = new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(), "4529066513",
					new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
			ccf.save(cf);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteFisico cf2 = new ClienteFisico("03463463202", "Vitória Fabiana Yasmin", new Date(), "6125489942",
					new Endereco("72603106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611));
			ccf.save(cf2);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteFisico cf3 = new ClienteFisico("20332130215", "Gabrielly Carla Moraes", new Date(), "6228929164",
					new Endereco("74630310", "Rua L 14", "Goiânia", "GO", 350));
			ccf.save(cf3);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	////////////////////// SAVE CLIENTE JURIDICO  ///////////////////////////


	@Test
	void savePessoaJuridico() throws ValorVazioExpection, ValorForaRangeException {
		try {
			ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos", "11279659032", "15373024000163", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864),
					"Loja de Veiculos");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj2 = new ClienteJuridico("AMBEV Bebidas Ltda", "AMBEV Bebidas", "11986771808", "25378975000189", new Endereco("72603106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611),
					"Distribuidora de Bebidas");
			ccj.save(cj2);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ClienteJuridico cj3 = new ClienteJuridico("Coca-Cola Bebidas Ltda", "Coca-Cola", "11992787308", "90605347000150", new Endereco("74630310", "Rua L 14", "Goiânia", "GO", 350),
					"Distribuidora de Bebidas");
			ccj.save(cj3);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	
	
	
/////////////////// SAVE ORDEM FISICA E FUNCIONARIO ///////////////////////////
	

	@Test
	void cadastroOrdemPessoaFisica() throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException { 
		OrdemVendaPessoaFisica of = new OrdemVendaPessoaFisica(50000, new VeiculoUsado(15000, 50000, true,
			new Modelo("Hyundai ", "HB20", "1.6", 8000, "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"), "Não", "Sim"), false, new Date(), "Débito", true, false, new Funcionario("12345678901", "William Batista Couto dos Santos", new Date(), "40024338922",
					new Endereco("55380-000", "Rua Coronel Olímpio Barbosa Mello", "Cachoeirinha", "PE", 23), 4000, "Gerente"),
			new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(), "4529066513",
					new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864)));
		cof.save(of);
		
		
		OrdemVendaPessoaFisica of2 = new OrdemVendaPessoaFisica(300000,  new VeiculoNovo(230000, 300000, false,
			new Modelo("Ford", "Mustang", "V6", 0, "Vermelho", 2015, 400, 2, 300, "Automático", "Gasolina"), "Sim"), true, new Date(), "Crédito", true, true, new Funcionario("10987654321", "Henrique De Almeida Silva", new Date(), "40024318922",
					new Endereco("55380-000", "Avenida Território do Amapá", "Cachoeirinha", "PE", 65), 4000, "Gerente"),
			new ClienteFisico("20332130215", "Gabrielly Carla Moraes", new Date(), "6228929164",
					new Endereco("74630310", "Rua L 14", "Goiânia", "GO", 350)));
		cof.save(of2);
		
		
		
		
		
		
		/////////////////////// SAVE ORDEM JURIDICA ///////////////////////
		
		
		
		OrdemVendaPessoaJuridica oj = new OrdemVendaPessoaJuridica(50000, new VeiculoNovo(15000, 50000, false,
			new Modelo("Chevrolet", "Onix", "1.6", 0, "Preto", 2012, 130, 2, 120, "Manual", "Diesel"), "Sim"), true, new Date(), "Débito", true, false,
			new Funcionario("13344678701", "Robert Freire de Melo", new Date(), "40022348922",
					new Endereco("55380-000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61), 4000, "Gerente"), new ClienteJuridico("AMBEV Bebidas Ltda", "AMBEV Bebidas", "11986771808", "25378235000189", new Endereco("72603106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611),
							"Distribuidora de Bebidas"));
		coj.save(oj);
		
		
		
	}
	
	
	
	
	/////////////////// SAVE VEICULO NOVO E MODELO /////////////////////
	

	@Test
	void saveVeiculos() throws ValorVazioExpection, ValorForaRangeException {
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false,
				new Modelo("Chevrolet", "Camaro", "V8", 0, "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"), "Sim");
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false,
				new Modelo("BMW", "M3", "V8", 0, "Branco", 2022, 600, 2, 500, "Automático", "Diesel"), "Sim");
		cvn.save(vn2);
		cvn.save(vn3);

	}
	
	
	
	
	///////////////////// SAVE VEICULO USADO /////////////////
	
	@Test
	void saveVeiculoUsado() throws ValorVazioExpection, ValorForaRangeException {
	
			VeiculoUsado vu = new VeiculoUsado(13000, 20000, false,
			new Modelo("Fiat", "Uno", "1.0", 10000, "Preto", 2010, 77, 5, 100, "Manual", "Gasolina"), "Sim", "Não");
			cvu.save(vu);
	
			VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true,
			new Modelo("Chevrolet", "Celta", "1.0", 12000, "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"), "Não", "Sim");
			cvu.save(vu2);
	}
	
	

	
}
