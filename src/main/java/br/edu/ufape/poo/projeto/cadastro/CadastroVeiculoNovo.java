package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoNovo;

@Service
@Transactional
public class CadastroVeiculoNovo {

	@Autowired
	private RepositorioVeiculoNovo repositorioVeiculoNovo;

	public VeiculoNovo save(VeiculoNovo vn) throws ValorVazioExpection, ValorForaRangeException {
		if (vn.getValorCompraVeiculo() < 0 || vn.getValorVenda() < 0) {
			throw new ValorForaRangeException("Erro ao cadastrar, informações invaálidas");
		} else {
			if (Objects.isNull(vn.getModelo()) || Objects.isNull(vn.getValorCompraVeiculo())
					|| Objects.isNull(vn.getVendido()) || Objects.isNull(vn.getValorVenda())
					|| vn.getGarantiaFabrica().isEmpty()) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {
				return repositorioVeiculoNovo.save(vn);
			}
		}
	}

	public void delete(VeiculoNovo entity) {
		repositorioVeiculoNovo.delete(entity);
	}

	public List<VeiculoNovo> findByValorVenda(float valorVenda) {
		return repositorioVeiculoNovo.findByValorVenda(valorVenda);
	}

	public List<VeiculoNovo> findByVendido(boolean vendido) {
		return repositorioVeiculoNovo.findByVendido(vendido);
	}

	public List<VeiculoNovo> findByGarantiaFabrica(boolean garantiaFabrica) {
		return repositorioVeiculoNovo.findByGarantiaFabrica(garantiaFabrica);
	}

	public List<VeiculoNovo> findAll() {
		return repositorioVeiculoNovo.findAll();
	}
}

/*
 * (float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo,
 * String garantiaFabrica) {
 */