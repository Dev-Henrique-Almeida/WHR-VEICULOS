package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.exceptions.CnpjForaRangeException;

public interface IClienteJuridico {
	
	public boolean checarCnpj(String cnpj) throws CnpjForaRangeException;

}
