package br.edu.ufape.poo.projeto.basica;

public  class ClienteJuridico {
	private String nomeEmpresarial;
	private String nomeFantasia;
	private String contato;
	private String cnpj;
	private Endereco endereco;
	private String descricao;
	
	public ClienteJuridico(String nomeEmpresarial, String nomeFantasia, String contato, String cnpj, Endereco endereco,
			String descricao) {
		super();
		this.nomeEmpresarial = nomeEmpresarial;
		this.nomeFantasia = nomeFantasia;
		this.contato = contato;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.descricao = descricao;
	}
	
	
}
