package br.edu.ufape.poo.unitario;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Endereco;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.exceptions.VendaSemLucroException;

@SpringBootTest
public class TestOrdemVendaPessoaJuridica {

	@Autowired
	private CadastroOrdemPessoaJuridica coj;

	@Autowired
	private CadastroModelo cm;

	@Autowired
	private CadastroVeiculoNovo cvn;

	@Autowired
	private CadastroFuncionario cf;

	@Autowired
	private CadastroClienteJuridico cj;

	@SuppressWarnings("deprecation")
	@Test
	void cadastroOrdemPessoaJuridica() throws DataForaRangeException, ValorForaRangeException, ValorNuloExpection,
			VendaSemLucroException, ChassiExistenteException, ClienteJuridicoExistenteException, NomeUnicoException,
			FuncionarioExistenteException, DataNulaException {

		Modelo mo = new Modelo("Hyundai ", "HB20", "1.6", "Azul Escuro", 2010, 78, 5, 110, "Manual", "Gasolina");
		cm.save(mo);
		Funcionario f = new Funcionario("13543278312", "Robert Freire de Melo", new Date(2000 - 1900, 0, 3),
				"(81) 94002-4338", new Endereco("55380000", "Rua Genuíno Cândido de Souza", "Arcoverde", "PE", 61),
				4000, "Gerente");
		cf.save(f);
		ClienteJuridico cf = new ClienteJuridico("WHR Veiculos carros usados e novos Ltda", "WHR Veiculos",
				"(11) 27965-9032", "15373024000163", new Endereco("85819190", "Rua Engenharia", "Cascavel", "PR", 864),
				"Loja de Veiculos");
		cj.save(cf);

		VeiculoNovo vn2 = new VeiculoNovo(1555, 22222, false, "8AHS3cyA33fds6170", "Sim", mo);
		cvn.save(vn2);

		OrdemVendaPessoaJuridica oj = new OrdemVendaPessoaJuridica(15000, vn2, true, new Date(), "Débito", false, false,
				f, cf);
		coj.save(oj);

	}

}
