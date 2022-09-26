package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class OrdemVenda implements IOrdem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private float valor;

	@OneToOne(cascade = CascadeType.MERGE)
	private Veiculo veiculo;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Funcionario vendedor;

	private boolean novo;
	private Date dataOperacao;
	private String formaPagamento;
	private boolean pago;
	private boolean vendaConcluida;

	public OrdemVenda() {

	}

	public OrdemVenda(float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String formaPagamento,
			boolean pago, boolean vendaConcluida, Funcionario vendedor) {
		super();
		this.valor = valor;
		this.veiculo = veiculo;
		this.novo = novo;
		this.dataOperacao = dataOperacao;
		this.formaPagamento = formaPagamento;
		this.pago = pago;
		this.vendaConcluida = vendaConcluida;
		this.vendedor = vendedor;
	}

	public float getValor() {
		return valor;
	}

	public Veiculo getVeiculo() {
		return veiculo;
	}

	public boolean getNovo() {
		return novo;
	}

	public Date getDataOperacao() {
		return dataOperacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public boolean getPago() {
		return pago;
	}

	public boolean getVendaConcluida() {
		return vendaConcluida;
	}
	
	public void setVendaConcluida(boolean vendaConcluida) {
		this.vendaConcluida = vendaConcluida;
	}

	public Funcionario getVendedor() {
		return vendedor;
	}

	public long getId() {
		return id;
	}

	@Override
	public boolean checarValor(float valor) throws ValorNegativoException {
		if (valor < 0) {
			throw new ValorNegativoException("Erro ao cadastrar, valor inválido!");
		} else {
			return true;
		}
	}

	@Override
	public boolean checarData(Date data) throws DataForaRangeException {
		if (data.before(new Date())) {
			throw new DataForaRangeException("Erro ao cadastrar, data inválida!");
		} else {
			return true;
		}
	}

	@Override
	public String toString() {
		return "OrdemVenda [valor=" + valor + ", veiculo=" + veiculo + ", novo=" + novo + ", dataOperacao="
				+ dataOperacao + ", formaPagamento=" + formaPagamento + ", pago=" + pago + ", vendaConcluida="
				+ vendaConcluida + ", vendedor=" + vendedor + ", codVenda=" + id + "]";
	}

}
