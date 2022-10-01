package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemVendaPessoaJuridica extends OrdemVenda {

	@OneToOne(cascade = CascadeType.MERGE)
	private ClienteJuridico cliente;

	public OrdemVendaPessoaJuridica() {
		super();
	}

	public OrdemVendaPessoaJuridica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao,
			String formaPagamento, boolean pago, boolean vendaConcluida, Funcionario vendedor,
			ClienteJuridico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, vendedor);
		this.cliente = cliente;
	}

	public ClienteJuridico getCliente() {
		return cliente;
	}
	
	@Override
	public String toString() {
		return "OrdemVendaPessoaJuridica [cliente=" + cliente + ", valor=" + getValor() + ", veiculo=" + getVeiculo()
				+ ", novo=" + getNovo() + ", dataOperacao=" + getDataOperacao() + ", formaPagamento="
				+ getFormaPagamento() + ", pago=" + getPago() + ", vendaConcluida=" + getVendaConcluida()
				+ ", vendedor=" + getVendedor() + ", codVenda=" + getId() + "]";
	}

}
