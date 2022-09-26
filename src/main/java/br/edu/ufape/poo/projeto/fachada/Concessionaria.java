package br.edu.ufape.poo.projeto.fachada;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.basica.PreVenda;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VeiculoVendidoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VendaSemLucroException;

@Service
public class Concessionaria {

	@Autowired
	private CadastroClienteFisico cadastroClienteFisico;

	@Autowired
	private CadastroFuncionario cadastroFuncionario;

	@Autowired
	private CadastroClienteJuridico cadastroClienteJuridico;

	@Autowired
	private CadastroModelo cadastroModelo;

	@Autowired
	private CadastroOrdemPessoaFisica cadastroOrdemPessoaFisica;

	@Autowired
	private CadastroOrdemPessoaJuridica cadastroOrdemPessoaJuridica;

	@Autowired
	private CadastroVeiculoNovo cadastroVeiculoNovo;

	@Autowired
	private CadastroVeiculoUsado cadastroVeiculoUsado;

	////////////////////// CLIENTE FISICO //////////////////////////////

	public ClienteFisico save(ClienteFisico entity)
			throws DataNulaException, ValorNuloExpection, ClienteFisicoExistenteException {
		return cadastroClienteFisico.save(entity);
	}

	public void deleteByCpf(String cpf) {
		cadastroClienteFisico.deleteByCpf(cpf);

	}

	public ClienteFisico update(ClienteFisico entity) {
		return cadastroClienteFisico.update(entity);
	}

	public void deleteById(long id) {
		cadastroClienteFisico.deleteById(id);
	}

	public ClienteFisico findByIdClienteFisico(long id) {
		return cadastroClienteFisico.findById(id);
	}

	public ClienteFisico findByCpf(String cpf) {
		return cadastroClienteFisico.findByCpf(cpf);
	}

	public ClienteFisico findByNome(String nome) {
		return cadastroClienteFisico.findByNome(nome);
	}

	public List<ClienteFisico> findAllClienteFisico() {
		return cadastroClienteFisico.findAll();
	}

	//////////////////////// CLIENTE JURIDICO ///////////////////////////////////

	public ClienteJuridico save(ClienteJuridico entity)
			throws ClienteJuridicoExistenteException, ValorNuloExpection, ValorForaRangeException {
		return cadastroClienteJuridico.save(entity);
	}

	public void deleteByCnpj(String cnpj) {
		cadastroClienteJuridico.deleteByCnpj(cnpj);
	}

	public ClienteJuridico findByIdClienteJuridico(long id) {
		return cadastroClienteJuridico.findById(id);
	}

	public ClienteJuridico update(ClienteJuridico entity) {
		return cadastroClienteJuridico.update(entity);
	}

	public void deleteByIdClienteJuridico(long id) {
		cadastroClienteJuridico.deleteById(id);
	}

	public ClienteJuridico findByCnpj(String cnpj) {
		return cadastroClienteJuridico.findByCnpj(cnpj);
	}

	public ClienteJuridico findByNomeFantasia(String nomeFantasia) {
		return cadastroClienteJuridico.findByNomeFantasia(nomeFantasia);
	}

	public List<ClienteJuridico> findAllClienteJuridico() {
		return cadastroClienteJuridico.findAll();
	}

	//////////////// FUNCIONARIO ///////////////////

	public Funcionario save(Funcionario entity)
			throws FuncionarioExistenteException, ValorNuloExpection, DataNulaException, DataForaRangeException {
		return cadastroFuncionario.save(entity);
	}

	public void deleteByIdFuncionario(long id) {
		cadastroFuncionario.deleteById(id);
	}

	public Funcionario update(Funcionario entity) {
		return cadastroFuncionario.update(entity);
	}

	public void deleteByCpfFuncionario(String cpf) {
		cadastroFuncionario.deleteByCpf(cpf);
	}

	public Funcionario findByIdFuncionario(long id) {
		return cadastroFuncionario.findById(id);
	}

	public Funcionario findByCpfFuncionario(String cpf) {
		return cadastroFuncionario.findByCpf(cpf);
	}

	public Funcionario findByNomeFuncionario(String nome) {
		return cadastroFuncionario.findByNome(nome);
	}

	public Funcionario findByCargo(String cargo) {
		return cadastroFuncionario.findByCargo(cargo);
	}

	public List<Funcionario> findAllFuncionario() {
		return cadastroFuncionario.findAll();
	}

	/////////////////// MODELO /////////////////////

