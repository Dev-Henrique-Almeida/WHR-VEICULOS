package br.edu.ufape.poo.unitario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
class TestVeiculoUsado {

	@Autowired
	private CadastroVeiculoUsado cvu;

	@Autowired
	private CadastroModelo cmo;

	@Test
	void saveVeiculoUsado() throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException,
			ValorNegativoException, PlacaExistenteException, NomeUnicoException {

		Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
		cmo.save(mo);
		VeiculoUsado vn2 = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5N6170", mo, "Sim", "Não",
				"ABC1234");
		cvu.save(vn2);

		Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Diesel");
		VeiculoUsado vn3 = new VeiculoUsado(120000, 150000, false, 100, "8AHS3cyA33F5N6321", mo1, "Sim", "Não",
				"ABC4321");
		cmo.save(mo1);
		cvu.save(vn3);

	}

	@Test
	void findValorByVeiculoUsado() {

		List<VeiculoUsado> veiculos = cvu.findByValorVenda(20000);
		for (VeiculoUsado v : veiculos) {
			System.out.println("VALOR VENDA = " + v.toString());
		}

	}

	@Test
	void findVendidoByVeiculoUsado() {

		List<VeiculoUsado> veiculos = cvu.findAllByVendido();
		for (VeiculoUsado v : veiculos) {
			System.out.println("VENDIDO = " + v.toString());
		}

	}

}
