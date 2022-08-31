package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public class OrdemVendaPessoaJuridica extends OrdemVenda {
	private ClienteJuridico cliente;
	public OrdemVendaPessoaJuridica(float valor, Veiculo veiculo, boolean novo, Date dataOperacao,
			String formaPagamento, boolean pago, boolean vendaConcluida, String codVenda, Funcionario vendedor,
			long id, ClienteJuridico cliente) {
		super(valor, veiculo, novo, dataOperacao, formaPagamento, pago, vendaConcluida, codVenda, vendedor, id);
		this.cliente = cliente;
	}

}
