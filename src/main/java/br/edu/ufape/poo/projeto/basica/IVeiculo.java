package br.edu.ufape.poo.projeto.basica;

import br.edu.ufape.poo.projeto.exceptions.ChassiForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.VendaSemLucroException;

public interface IVeiculo {
	
	public boolean checarValorCompra(float valorCompra, float valorVenda) throws VendaSemLucroException; 
	
	public boolean compraNegativa(float valorCompra) throws ValorNegativoException;

	public boolean vendaNegativa(float valorVenda) throws ValorNegativoException;

	public boolean checarKm(float km) throws ValorNegativoException;

	public boolean checarChassi(String chassi) throws ChassiForaRangeException;

}
