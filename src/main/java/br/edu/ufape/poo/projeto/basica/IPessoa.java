package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.TelefoneForaRangeException;

public interface IPessoa {
	
	public boolean checarIdade(Date dataNascimento) throws DataForaRangeException;

	public boolean checarTelefone(String telefone) throws TelefoneForaRangeException;
}
