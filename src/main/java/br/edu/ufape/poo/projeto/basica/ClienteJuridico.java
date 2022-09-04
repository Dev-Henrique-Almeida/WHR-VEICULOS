package br.edu.ufape.poo.projeto.basica;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class ClienteJuridico {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nomeEmpresarial;
	private String nomeFantasia;
	private String contato;
	private String cnpj;
	
	@OneToOne(cascade = CascadeType.ALL)
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
