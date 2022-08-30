package br.edu.ufape.poo.projeto.basica;

public class ClienteFisico extends Cliente {
	private PessoaFisica pf;

	public ClienteFisico(String[] idCompras, PessoaFisica pf) {
		super(idCompras);
		this.pf = pf;
	}
	
	
}
