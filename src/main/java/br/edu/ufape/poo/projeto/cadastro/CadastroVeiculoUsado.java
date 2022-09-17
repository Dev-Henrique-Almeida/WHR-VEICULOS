package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@Service
public class CadastroVeiculoUsado {

	@Autowired
	private RepositorioVeiculoUsado repositorioVeiculoUsado;

	public VeiculoUsado save(VeiculoUsado vn) throws ValorVazioExpection, ValorForaRangeException {
		if (vn.getValorCompraVeiculo() < 0 || vn.getValorVenda() < 0 || vn.getPlaca().length() > 7
				|| vn.getPlaca().length() < 7 || vn.getKm() < 0 || vn.getChassi().length() < 17
				|| vn.getChassi().length() > 17) {
			throw new ValorForaRangeException("Erro ao cadastrar, informações inválidas");
		} else {
			if (Objects.isNull(vn.getModelo()) || Objects.isNull(vn.getValorCompraVeiculo())
					|| Objects.isNull(vn.getVendido()) || Objects.isNull(vn.getValorVenda())
					|| vn.getUnicoDono().isEmpty() || vn.getRevisado().isEmpty() || vn.getChassi().isEmpty()
					|| Objects.isNull(vn.getKm()) || vn.getPlaca().isEmpty()) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {
				return repositorioVeiculoUsado.save(vn);
			}
		}
	}

	public void delete(VeiculoUsado entity) {
		repositorioVeiculoUsado.delete(entity);
	}

	public List<VeiculoUsado> findByValorVenda(float valorVenda) {
		return repositorioVeiculoUsado.findByValorVenda(valorVenda);
	}

	public List<VeiculoUsado> findByVendido(boolean vendido) {
		return repositorioVeiculoUsado.findByVendido(vendido);
	}

	public List<VeiculoUsado> findAll() {
		return repositorioVeiculoUsado.findAll();
	}

}
