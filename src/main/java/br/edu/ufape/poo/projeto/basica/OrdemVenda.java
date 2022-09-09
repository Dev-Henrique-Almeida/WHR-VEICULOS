package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrdemVenda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private float valor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Veiculo veiculo;
	
	private boolean novo;
	private Date dataOperacao;
	private String formaPagamento;
	private boolean pago;
	private boolean vendaConcluida;
	private String codVenda;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	private Funcionario vendedor;
		
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

	public float getValor() {
		return valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public boolean isNovo() {
		return novo;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}


	public boolean isPago() {
		return pago;
	}

	public boolean isVendaConcluida() {
		return vendaConcluida;
	}

	public String getCodVenda() {
		return codVenda;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "OrdemVenda [valor=" + valor + ", veiculo=" + veiculo + ", novo=" + novo + ", dataOperacao="
				+ dataOperacao + ", formaPagamento=" + formaPagamento + ", pago=" + pago + ", vendaConcluida="
				+ vendaConcluida + ", codVenda=" + codVenda + ", vendedor=" + vendedor + ", id=" + id + "]";
	}
	
	public OrdemVenda() {
	}
	
	
	

}
	


