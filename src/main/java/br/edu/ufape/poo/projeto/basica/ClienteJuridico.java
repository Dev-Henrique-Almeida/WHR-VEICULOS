package br.edu.ufape.poo.projeto.basica;

public class ClienteJuridico {
	private long id;
	private String nomeEmpresarial;
	private String nomeFantasia;
	private String contato;
	private String cnpj;
	private Endereco endereco;
	private String descricao;
	
	public ClienteJuridico(String nomeEmpresarial, String nomeFantasia, String contato, String cnpj, Endereco endereco,
			String descricao, long id) {
		super();
		this.nomeEmpresarial = nomeEmpresarial;
		this.nomeFantasia = nomeFantasia;
		this.contato = contato;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.descricao = descricao;
		this.id = id;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getCnpj () {
		return cnpj;
	}
	
	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}
	
}
