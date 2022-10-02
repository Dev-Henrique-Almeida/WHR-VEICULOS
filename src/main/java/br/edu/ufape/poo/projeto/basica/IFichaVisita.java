package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;

public interface IFichaVisita {
	
	public boolean checarData(Date data) throws DataForaRangeException;

}
