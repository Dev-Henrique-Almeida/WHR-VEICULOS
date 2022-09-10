package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemVendaPessoaJuridica extends OrdemVenda {
	
	@OneToOne(cascade = CascadeType.ALL)
	private ClienteJuridico cliente;
	
	public OrdemVendaPessoaJuridica() {
		super();
	}

	public OrdemVendaPessoaJuridica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao,
			String formaPagamento, boolean pago, boolean vendaConcluida, String codVenda, Funcionario vendedor,ClienteJuridico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, codVenda, vendedor);
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "OrdemVendaPessoaJuridica [cliente=" + cliente + ", valor=" + getValor() + ", veiculo="
				+ getVeiculo() + ", novo=" + getNovo() + ", dataOperacao=" + getDataOperacao()
				+ ", formaPagamento=" + getFormaPagamento() + ", pago=" + getPago() + ", vendaConcluida="
				+ getVendaConcluida() + ", codVenda=" + getCodVenda() + ", vendedor=" + getVendedor() + "]";
	}
	
	
	
}