	public Modelo save(Modelo entity) throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException {
		return cadastroModelo.save(entity);
	}

	public void delete(Modelo entity) {
		cadastroModelo.delete(entity);
	}

	public Modelo update(Modelo entity) {
		return cadastroModelo.update(entity);
	}

	public void deleteByIdModelo(long id) {
		cadastroModelo.deleteById(id);
	}

	public List<Modelo> findByNomeModelo(String nomeModelo) {
		return cadastroModelo.findByNomeModelo(nomeModelo);
	}

	public Modelo findById(long id) {
		return cadastroModelo.findById(id);
	}

	public List<Modelo> findByAnoFabricado(int anoFabricado) {
		return cadastroModelo.findByAnoFabricado(anoFabricado);
	}

	public List<Modelo> findAllModelo() {
		return cadastroModelo.findAll();
	}

	///////////////////// ORDEM PESSOA FISICA ///////////////////

	public OrdemVendaPessoaFisica save(OrdemVendaPessoaFisica entity)
			throws ValorNegativoException, ValorNuloExpection, DataNulaException, DataForaRangeException, VeiculoVendidoException {
		return cadastroOrdemPessoaFisica.save(entity);
	}

	public void delete(OrdemVendaPessoaFisica entity) {
		cadastroOrdemPessoaFisica.delete(entity);
	}

	public void deleteByIdOrdemFisica(long id) {
		cadastroOrdemPessoaFisica.deleteById(id);
	}

	public OrdemVendaPessoaFisica update(OrdemVendaPessoaFisica entity) {
		return cadastroOrdemPessoaFisica.update(entity);
	}

	public OrdemVendaPessoaFisica findByIdOrdemFisica(long id) {
		return cadastroOrdemPessoaFisica.findById(id);
	}

	public List<OrdemVendaPessoaFisica> findAllOrdemFisica() {
		return cadastroOrdemPessoaFisica.findAll();
	}

	public List<OrdemVendaPessoaFisica> findByPagoOrdemFisica(boolean pago) {
		return cadastroOrdemPessoaFisica.findByPago(pago);
	}

	/////////////////////// PRE VENDA /////////////////////////

	public void preVenda(PreVenda preVenda) throws FuncionarioNaoEncontradoException, ChassiNaoEncontradoException,
			ClienteNaoEncontradoException, ValorNuloExpection, ValorForaRangeException, DataForaRangeException,
			VendaSemLucroException, DataNulaException, ValorNegativoException {

		float valor;
		Date dataOperacao = new Date();
		Veiculo veiculo;

		Funcionario vendedor = findByCpfFuncionario(preVenda.getCpfFuncionario());
		if (vendedor == null) {
			throw new FuncionarioNaoEncontradoException("Erro ao cadastrar pré-venda, funcionário não encontrado!");
		} else {

			if (preVenda.isVeiculoNovo() == true) {

				veiculo = findByChassiVeiculoNovo(preVenda.getChassiVeiculo());
				if (veiculo == null) {
					throw new ChassiNaoEncontradoException("Erro ao cadastrar pré-venda, chassi não encontrado!");
				} else {
					valor = veiculo.getValorVenda();
				}

			} else {

				veiculo = findByChassiVeiculoUsado(preVenda.getChassiVeiculo());
				if (veiculo == null) {
					throw new ChassiNaoEncontradoException("Erro ao cadastrar pré-venda, chassi não encontrado!");
				} else {
					valor = veiculo.getValorVenda();
				}
			}

			if (preVenda.isClienteJuridico() == true) {
				ClienteJuridico cliente = findByCnpj(preVenda.getCpfCnpjCliente());
				if (cliente == null) {
					throw new ClienteNaoEncontradoException(
							"Erro ao cadastrar pré-venda, cliente físico não foi encontrado!");
				} else {
					OrdemVendaPessoaJuridica venda = new OrdemVendaPessoaJuridica(valor, veiculo,
							preVenda.isVeiculoNovo(), dataOperacao, preVenda.getFormaPagamento(), true, true, vendedor,
							cliente);

					cadastroOrdemPessoaJuridica.save(venda);
					
				}
			} else {
				ClienteFisico cliente = findByCpf(preVenda.getCpfCnpjCliente());
				if (cliente == null) {
					throw new ClienteNaoEncontradoException(
							"Erro ao cadastrar pré-venda, cliente físico não foi encontrado!");
				} else {
					OrdemVendaPessoaFisica venda = new OrdemVendaPessoaFisica(valor, veiculo, preVenda.isVeiculoNovo(),
							dataOperacao, preVenda.getFormaPagamento(), true, true, vendedor, cliente);
					
					cadastroOrdemPessoaFisica.save(venda);
					
				}
			}
		}
	}

