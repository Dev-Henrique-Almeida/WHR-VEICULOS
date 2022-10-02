package br.edu.ufape.poo.projeto.basica;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import br.edu.ufape.poo.projeto.exceptions.CnpjForaRangeException;

@Entity
public class ClienteJuridico implements IClienteJuridico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nomeEmpresarial;
	private String nomeFantasia;
	private String contato;

	@Column(unique = true)
	private String cnpj;

	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
	private Endereco endereco;
	private String descricao;

	public ClienteJuridico() {

	}

	public ClienteJuridico(String nomeEmpresarial, String nomeFantasia, String contato, String cnpj, Endereco endereco,
			String descricao) {
		this.nomeEmpresarial = nomeEmpresarial;
		this.nomeFantasia = nomeFantasia;
		this.contato = contato;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.descricao = descricao;
	}

	public long getId() {
		return id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public String getNomeEmpresarial() {
		return nomeEmpresarial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public String getContato() {
		return contato;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	@Override
	public boolean checarCnpj(String cnpj) throws CnpjForaRangeException {
		if (cnpj.length() > 14 || cnpj.length() < 14) {
			throw new CnpjForaRangeException("");
		} else {
			return true;
		}

	}

	@Override
	public String toString() {
		return "ClienteJuridico [nomeEmpresarial=" + nomeEmpresarial + ", nomeFantasia=" + nomeFantasia + ", contato="
				+ contato + ", cnpj=" + cnpj + ", endereco=" + endereco + ", descricao=" + descricao + "]";
	}

}
