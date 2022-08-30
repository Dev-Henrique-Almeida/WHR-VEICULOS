package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

public class OrdemVenda {
	private float valor;
	private VeiculoNovo veiculoNovo;
	private VeiculoUsado veiculoUsado;
	private boolean novo;
	private Date dataOperacao;
	private String formaPagamento;
	private boolean pago;
	private boolean clienteJuridico;
	private ClienteFisico clientePF;
	private ClienteJuridico clientePJ;
	private boolean vendaConcluida;
	private String idVenda;
	
	//pessoa fisica, veiculoNovo
	public OrdemVenda(float valor, VeiculoNovo veiculoNovo,boolean novo,
			Date dataOperacao, String formaPagamento, boolean pago, ClienteFisico clientePF,
			boolean vendaConcluida, String idVenda) {
		this.valor = valor;
		this.veiculoNovo = veiculoNovo;
		this.veiculoUsado = null;
		this.novo = novo;
		this.dataOperacao = dataOperacao;
		this.formaPagamento = formaPagamento;
		this.pago = pago;
		this.clienteJuridico = false;
		this.clientePF = clientePF;
		this.clientePJ = null;
	}
	
	//pessoa fisica, veiculoUsado
	public OrdemVenda(float valor, VeiculoUsado veiculoUsado,boolean novo,
			Date dataOperacao, String formaPagamento, boolean pago,
			ClienteFisico clientePF, boolean vendaConcluida, String idVenda) {
		this.valor = valor;
		this.veiculoNovo = null;
		this.veiculoUsado = veiculoUsado;
		this.novo = novo;
		this.dataOperacao = dataOperacao;
		this.formaPagamento = formaPagamento;
		this.pago = pago;
		this.clienteJuridico = false;
		this.clientePF = clientePF;
		this.clientePJ = null;
	}
	
	//pessoa juridica, veiculoUsado
	public OrdemVenda(float valor, VeiculoUsado veiculoUsado,boolean novo,
			Date dataOperacao, String formaPagamento, boolean pago,
			ClienteJuridico clientePJ, boolean vendaConcluida, String idVenda) {
		this.valor = valor;
		this.veiculoNovo = null;
		this.veiculoUsado = veiculoUsado;
		this.novo = novo;
		this.dataOperacao = dataOperacao;
		this.formaPagamento = formaPagamento;
		this.pago = pago;
		this.clienteJuridico = true;
		this.clientePF = null;
		this.clientePJ = clientePJ;
	}
	
	//pessoa juridica, veiculoNovo
		public OrdemVenda(float valor, VeiculoNovo veiculoNovo,boolean novo,
				Date dataOperacao, String formaPagamento, boolean pago,
				ClienteJuridico clientePJ, boolean vendaConcluida, String idVenda) {
			this.valor = valor;
			this.veiculoNovo = veiculoNovo;
			this.veiculoUsado = null;
			this.novo = novo;
			this.dataOperacao = dataOperacao;
			this.formaPagamento = formaPagamento;
			this.pago = pago;
			this.clienteJuridico = true;
			this.clientePF = null;
			this.clientePJ = clientePJ;
		}

}
