package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoNovo;

@Service
@Transactional
public class CadastroVeiculoNovo {

	@Autowired
	private RepositorioVeiculoNovo repositorioVeiculoNovo;

	public VeiculoNovo save(VeiculoNovo vn) throws ValorNuloExpection, ChassiExistenteException {

		if (vn.getModelo().getCambio().isEmpty() || vn.getModelo().getAnoFabricado() == 0
				|| vn.getModelo().getCombustivel().isEmpty() || vn.getModelo().getCor().isEmpty()
				|| vn.getModelo().getMotor().isEmpty() || vn.getModelo().getNomeModelo().isEmpty()
				|| vn.getModelo().getNomeMarca().isEmpty() || vn.getModelo().getQuantidadePassageiros() == 0
				|| vn.getModelo().getCilindradas() == 0 || vn.getModelo().getPotencia() == 0
				|| vn.getValorCompraVeiculo() == 0 || vn.getValorVenda() == 0 || vn.getGarantiaFabrica().isEmpty()
				|| vn.getChassi().isEmpty()) {
			throw new ValorNuloExpection("Erro ao cadastrar, informações inválidas");
		} else {
			if (Objects.isNull(findByChassi(vn.getChassi()))) {

				return repositorioVeiculoNovo.save(vn);
			} else {

				throw new ChassiExistenteException(
						"Erro ao cadastrar veículo novo, chassi já existe, por favor informe outro Chassi!");
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

	public VeiculoNovo findByKm(float km) {
		return repositorioVeiculoNovo.findByKm(km);
	}

	public VeiculoNovo findByValorCompraVeiculo(float valorCompraVeiculo) {
		return repositorioVeiculoNovo.findByValorCompraVeiculo(valorCompraVeiculo);
	}

	public VeiculoNovo findByVendido(boolean vendido) {
		return repositorioVeiculoNovo.findByVendido(vendido);
	}

	public List<VeiculoNovo> findByValorVenda(float valorVenda) {
		return repositorioVeiculoNovo.findByValorVenda(valorVenda);
	}

	public List<VeiculoNovo> findAllByVendido() {
		boolean vendido = false;
		return repositorioVeiculoNovo.findAllByVendido(vendido);
	}

	public List<VeiculoNovo> findAllById(Iterable<Long> ids) {
		return repositorioVeiculoNovo.findAllById(ids);
	}

	public List<VeiculoNovo> findByGarantiaFabrica(String garantiaFabrica) {
		return repositorioVeiculoNovo.findByGarantiaFabrica(garantiaFabrica);
	}

	public List<VeiculoNovo> findAll() {
		return repositorioVeiculoNovo.findAll();
	}

	public VeiculoNovo update(VeiculoNovo entity) {
		return repositorioVeiculoNovo.save(entity);
	}

	public void deleteById(long id) {
		repositorioVeiculoNovo.deleteById(id);
	}

}
