package br.edu.ufape.poo.projeto.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaFisica;

@Service
@Transactional
public class CadastroOrdemPessoaFisica {

	@Autowired
	private RepositorioOrdemPessoaFisica repositorioOrdemPessoaFisica;

	public OrdemVendaPessoaFisica save(OrdemVendaPessoaFisica entity) throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		if (entity.getDataOperacao().before(new Date())) {
			throw new DateForaRangeException("Erro ao cadastrar, data inválida");
		} else {
			if (entity.getValor() < 0) {
				throw new ValorForaRangeException("Erro ao cadastrar, informações inválidas");
			} else {
				if (Objects.isNull(entity.getPago()) || Objects.isNull(entity.getNovo())
						|| Objects.isNull(entity.getVendaConcluida()) || Objects.isNull(entity.getDataOperacao())
						|| entity.getFormaPagamento().isEmpty() || Objects.isNull(entity.getValor())
						|| Objects.isNull(entity.getVendedor()) || Objects.isNull(entity.getVeiculo())) {
					throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
				} else {
					return repositorioOrdemPessoaFisica.save(entity);
				}
			}
		}
	}

	public void delete(OrdemVendaPessoaFisica entity) {
		repositorioOrdemPessoaFisica.delete(entity);
	}

	public void deleteById(long id) {
		repositorioOrdemPessoaFisica.deleteById(id);
	}

	public OrdemVendaPessoaFisica findById(long id) {
		return repositorioOrdemPessoaFisica.findById(id);
	}

	public List<OrdemVendaPessoaFisica> findAll() {
		return repositorioOrdemPessoaFisica.findAll();
	}

	public List<OrdemVendaPessoaFisica> findByPago(boolean pago) {
		return repositorioOrdemPessoaFisica.findByPago(pago);
	}

}

/*
 * (float valor, Veiculo veiculo, boolean novo, Date dataOperacao, String
 * formaPagamento, boolean pago, boolean vendaConcluida, Funcionario vendedor,
 * ClienteFisico cliente) { super(valor, veiculo, novo, dataOperacao,
 * formaPagamento, pago, vendaConcluida, vendedor);
 */