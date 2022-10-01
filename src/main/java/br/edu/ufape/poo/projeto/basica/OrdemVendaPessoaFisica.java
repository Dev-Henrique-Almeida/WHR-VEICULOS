package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemVendaPessoaFisica extends OrdemVenda {

	@OneToOne(cascade = CascadeType.MERGE)
	private ClienteFisico cliente;

	public OrdemVendaPessoaFisica() {
		super();
	}

	public OrdemVendaPessoaFisica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String formaPagamento,
			boolean pago, boolean vendaConcluida, Funcionario vendedor, ClienteFisico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, vendedor);
		this.cliente = cliente;
	}
	
	public ClienteFisico getCliente() {
		return cliente;
	}

	@Override
	public String toString() {
		return "OrdemVendaPessoaFisica [cliente=" + cliente + ", valor=" + getValor() + ", veiculo=" + getVeiculo()
				+ ", novo=" + getNovo() + ", dataOperacao=" + getDataOperacao() + ", formaPagamento="
				+ getFormaPagamento() + ", pago=" + getPago() + ", vendaConcluida=" + getVendaConcluida()
				+ ", vendedor=" + getVendedor() + ", codVenda=" + getId() + "]";
	}

}
