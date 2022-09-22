package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.cadastro.exceptions.CpfForaRangeException;

public interface IClienteFisico {
	public boolean checarCpf(String cpf) throws CpfForaRangeException;

}
