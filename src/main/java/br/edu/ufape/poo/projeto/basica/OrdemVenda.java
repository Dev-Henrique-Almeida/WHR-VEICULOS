package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public abstract class OrdemVenda {
	private float valor;
	private Veiculo veiculo;
	private boolean novo;
	private Date dataOperacao;
	private String formaPagamento;
	private boolean pago;
	private boolean vendaConcluida;
	private String codVenda;
	private Funcionario vendedor;
	private long id;
	
	public OrdemVenda(float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String formaPagamento,
			boolean pago, boolean vendaConcluida, String codVenda, Funcionario vendedor, long id) {
		super();
		this.valor = valor;
		this.veiculo = veiculo;
		this.novo = novo;
		this.dataOperacao = dataOperacao;
		this.formaPagamento = formaPagamento;
		this.pago = pago;
		this.vendaConcluida = vendaConcluida;
		this.codVenda = codVenda;
		this.vendedor = vendedor;
		this.id = id;
	}
	

}
	


