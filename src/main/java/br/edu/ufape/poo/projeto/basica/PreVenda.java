package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PreVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String cpfCnpjCliente;
	private String cpfFuncionario;
	private String chassiVeiculo;
	private boolean clienteJuridico;
	private boolean veiculoNovo;
	private String formaPagamento;

	public PreVenda() {

	}

	public PreVenda(String cpfCnpjCliente, String cpfFuncionario, String chassiVeiculo, boolean clienteJuridico,
			boolean veiculoNovo, String formaPagamento) {
		this.cpfCnpjCliente = cpfCnpjCliente;
		this.cpfFuncionario = cpfFuncionario;
		this.chassiVeiculo = chassiVeiculo;
		this.clienteJuridico = clienteJuridico;
		this.veiculoNovo = veiculoNovo;
		this.formaPagamento = formaPagamento;
	}

	public long getId() {
		return id;
	}

	public String getCpfCnpjCliente() {
		return cpfCnpjCliente;
	}

	public String getCpfFuncionario() {
		return cpfFuncionario;
	}

	public String getChassiVeiculo() {
		return chassiVeiculo;
	}

	public boolean isClienteJuridico() {
		return clienteJuridico;
	}

	public boolean isVeiculoNovo() {
		return veiculoNovo;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

}