package br.edu.ufape.poo.projeto.cadastro;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioOrdemPessoaFisica;

@Service
@Transactional
public class CadastroOrdemPessoaFisica {

	@Autowired
	private RepositorioOrdemPessoaFisica repositorioOrdemPessoaFisica;

	public OrdemVendaPessoaFisica save(OrdemVendaPessoaFisica entity)
			throws ValorNegativoException, ValorNuloExpection, DataNulaException, DataForaRangeException {

		if (Objects.isNull(entity.getPago()) || Objects.isNull(entity.getNovo())
				|| (entity.getVendaConcluida() != true && entity.getVendaConcluida() != false)
				|| entity.getFormaPagamento().isEmpty() || entity.getValor() == 0
				|| Objects.isNull(entity.getVendedor()) || Objects.isNull(entity.getVeiculo())
				|| Objects.isNull(entity.getVeiculo().getModelo())) {
			throw new ValorNuloExpection();
		} else {
			if (Objects.isNull(entity.getDataOperacao())) {
				throw new DataNulaException();
			} else {
				if (entity.getDataOperacao().after(new Date())) {
					throw new DataForaRangeException();
				} else {

					return repositorioOrdemPessoaFisica.save(entity);
				}
			}
		}
	}
	
	public OrdemVendaPessoaFisica update(OrdemVendaPessoaFisica entity) {
		return repositorioOrdemPessoaFisica.save(entity);
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

	public OrdemVendaPessoaFisica findByNovo(boolean novo) {
		return repositorioOrdemPessoaFisica.findByNovo(novo);
	}

	public OrdemVendaPessoaFisica findByValor(float valor) {
		return repositorioOrdemPessoaFisica.findByValor(valor);
	}

	public OrdemVendaPessoaFisica findByVendaConcluida(boolean vendaConcluida) {
		return repositorioOrdemPessoaFisica.findByVendaConcluida(vendaConcluida);
	}

	public List<OrdemVendaPessoaFisica> findByPago(boolean pago) {
		return repositorioOrdemPessoaFisica.findByPago(pago);
	}
	
	public List<OrdemVendaPessoaFisica> findAll() {
		return repositorioOrdemPessoaFisica.findAll();
	}

}