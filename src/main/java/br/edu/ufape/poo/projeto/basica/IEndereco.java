package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.exceptions.CepForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;

public interface IEndereco {
	
	public boolean checarCep(String cep) throws CepForaRangeException;

	public boolean checarNumero(int numero) throws ValorNegativoException;

}
