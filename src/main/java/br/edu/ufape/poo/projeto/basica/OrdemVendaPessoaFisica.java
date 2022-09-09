package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class OrdemVendaPessoaFisica extends OrdemVenda {

	@OneToOne(cascade = CascadeType.ALL)
	private ClienteFisico cliente;

	public OrdemVendaPessoaFisica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String formaPagamento,
			boolean pago, boolean vendaConcluida, String codVenda, Funcionario vendedor, long id,
			ClienteFisico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, codVenda, vendedor, id);
		this.cliente = cliente;
	}
	

}
