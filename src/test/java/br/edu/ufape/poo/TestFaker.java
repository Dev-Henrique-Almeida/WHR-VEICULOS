package br.edu.ufape.poo;

import java.util.Locale;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.github.javafaker.Faker;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorCompraNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

@SpringBootTest
public class TestFaker  {
	
	@Autowired
	private CadastroClienteFisico ccf;
	
	@Autowired
	private CadastroClienteJuridico ccj;
	
	@Autowired
	private CadastroFuncionario cff;
	
	@Autowired
	private CadastroModelo cmo;
	
	@Autowired
	private CadastroVeiculoNovo cvn;
	
	@Autowired
	private CadastroVeiculoUsado cvu;
	
	Faker faker = new Faker(new Locale("pt-BR"));

	@Test
	void saveClienteFisico() throws ClienteFisicoExistenteException, DateForaRangeException, ValorVazioExpection, ValorForaRangeException {
		

		ClienteFisico cf = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf);
		
		ClienteFisico cf2 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf2);
		
		ClienteFisico cf3 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf3);
		
		ClienteFisico cf4 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf4);

		ClienteFisico cf5 = new ClienteFisico(faker.number().digits(11), faker.name().fullName(), faker.date().birthday(18, 65)
				,faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
						faker.address().city(), faker.address().state(), faker.number().randomDigit()));
		ccf.save(cf5);	
	}
	
	@Test
	void saveClienteJuridico() throws ClienteJuridicoExistenteException, ValorVazioExpection, ValorForaRangeException {
		
		ClienteJuridico cj = new ClienteJuridico(faker.company().name(), faker.company().buzzword(), faker.phoneNumber().cellPhone(), faker.number().digits(14),
				new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.company().industry());
		ccj.save(cj);
		
		ClienteJuridico cj2 = new ClienteJuridico(faker.company().name(), faker.company().buzzword(), faker.phoneNumber().cellPhone(), faker.number().digits(14),
				new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.company().industry());
		ccj.save(cj2);
		
		ClienteJuridico cj3 = new ClienteJuridico(faker.company().name(), faker.company().buzzword(), faker.phoneNumber().cellPhone(), faker.number().digits(14),
				new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.company().industry());
		ccj.save(cj3);
	}
	
	@Test
	void saveFuncionario() throws FuncionarioExistenteException, DateForaRangeException, ValorForaRangeException, ValorVazioExpection {
		
		////////////////////////// GERENTES ////////////////////////
		
		Funcionario f = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(3000, 5000), "Gerente");
		cff.save(f);
		Funcionario f2 = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(3000, 5000), "Gerente");
		cff.save(f2);
		Funcionario f3 = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(3000, 5000), "Gerente");
		cff.save(f3);
		
		
		/////////////////////// VENDEDORES ///////////////////////
		Funcionario f4 = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(1000, 2000), "Vendedor");
		cff.save(f4);
		Funcionario f5 = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(1000, 2000), "Vendedor");
		cff.save(f5);
		Funcionario f6 = new Funcionario(faker.number().digits(11),faker.name().fullName(), faker.date().birthday(18, 65),  faker.phoneNumber().cellPhone(), new Endereco(faker.number().digits(8), faker.address().streetName(),
				faker.address().city(), faker.address().state(), faker.number().randomDigit()), faker.number().numberBetween(1000, 2000), "Vendedor");
		cff.save(f6);
	}
	
	@Test
	void saveModelo() throws ValorVazioExpection, ValorForaRangeException {
		
		
		
		////////////////////////////// AUTOMATICOS ///////////////////////////////
		
		Modelo mo = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Automático", "Gasolina"  );
		cmo.save(mo);

		Modelo mo1 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Automático", "Flex(Gasolina/Álcool)"  );
		cmo.save(mo1);
		
		
		/////////////////////////////// MANUAIS ////////////////////////////////

		Modelo mo2 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Manual", "Diesel"  );
		cmo.save(mo2);

		Modelo mo3 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Manual", "Gasolina"  );
		cmo.save(mo3);

		
		/////////////////////////////// SEMI-AUTOMATICO ///////////////////////////
		
		Modelo mo4 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo4);

		Modelo mo5 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Flex(Gasolina/Álcool)"  );
		cmo.save(mo5);

	}
	
	@Test
	void saveVeiculoNovo() throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException, ValorCompraNegativoException {
		
		Modelo mo = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo);
		VeiculoNovo vn = new VeiculoNovo(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.random().hex(14), "Sim",mo);
		cvn.save(vn);
		
		
		Modelo mo1 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo1);
		VeiculoNovo vn2 = new VeiculoNovo(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.random().hex(14), "Não", mo1);
		cvn.save(vn2);
		
		
		Modelo mo2 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo2);
		VeiculoNovo vn3 = new VeiculoNovo(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.random().hex(14), "Não", mo1);
		cvn.save(vn3);
		
		Modelo mo3 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo3);
		VeiculoNovo vn4 = new VeiculoNovo(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.random().hex(14), "Não", mo1);
		cvn.save(vn4);
		
	}
	
	@Test
	void saveVeiculoUsado() throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException, ValorCompraNegativoException {
		
		Modelo mo2 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo2);
		VeiculoUsado vn3 = new VeiculoUsado(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.number().numberBetween(0, 100000), faker.random().hex(14), mo2, "Não", "Não", faker.random().hex(7));
		cvu.save(vn3);
		
		Modelo mo3 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo3);
		VeiculoUsado vn4 = new VeiculoUsado(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.number().numberBetween(0, 100000), faker.random().hex(14), mo2, "Sim", "Sim", faker.random().hex(7));
		cvu.save(vn4);
		
		Modelo mo4 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo4);
		VeiculoUsado vn5 = new VeiculoUsado(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.number().numberBetween(0, 100000), faker.random().hex(14), mo2, "Não", "Sim", faker.random().hex(7));
		cvu.save(vn5);
		
		Modelo mo5 = new Modelo(faker.ancient().god(), faker.space().moon(), faker.aviation().aircraft(), faker.color().name(), faker.number().numberBetween(1900, 2023), faker.number().numberBetween(100, 1000), faker.number().numberBetween(1, 25), faker.number().numberBetween(100, 1000), "Semi-Automático", "Gasolina"  );
		cmo.save(mo5);
		VeiculoUsado vn6 = new VeiculoUsado(faker.number().numberBetween(10000, 50000), faker.number().numberBetween(50001, 100000), faker.bool().bool(), faker.number().numberBetween(0, 100000), faker.random().hex(14), mo2, "Sim", "Não", faker.random().hex(7));
		cvu.save(vn6);
		
		
	}
	
	

}
