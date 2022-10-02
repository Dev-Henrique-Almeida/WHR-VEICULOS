package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.exceptions.CpfForaRangeException;

public interface IClienteFisico {
	
	public boolean checarCpf(String cpf) throws CpfForaRangeException;

}
