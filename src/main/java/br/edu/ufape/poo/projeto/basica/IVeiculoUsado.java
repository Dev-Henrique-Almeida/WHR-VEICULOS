package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.exceptions.PlacaForaRangeException;

public interface IVeiculoUsado {

	public boolean checarPlaca(String placa) throws PlacaForaRangeException;
}
