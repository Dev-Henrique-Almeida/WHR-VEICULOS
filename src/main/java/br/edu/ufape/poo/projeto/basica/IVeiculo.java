package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;

public interface IVeiculo {
	public boolean compraNegativa(float valorCompra) throws ValorNegativoException;

	public boolean vendaNegativa(float valorVenda) throws ValorNegativoException;

	public boolean checarKm(float km) throws ValorNegativoException;

	public boolean checarChassi(String chassi) throws ChassiForaRangeException;

}
