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
			ClienteFisico cf = new ClienteFisico("261.942.399-64", "Danilo Nelson Nunes", new Date(), "(45)92906-6513",
					new Endereco("85819-190", "Rua Engenharia", "Cascavel", "PR", 864));
			ccf.save(cf);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteFisico cf2 = new ClienteFisico("034.634.632-02", "Vitória Fabiana Yasmin", new Date(), "(61)92548-9942",
					new Endereco("72603-106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611));
			ccf.save(cf2);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteFisico cf3 = new ClienteFisico("203.321.302-15", "Gabrielly Carla Moraes", new Date(), "(62)92892-9164",
					new Endereco("74630-310", "Rua L 14", "Goiânia", "GO", 350));
			ccf.save(cf3);
		} catch (ClienteFisicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	
	////////////////////// SAVE CLIENTE JURIDICO  ///////////////////////////


	@Test
	void savePessoaJuridico() throws ValorVazioExpection, ValorForaRangeException {
		try {
			ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos", "(11)27965-9032", "15.373.024/0001-63", new Endereco("85819-190", "Rua Engenharia", "Cascavel", "PR", 864),
					"Loja de Veiculos");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj2 = new ClienteJuridico("AMBEV Bebidas Ltda", "AMBEV Bebidas", "(11)98677-1808", "25.378.975/0001-89", new Endereco("72603-106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611),
					"Distribuidora de Bebidas");
			ccj.save(cj2);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			ClienteJuridico cj3 = new ClienteJuridico("Coca-Cola Bebidas Ltda", "Coca-Cola", "(11)99278-7308", "90.605.347/0001-50", new Endereco("74630-310", "Rua L 14", "Goiânia", "GO", 350),
					"Distribuidora de Bebidas");
			ccj.save(cj3);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}	
	
	
	
	
/////////////////// SAVE ORDEM FISICA E FUNCIONARIO ///////////////////////////
	

	@SuppressWarnings("deprecation")
	@Test
	void cadastroOrdemPessoaFisica() throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException { 
		OrdemVendaPessoaFisica of = new OrdemVendaPessoaFisica(50000, new VeiculoUsado(15000, 50000, true,
			10000, "7pzxA6tmb6mAA6857", new Modelo("Hyundai ", "HB20", "1.6", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"), "Não", "Sim", "KLO3457"), false, new Date(2021, 0, 3), "Débito", true, false, new Funcionario("123.456.789-01", "William Batista Couto dos Santos", new Date(), "(81)94002-4338",
					new Endereco("55380-000", "Rua Coronel Olímpio Barbosa Mello", "Cachoeirinha", "PE", 23), 4000, "Gerente"),
			new ClienteFisico("261.942.399-64", "Danilo Nelson Nunes", new Date(2021, 0, 3), "(45)92906-6513",
					new Endereco("85819-190", "Rua Engenharia", "Cascavel", "PR", 864)));
		cof.save(of);
		
		
		OrdemVendaPessoaFisica of2 = new OrdemVendaPessoaFisica(300000,  new VeiculoNovo(230000, 300000, false, "4ERDXA21xC66H1347", "Sim", new Modelo("Ford", "Mustang", "V6", "Vermelho", 2015, 400, 2, 300, "Automático", "Gasolina")), true, new Date(2021, 0, 3), "Crédito", true, true, new Funcionario("109.876.543-21", "Henrique De Almeida Silva", new Date(2021, 0, 3), "(81)94002-4338",
					new Endereco("55380-000", "Avenida Território do Amapá", "Cachoeirinha", "PE", 65), 4000, "Gerente"),
			new ClienteFisico("203.321.302-15", "Gabrielly Carla Moraes", new Date(2021, 0, 3), "(62)92892-9164",
					new Endereco("74630-310", "Rua L 14", "Goiânia", "GO", 350)));
		cof.save(of2);
		
		
		
		
		
		
		/////////////////////// SAVE ORDEM JURIDICA ///////////////////////
		
		
		
		OrdemVendaPessoaJuridica oj = new OrdemVendaPessoaJuridica(50000, new VeiculoNovo(15000, 50000, false, "4AtAUFDrmKdf84595", "Sim",
			new Modelo("Chevrolet", "Onix", "1.6", "Preto", 2012, 130, 2, 120, "Manual", "Diesel")), true, new Date(2021, 0, 3), "Débito", true, false,
			new Funcionario("133.446.787-01", "Robert Freire de Melo", new Date(2021, 0, 3), "(81)94002-4338",
					new Endereco("55380-000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61), 4000, "Gerente"), new ClienteJuridico("AMBEV Bebidas Ltda", "AMBEV Bebidas", "11986771808", "25378235000189", new Endereco("72603-106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611),
							"Distribuidora de Bebidas"));
		coj.save(oj);
		
		
		
	}
	
	
	
	
	/////////////////// SAVE VEICULO NOVO E MODELO /////////////////////
	

	@Test
	void saveVeiculos() throws ValorVazioExpection, ValorForaRangeException {
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AHS3cyA33F5N6170", "Sim",
				new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel"));
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "7bm780VtlBLsE9853", "Sim",
				new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel"));
		cvn.save(vn2);
		cvn.save(vn3);

	}
	
	
	
	
	///////////////////// SAVE VEICULO USADO /////////////////
	
	@Test
	void saveVeiculoUsado() throws ValorVazioExpection, ValorForaRangeException {
	
			VeiculoUsado vu = new VeiculoUsado(13000, 20000, false, 10000, "7bm780VtlBLsE1253",
			new Modelo("Fiat", "Uno", "1.0", "Preto", 2010, 77, 5, 100, "Manual", "Gasolina"), "Sim", "Não", "MTT7197");
			cvu.save(vu);
	
			VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, 12000, "39jF3araexAVR1406",
			new Modelo("Chevrolet", "Celta", "1.0",  "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina"), "Não", "Sim", "HPJ6477");
			cvu.save(vu2);
	}
	
	

	
}
