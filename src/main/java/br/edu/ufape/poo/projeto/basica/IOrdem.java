package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;

public interface IOrdem {
	public boolean checarValor(float valor) throws ValorNegativoException;

	public boolean checarData(Date data) throws DataForaRangeException;
}
