package br.edu.ufape.poo.unitario;

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
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.exceptions.VeiculoVendidoException;
import br.edu.ufape.poo.projeto.exceptions.VendaSemLucroException;

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

	@Autowired
	private CadastroModelo cm;

	@Autowired
	private CadastroFuncionario cf;

	/////////////////////// SAVE CLIENTE FISICO ///////////////////////////

	@SuppressWarnings("deprecation")
	@Test
	void saveClienteFisico() throws DataForaRangeException, ValorNuloExpection, ValorForaRangeException,
			ClienteFisicoExistenteException, DataNulaException {
		ClienteFisico cf = new ClienteFisico("26194239964", "Danilo Nelson Nunes", new Date(2000 - 1900, 0, 1),
				"(45) 92906-6513", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864));
		ccf.save(cf);

		ClienteFisico cf2 = new ClienteFisico("03463463202", "Vitória Fabiana Yasmin", new Date(2003 - 1900, 0, 1),
				"(61) 92548-9942", new Endereco("72603106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611));
		ccf.save(cf2);

		ClienteFisico cf3 = new ClienteFisico("20332130212", "Gabrielly Carla Moraes", new Date(2005 - 1900, 0, 1),
				"(62) 92892-9164", new Endereco("74630310", "Rua L 14", "Goiânia", "GO", 350));
		ccf.save(cf3);
	}

	////////////////////// SAVE CLIENTE JURIDICO ///////////////////////////

	@Test
	void savePessoaJuridico() throws ValorNuloExpection, ValorForaRangeException {
		try {
			ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos",
					"(11) 27965-9032", "15373024000163",
					new Endereco("85819190", "Vila Engenheiro", "Cascavel", "PR", 864), "Loja de Veiculos");
			ccj.save(cj);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj2 = new ClienteJuridico("AMBEV Bebidas Ltda", "AMBEV Bebidas", "(11) 98677-1808",
					"25378975000189", new Endereco("72603106", "Quadra Quadra 113 Conjunto 6", "Brasília", "DF", 611),
					"Distribuidora de Bebidas");
			ccj.save(cj2);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			ClienteJuridico cj3 = new ClienteJuridico("Coca-Cola Bebidas Ltda", "Coca-Cola", "(11) 99278-7308",
					"90605347000150", new Endereco("74630310", "Rua Fenando Costa", "Goiânia", "GO", 350),
					"Distribuidora de Bebidas");
			ccj.save(cj3);
		} catch (ClienteJuridicoExistenteException e) {
			System.out.println(e.getMessage());
		}
	}

/////////////////// SAVE ORDEM FISICA E FUNCIONARIO ///////////////////////////

	@SuppressWarnings("deprecation")
	@Test
	void cadastroOrdemPessoaFisica()
			throws ValorNuloExpection, ValorForaRangeException, DataForaRangeException, FuncionarioExistenteException,
			ClienteJuridicoExistenteException, ChassiExistenteException, ClienteFisicoExistenteException,
			VendaSemLucroException, ValorNegativoException, DataNulaException, NomeUnicoException, VeiculoVendidoException {

		Modelo mo = new Modelo("Hyundai ", "HB20", "1.6", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina");
		cm.save(mo);
		Funcionario f = new Funcionario("13344678701", "Robert Freire de Melo", new Date(2000 - 1900, 0, 1),
				"(81) 94002-4338", new Endereco("55380000", "Cândido de Souza", "Arcoverde", "PE", 61),
				4000, "Gerente");
		cf.save(f);

		ClienteFisico cff = new ClienteFisico("20332130230", "Roberta Carla Moraes", new Date(2000 - 1900, 0, 1),
				"(62) 92892-9164", new Endereco("74630310", "Rua Almeida", "Goiânia", "GO", 350));
		ccf.save(cff);

		VeiculoNovo vn2 = new VeiculoNovo(12020, 1500200, true, "8AHS3cyA33f5N6", "Sim", mo);
		cvn.save(vn2);

		OrdemVendaPessoaFisica of = new OrdemVendaPessoaFisica(15000, vn2, true, new Date(), "Debito", false, false, f,
				cff);
		cof.save(of);

		//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

		Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
		cm.save(mo1);

		Funcionario f1 = new Funcionario("13344678731", "Henrique de Almeida Silva", new Date(), "(81) 94002-4338",
				new Endereco("55380000", "Avenida Brasil", "Cachoeirinha", "PE", 61), 4000, "Gerente");
		cf.save(f1);

		ClienteJuridico cj = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos",
				"(11) 27965-9032", "15373024000163", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864),
				"Loja de Veiculos");
		ccj.save(cj);

		VeiculoNovo vn3 = new VeiculoNovo(12020, 1500200, false, "8AHS3cy31235N6", "Sim", mo1);
		cvn.save(vn3);

		OrdemVendaPessoaJuridica of2 = new OrdemVendaPessoaJuridica(15000, vn3, true, new Date(), "Crédito", false,
				false, f1, cj);
		coj.save(of2);

	}

	/////////////////// SAVE VEICULO NOVO E MODELO /////////////////////

	@Test
	void saveVeiculos() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, NomeUnicoException {
		Modelo mo = new Modelo("Hyundai ", "HB20", "1.6", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina");
		Modelo mo1 = new Modelo("Ford", "Mustang", "V6", "Vermelho", 2015, 400, 2, 300, "Automático", "Gasolina");
		Modelo mo2 = new Modelo("Chevrolet", "Celta", "V6", "Vermelho", 2015, 400, 2, 300, "Manual", "Gasolina");
		cm.save(mo);
		cm.save(mo1);
		cm.save(mo2);
		try {
			VeiculoNovo vn2 = new VeiculoNovo(12020, 1500200, true, "8AHS3cyA33f5N6", "Sim", mo);
			VeiculoNovo vn3 = new VeiculoNovo(302030, 40200200, false, "7ba7r0VtlBLsE9", "Sim", mo1);
			VeiculoNovo vn4 = new VeiculoNovo(12020, 1500200, false, "7ba7r0Vt2BLsE9", "Sim", mo2);

			cvn.save(vn2);
			cvn.save(vn3);
			cvn.save(vn4);
		} catch (ChassiExistenteException e) {
			e.getMessage();
		}
	}

	///////////////////// SAVE VEICULO USADO /////////////////

	@Test
	void saveVeiculoUsado() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, NomeUnicoException, PlacaExistenteException {

		Modelo mo = new Modelo("Hyundai ", "HB20", "1.6", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina");
		Modelo mo1 = new Modelo("Ford", "Mustang", "V6", "Vermelho", 2015, 400, 2, 300, "Automático", "Gasolina");
		cm.save(mo);
		cm.save(mo1);

		VeiculoUsado vu = new VeiculoUsado(13000, 20000, false, 10000, "7bm780VtlBLsE1", mo, "Sim", "Não", "MTT7197");
		cvu.save(vu);

		VeiculoUsado vu2 = new VeiculoUsado(15000, 25000, true, 12000, "39jF3araexAVR1", mo1, "Não", "Sim", "HPJ6477");
		cvu.save(vu2);
	}

}
