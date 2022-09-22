package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.edu.ufape.poo.projeto.cadastro.exceptions.CepForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;

@Entity
public class Endereco implements IEndereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cep;
	private String rua;
	private String cidade;
	private String estado;
	private int numero;

	public Endereco() {
	}

	public Endereco(String cep, String rua, String cidade, String estado, int numero) {
		super();
		this.cep = cep;
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
		this.numero = numero;
	}

	public long getId() {
		return id;
	}

	public String getCep() {
		return cep;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public int getNumero() {
		return numero;
	}

	@Override
	public boolean checarCep(String cep) throws CepForaRangeException {
		if (cep.length() > 8 || cep.length() < 8) {
			throw new CepForaRangeException("Erro ao cadastrar, CEP inválido!");
		} else {
			return true;
		}

	}

	@Override
	public boolean checarNumero(int numero) throws ValorNegativoException {
		if (numero < 0) {
			throw new ValorNegativoException("Erro ao cadastrar, número inválido!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "Endereco [id=" + id + ", cep=" + cep + ", rua=" + rua + ", cidade=" + cidade + ", estado=" + estado
				+ ", numero=" + numero + "]";
	}

}
