package br.edu.ufape.poo.projeto.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaJuridica;

@Service
public class CadastroOrdemPessoaJuridica {

	@Autowired
	private RepositorioOrdemPessoaJuridica repositorioOrdemPessoaJuridica;

	public OrdemVendaPessoaJuridica save(OrdemVendaPessoaJuridica entity) throws DateForaRangeException, ValorForaRangeException, ValorVazioExpection {
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
					return repositorioOrdemPessoaJuridica.save(entity);
				}
			}
		}
	}

	public void delete(OrdemVendaPessoaJuridica entity) {
		repositorioOrdemPessoaJuridica.delete(entity);
	}

	public List<OrdemVendaPessoaJuridica> findAll() {
		return repositorioOrdemPessoaJuridica.findAll();
	}

	public void deleteById(long id) {
		repositorioOrdemPessoaJuridica.deleteById(id);
	}

	public OrdemVendaPessoaJuridica findById(long id) {
		return repositorioOrdemPessoaJuridica.findById(id);
	}

	public List<OrdemVendaPessoaJuridica> findByPago(boolean pago) {
		return repositorioOrdemPessoaJuridica.findByPago(pago);
	}

}
