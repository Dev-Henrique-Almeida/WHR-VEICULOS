package br.edu.ufape.poo.projeto.basica;

public class ClienteFisico extends Cliente {
	private PessoaFisica pf;

	public ClienteFisico(String[] idCompras, long id, PessoaFisica pf) {
		super(idCompras, id);
		this.pf = pf;
	}


	
	
}
