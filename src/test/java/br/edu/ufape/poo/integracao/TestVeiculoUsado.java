package br.edu.ufape.poo.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;

@SpringBootTest
class TestVeiculoUsado {

	@Autowired
	private CadastroVeiculoUsado cvu;

	@Autowired
	private CadastroModelo cmo;

	@Test
	void placaExistente() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, PlacaExistenteException, NomeUnicoException {

		try {
			Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
			cmo.save(mo);
			VeiculoUsado vn = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5F6321", mo, "Sim", "Não",
					"ABC1234");
			cvu.save(vn);
		} catch (PlacaExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
			VeiculoUsado vn2 = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5N6321", mo1, "Sim", "Não",
					"ABC1234");
			cmo.save(mo1);
			cvu.save(vn2);
		} catch (PlacaExistenteException e) {
			System.out.println(e.getMessage());
		}

	}
	
	@Test
	void chassiExistente() throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException, PlacaExistenteException{

		try {
			Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
			cmo.save(mo);
			VeiculoUsado vn = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5N6170", mo, "Sim", "Não",
					"ABC1242");
			cvu.save(vn);
		} catch (ChassiExistenteException e) {
			System.out.println(e.getMessage());
		}

		try {
			Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
			VeiculoUsado vn2 = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5N6170", mo1, "Sim", "Não",
					"ABC4321");
			cmo.save(mo1);
			cvu.save(vn2);
		} catch (ChassiExistenteException e) {
			System.out.println(e.getMessage());
		}

	}

}
