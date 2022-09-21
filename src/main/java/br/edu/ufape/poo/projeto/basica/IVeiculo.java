package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorCompraNegativoException;

public interface IVeiculo {
	public boolean compraNegativo(float valorCompra) throws ValorCompraNegativoException;
}
