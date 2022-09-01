package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public class OrdemVendaPessoaFisica extends OrdemVenda {

	private ClienteFisico cliente;
	public OrdemVendaPessoaFisica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String formaPagamento,
			boolean pago, boolean vendaConcluida, String codVenda, Funcionario vendedor, long id, ClienteFisico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, codVenda, vendedor, id);
		this.cliente = cliente;
	}

}
