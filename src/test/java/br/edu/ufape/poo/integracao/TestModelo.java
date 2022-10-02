package br.edu.ufape.poo.integracao;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;

@SpringBootTest
class TestModelo {


	@Autowired
	private CadastroModelo cmo;

	
	@Test
	void nomeUnico() throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException{

			//////////////////////////////////////////////TESTE DA EXCEÇÃO DE NOMEUNICO //////////////////////////////////////////////
				///////// CONSISTE EM NÃO PODER CADASTRAR UM MODELO COM O NOME DO MODELO IGUAL O NOME DA MARCA ///////// 
		
		try {
			Modelo mo = new Modelo("Chevrolet", "Camaro", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
			cmo.save(mo);
			
		} catch (NomeUnicoException e) {
			System.out.println(e.getMessage());
		}

		try {
			Modelo mo1 = new Modelo("Chevrolet", "Chevrolet", "V8", "Amarelo", 2012, 406, 2, 400, "Automático", "Diesel");
			cmo.save(mo1);

		} catch (NomeUnicoException e) {
			System.out.println(e.getMessage());
		}

	}

}
