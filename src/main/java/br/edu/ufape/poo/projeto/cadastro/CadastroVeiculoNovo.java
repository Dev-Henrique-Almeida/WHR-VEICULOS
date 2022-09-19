package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoNovo;

@Service
@Transactional
public class CadastroVeiculoNovo {

	@Autowired
	private RepositorioVeiculoNovo repositorioVeiculoNovo;

	public VeiculoNovo save(VeiculoNovo vn)
			throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {
		if (vn.getValorCompraVeiculo() < 0 || vn.getValorVenda() < 0 || vn.getKm() < 0 || vn.getChassi().length() < 17
				|| vn.getChassi().length() > 17) {
			throw new ValorForaRangeException("Erro ao cadastrar, informações inválidas");
		} else {
			if (Objects.isNull(vn.getModelo().getCambio().isEmpty()) || Objects.isNull(vn.getModelo().getAnoFabricado())
					|| Objects.isNull(vn.getModelo().getCombustivel().isEmpty())
					|| Objects.isNull(vn.getModelo().getCor().isEmpty())
					|| Objects.isNull(vn.getModelo().getMotor().isEmpty())
					|| Objects.isNull(vn.getModelo().getNomeModelo().isEmpty())
					|| Objects.isNull(vn.getModelo().getNomeMarca().isEmpty())
					|| Objects.isNull(vn.getModelo().getQuantidadePassageiros())
					|| Objects.isNull(vn.getModelo().getAnoFabricado())
					|| Objects.isNull(vn.getModelo().getCilindradas()) || Objects.isNull(vn.getModelo().getPotencia())
					|| Objects.isNull(vn.getValorCompraVeiculo()) || Objects.isNull(vn.getVendido())
					|| Objects.isNull(vn.getValorVenda()) || Objects.isNull(vn.getValorCompraVeiculo())
					|| Objects.isNull(vn.getVendido()) || Objects.isNull(vn.getValorVenda())
					|| vn.getGarantiaFabrica().isEmpty() || vn.getChassi().isEmpty() || Objects.isNull(vn.getKm())) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {
				if (Objects.isNull(findByChassi(vn.getChassi()))) {

					return repositorioVeiculoNovo.save(vn);
				} else {

					throw new ChassiExistenteException(
							"Erro ao cadastrar veículo novo, chassi já existe, por favor informe outro Chassi!");
				}
			}
		}
	}

	public void delete(VeiculoNovo entity) {
		repositorioVeiculoNovo.delete(entity);
	}

	public VeiculoNovo findByChassi(String chassi) {
		return repositorioVeiculoNovo.findByChassi(chassi);
	}

	public VeiculoNovo findById(long id) {
		return repositorioVeiculoNovo.findById(id);
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