	////////////////// ORDEM PESSOA JURIDICA /////////////////

	public OrdemVendaPessoaJuridica save(OrdemVendaPessoaJuridica entity) throws ValorNuloExpection,
			ValorForaRangeException, DataForaRangeException, VendaSemLucroException, DataNulaException {
		return cadastroOrdemPessoaJuridica.save(entity);

	}

	public void delete(OrdemVendaPessoaJuridica entity) {
		cadastroOrdemPessoaJuridica.delete(entity);
	}

	public void deleteByIdOrdemJuridico(long id) {
		cadastroOrdemPessoaJuridica.deleteById(id);
	}

	public OrdemVendaPessoaJuridica update(OrdemVendaPessoaJuridica entity) {
		return cadastroOrdemPessoaJuridica.update(entity);
	}

	public OrdemVendaPessoaJuridica findByIdOrdemJuridico(long id) {
		return cadastroOrdemPessoaJuridica.findById(id);
	}

	public List<OrdemVendaPessoaJuridica> findByPagoOrdemJuridico(boolean pago) {
		return cadastroOrdemPessoaJuridica.findByPago(pago);
	}

	public List<OrdemVendaPessoaJuridica> findAllOrdemJuridico() {
		return cadastroOrdemPessoaJuridica.findAll();
	}

	///////////////// VEICULO NOVO //////////////////

	public VeiculoNovo save(VeiculoNovo vn) throws ValorNuloExpection, ChassiExistenteException {
		return cadastroVeiculoNovo.save(vn);
	}

	public void delete(VeiculoNovo entity) {
		cadastroVeiculoNovo.delete(entity);
	}

	public VeiculoNovo update(VeiculoNovo entity) {
		return cadastroVeiculoNovo.update(entity);
	}

	public void deleteByIdVeiculoNovo(long id) {
		cadastroVeiculoNovo.deleteById(id);
	}

	public VeiculoNovo findByIdVeiculoNovo(long id) {
		return cadastroVeiculoNovo.findById(id);
	}

	public VeiculoNovo findByChassiVeiculoNovo(String chassi) {
		return cadastroVeiculoNovo.findByChassi(chassi);
	}

	public List<VeiculoNovo> findByValorVendaVeiculoNovo(float valorVenda) {
		return cadastroVeiculoNovo.findByValorVenda(valorVenda);
	}

	public List<VeiculoNovo> findAllByVendidoVeiculoNovo() {
		return cadastroVeiculoNovo.findAllByVendido();
	}

	public List<VeiculoNovo> findByGarantiaFabricaVeiculoNovo(String garantiaFabrica) {
		return cadastroVeiculoNovo.findByGarantiaFabrica(garantiaFabrica);
	}

	public List<VeiculoNovo> findAllVeiculoNovo() {
		return cadastroVeiculoNovo.findAll();
	}

	/////////////////// VEICULO USADO /////////////////////

	public VeiculoUsado save(VeiculoUsado vn)
			throws ChassiExistenteException, ValorNuloExpection, PlacaExistenteException {
		return cadastroVeiculoUsado.save(vn);
	}

	public void delete(VeiculoUsado entity) {
		cadastroVeiculoUsado.delete(entity);
	}

	public VeiculoUsado update(VeiculoUsado entity) {
		return cadastroVeiculoUsado.update(entity);
	}

	public void deleteByIdVeiculoUsado(long id) {
		cadastroVeiculoUsado.deleteById(id);
	}

	public VeiculoUsado findByIdVeiculoUsado(long id) {
		return cadastroVeiculoUsado.findById(id);
	}

	public VeiculoUsado findByChassiVeiculoUsado(String chassi) {
		return cadastroVeiculoUsado.findByChassi(chassi);
	}

	public List<VeiculoUsado> findByValorVendaVeiculoUsado(float valorVenda) {
		return cadastroVeiculoUsado.findByValorVenda(valorVenda);
	}

	public List<VeiculoUsado> findAllByVendidoUsado() {
		return cadastroVeiculoUsado.findAllByVendido();
	}

	public List<VeiculoUsado> findAllVeiculoUsado() {
		return cadastroVeiculoUsado.findAll();
	}

}
