package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@Service
public class CadastroVeiculoUsado {

	@Autowired
	private RepositorioVeiculoUsado repositorioVeiculoUsado;

	public VeiculoUsado save(VeiculoUsado vu)
			throws ChassiExistenteException, ValorNuloExpection, PlacaExistenteException {

		if (Objects.isNull(vu.getModelo().getCambio().isEmpty()) || Objects.isNull(vu.getModelo().getAnoFabricado())
				|| vu.getModelo().getCombustivel().isEmpty()
				|| vu.getModelo().getCor().isEmpty()
				|| vu.getModelo().getMotor().isEmpty()
				|| vu.getModelo().getNomeModelo().isEmpty()
				|| vu.getModelo().getNomeMarca().isEmpty()
				|| Objects.isNull(vu.getModelo().getQuantidadePassageiros())
				|| Objects.isNull(vu.getModelo().getAnoFabricado()) || Objects.isNull(vu.getModelo().getCilindradas())
				|| Objects.isNull(vu.getModelo().getPotencia()) || Objects.isNull(findByValorCompraVeiculo(vu.getValorCompraVeiculo()))
				|| Objects.isNull(vu.getVendido()) || Objects.isNull(vu.getValorVenda()) || vu.getUnicoDono().isEmpty()
				|| vu.getRevisado().isEmpty() || vu.getChassi().isEmpty() || Objects.isNull(vu.getKm())
				|| vu.getPlaca().isEmpty()) {
			throw new ValorNuloExpection("Erro ao cadastrar, informações inválidas");
		} else {
			if (Objects.nonNull(findByPlaca(vu.getPlaca()))) {
				throw new PlacaExistenteException("Erro ao cadastrar, placa já existe, por favor informe outra Placa!");
			} else {

				if (Objects.isNull(findByChassi(vu.getChassi()))) {

					return repositorioVeiculoUsado.save(vu);
				} else {

					throw new ChassiExistenteException(
							"Erro ao cadastrar, chassi já existe, por favor informe outro Chassi!");
				}
			}
		}
	}

	public void delete(VeiculoUsado entity) {
		repositorioVeiculoUsado.delete(entity);
	}

	public VeiculoUsado findByChassi(String chassi) {
		return repositorioVeiculoUsado.findByChassi(chassi);
	}

	public VeiculoUsado findByPlaca(String placa) {
		return repositorioVeiculoUsado.findByPlaca(placa);
	}

	public VeiculoUsado findByValorCompraVeiculo(float valorCompraVeiculo) {
		return repositorioVeiculoUsado.findByValorCompraVeiculo(valorCompraVeiculo);
	}
	
	public VeiculoUsado findByVendido(boolean vendido) {
		return repositorioVeiculoUsado.findByVendido(vendido);
	}
	
	public List<VeiculoUsado> findAllByVendido() {
		boolean vendido = false;
		return repositorioVeiculoUsado.findAllByVendido(vendido);
	}
	
	public VeiculoUsado findByKm(float km) {
		return repositorioVeiculoUsado.findByKm(km);
	}

	public VeiculoUsado findById(long id) {
		return repositorioVeiculoUsado.findById(id);
	}

	public List<VeiculoUsado> findByValorVenda(float valorVenda) {
		return repositorioVeiculoUsado.findByValorVenda(valorVenda);
	}

	public List<VeiculoUsado> findAll() {
		return repositorioVeiculoUsado.findAll();
	}

	public VeiculoUsado update(VeiculoUsado entity) {
		return repositorioVeiculoUsado.save(entity);
	}

	public void deleteById(long id) {
		repositorioVeiculoUsado.deleteById(id);
	}

}
