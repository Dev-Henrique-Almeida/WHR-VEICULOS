package br.edu.ufape.poo.unitario;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
class TestVeiculoNovo {

	@Autowired
	private CadastroVeiculoNovo cvn;

	@Autowired
	private CadastroModelo cmo;

	@Test
	void saveVeiculoNovo() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, NomeUnicoException {

		Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
		cmo.save(mo);
		VeiculoNovo vn2 = new VeiculoNovo(120000, 150000, false, "8AHS3cyA33F554322", "Sim", mo);
		cvn.save(vn2);

		Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
		VeiculoNovo vn3 = new VeiculoNovo(300000, 400000, false, "8AHS3cyA33F554320", "Sim", mo1);
		cmo.save(mo1);
		cvn.save(vn3);

	}

}
