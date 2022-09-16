package br.edu.ufape.poo.projeto.fachada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;
import br.edu.ufape.poo.projeto.basica.FichaVisitaJuridica;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.CadastroClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.CadastroFichaVisitaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroFichaVisitaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroFuncionario;
import br.edu.ufape.poo.projeto.cadastro.CadastroModelo;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.CadastroOrdemPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.CadastroVeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;

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

	@Autowired
	private CadastroFichaVisitaFisica cadastroFichaVisitaFisica;

	@Autowired
	private CadastroFichaVisitaJuridica cadastroFichaVisitaJuridica;

	////////////////////// CLIENTE FISICO //////////////////////////////

	public ClienteFisico save(ClienteFisico entity) throws ClienteFisicoExistenteException, DateForaRangeException, ValorVazioExpection, ValorForaRangeException{
		return cadastroClienteFisico.save(entity);
	}

	public void deleteByCpf(String cpf) {
		cadastroClienteFisico.deleteByCpf(cpf);

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

	public ClienteJuridico save(ClienteJuridico entity) throws ClienteJuridicoExistenteException, ValorVazioExpection, ValorForaRangeException {
		return cadastroClienteJuridico.save(entity);
	}

	public void deleteByCnpj(String cnpj) {
		cadastroClienteJuridico.deleteByCnpj(cnpj);
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

	public Funcionario save(Funcionario entity) throws FuncionarioExistenteException, DateForaRangeException, ValorForaRangeException, ValorVazioExpection {
		return cadastroFuncionario.save(entity);
	}

	public void deleteByCpfFuncionario(String cpf) {
		cadastroFuncionario.deleteByCpf(cpf);
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

	public Modelo save(Modelo entity) throws ValorVazioExpection, ValorForaRangeException {
		return cadastroModelo.save(entity);
	}

	public void delete(Modelo entity) {
		cadastroModelo.delete(entity);
	}

	public List<Modelo> findByNomeModelo(String nomeModelo) {
		return cadastroModelo.findByNomeModelo(nomeModelo);
	}

	public List<Modelo> findById(long id) {
		return cadastroModelo.findById(id);
	}

	public List<Modelo> findByAnoFabricado(int anoFabricado) {
		return cadastroModelo.findByAnoFabricado(anoFabricado);
	}

	public List<Modelo> findAllModelo() {
		return cadastroModelo.findAll();
	}

	///////////////////// ORDEM PESSOA FISICA ///////////////////

	public OrdemVendaPessoaFisica save(OrdemVendaPessoaFisica entity) throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		return cadastroOrdemPessoaFisica.save(entity);
	}

	public void delete(OrdemVendaPessoaFisica entity) {
		cadastroOrdemPessoaFisica.delete(entity);
	}

	public void deleteByIdOrdemFisica(long id) {
		cadastroOrdemPessoaFisica.deleteById(id);
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

	////////////////// ORDEM PESSOA JURIDICA /////////////////

	public OrdemVendaPessoaJuridica save(OrdemVendaPessoaJuridica entity) throws DateForaRangeException, ValorForaRangeException, ValorVazioExpection {
		return cadastroOrdemPessoaJuridica.save(entity);
	}

	public void delete(OrdemVendaPessoaJuridica entity) {
		cadastroOrdemPessoaJuridica.delete(entity);
	}

	public void deleteByIdOrdemJuridico(long id) {
		cadastroOrdemPessoaJuridica.deleteById(id);
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

	public VeiculoNovo save(VeiculoNovo vn) throws ValorVazioExpection, ValorForaRangeException {
		return cadastroVeiculoNovo.save(vn);
	}

	public void delete(VeiculoNovo entity) {
		cadastroVeiculoNovo.delete(entity);
	}

	public List<VeiculoNovo> findByValorVendaVeiculoNovo(float valorVenda) {
		return cadastroVeiculoNovo.findByValorVenda(valorVenda);
	}

	public List<VeiculoNovo> findByVendidoVeiculoNovo(boolean vendido) {
		return cadastroVeiculoNovo.findByVendido(vendido);
	}

	public List<VeiculoNovo> findByGarantiaFabricaVeiculoNovo(boolean garantiaFabrica) {
		return cadastroVeiculoNovo.findByGarantiaFabrica(garantiaFabrica);
	}

	public List<VeiculoNovo> findAllVeiculoNovo() {
		return cadastroVeiculoNovo.findAll();
	}

	/////////////////// VEICULO USADO /////////////////////

	public VeiculoUsado save(VeiculoUsado vn) throws ValorVazioExpection, ValorForaRangeException {
		return cadastroVeiculoUsado.save(vn);
	}

	public void delete(VeiculoUsado entity) {
		cadastroVeiculoUsado.delete(entity);
	}

	public List<VeiculoUsado> findByValorVendaVeiculoUsado(float valorVenda) {
		return cadastroVeiculoUsado.findByValorVenda(valorVenda);
	}

	public List<VeiculoUsado> findByVendidoVeiculoUsado(boolean vendido) {
		return cadastroVeiculoUsado.findByVendido(vendido);
	}

	public List<VeiculoUsado> findAllVeiculoUsado() {
		return cadastroVeiculoUsado.findAll();
	}

	/////////////// FICHA VISITA FISICA //////////////////

	public FichaVisitaFisica save(FichaVisitaFisica entity) {
		return cadastroFichaVisitaFisica.save(entity);
	}

	public void delete(FichaVisitaFisica entity) {
		cadastroFichaVisitaFisica.delete(entity);
	}

	public List<FichaVisitaFisica> findAllFichaVisitaFisica() {
		return cadastroFichaVisitaFisica.findAll();
	}

	//////////////////// FICHA VISITA JURIDICA /////////////////

	public FichaVisitaJuridica save(FichaVisitaJuridica entity) {
		return cadastroFichaVisitaJuridica.save(entity);
	}

	public void delete(FichaVisitaJuridica entity) {
		cadastroFichaVisitaJuridica.delete(entity);
	}

	public List<FichaVisitaJuridica> findAllFichaVisitaJuridica() {
		return cadastroFichaVisitaJuridica.findAll();
	}

}
