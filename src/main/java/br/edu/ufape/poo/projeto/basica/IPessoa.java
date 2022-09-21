package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;

public interface IPessoa {
	public boolean checarIdade(Date dataNascimento) throws DateForaRangeException;
}
