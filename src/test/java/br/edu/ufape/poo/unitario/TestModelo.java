package br.edu.ufape.poo.unitario;

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
		Modelo mo1 = new Modelo("BMW", "X2", "V8", "Laranja", 2020, 600, 2, 500, "Automático", "Gasolina");
		cm.save(mo1);
		Modelo mo2 = new Modelo("Porshe", "Taycan", "V6", "Cinza", 2021, 600, 2, 500, "Automático", "Gasolina");
		cm.save(mo2);

	}

}
