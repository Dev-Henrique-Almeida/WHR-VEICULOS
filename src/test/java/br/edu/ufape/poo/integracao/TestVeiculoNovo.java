package br.edu.ufape.poo.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
class TestVeiculoNovo {

	@Autowired
	private CadastroVeiculoNovo cvn;

	@Autowired
	private CadastroModelo cmo;

	
	@Test
	void chassiExistente() throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException{

		try {
			Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
			cmo.save(mo);
			VeiculoNovo vn = new VeiculoNovo(120000, 150000, true, "8AHS3cyA33F5N6170", "Sim", mo);
			cvn.save(vn);
		} catch (ChassiExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
			VeiculoNovo vn2 = new VeiculoNovo(300000, 400000, true, "8AHS3cyA33F5N6170", "Sim", mo1);
			cmo.save(mo1);
			cvn.save(vn2);
		} catch (ChassiExistenteException e) {
			System.out.println(e.getMessage());
		}

	}

}
