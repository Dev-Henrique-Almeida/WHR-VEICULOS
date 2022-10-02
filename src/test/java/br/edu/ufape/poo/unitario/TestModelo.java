package br.edu.ufape.poo.unitario;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
public class TestModelo {

	@Autowired
	private CadastroModelo cm;

	@Test
	void saveVeiculos()
			throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException, NomeUnicoException {
		Modelo mo1 = new Modelo("BMW", "M3", "V8", "Branco", 2022, 600, 2, 500, "Automático", "Gasolina");
		cm.save(mo1);

	}

	@Test
	void findNomeModeloByModelo() {

		List<Modelo> modelos = cm.findByNomeModelo("M3");
		for (Modelo v : modelos) {
			System.out.println("MODELO = " + v.toString());
		}
	}

	@Test
	void findAnobyModelo() {
		List<Modelo> modelos = cm.findByAnoFabricado(2022);
		for (Modelo v : modelos) {
			System.out.println("ANO = " + v.toString());
		}
	}

}
