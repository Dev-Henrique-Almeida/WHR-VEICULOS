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

import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculo;

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

	public void setValor(float valor) {
		this.valor = valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}

	public boolean isNovo() {
		return novo;
	}

	public void setNovo(boolean novo) {
		this.novo = novo;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public void setDataOperacao(Date dataOperacao) {
		this.dataOperacao = dataOperacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public boolean isPago() {
		return pago;
	}

	public void setPago(boolean pago) {
		this.pago = pago;
	}

	public boolean isVendaConcluida() {
		return vendaConcluida;
	}

	public void setVendaConcluida(boolean vendaConcluida) {
		this.vendaConcluida = vendaConcluida;
	}

	public String getCodVenda() {
		return codVenda;
	}

	public void setCodVenda(String codVenda) {
		this.codVenda = codVenda;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public void setVendedor(Funcionario vendedor) {
		this.vendedor = vendedor;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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
	


