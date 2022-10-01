package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.PlacaExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@Service
@Transactional
public class CadastroVeiculoUsado {

	@Autowired
	private RepositorioVeiculoUsado repositorioVeiculoUsado;

	public VeiculoUsado save(VeiculoUsado vu)
			throws ChassiExistenteException, ValorNuloExpection, PlacaExistenteException {

		if (vu.getModelo().getCambio().isEmpty() || vu.getModelo().getAnoFabricado() == 0
				|| vu.getModelo().getCombustivel().isEmpty() || vu.getModelo().getCor().isEmpty()
				|| vu.getModelo().getMotor().isEmpty() || vu.getModelo().getNomeModelo().isEmpty()
				|| vu.getModelo().getNomeMarca().isEmpty() || vu.getModelo().getQuantidadePassageiros() == 0
				|| vu.getModelo().getCilindradas() == 0 || vu.getModelo().getPotencia() == 0
				|| vu.getValorCompraVeiculo() == 0 || (vu.getVendido() != true && vu.getVendido() != false)
				|| vu.getValorVenda() == 0 || vu.getUnicoDono().isEmpty() || vu.getRevisado().isEmpty()
				|| vu.getChassi().isEmpty() || vu.getKm() == 0 || vu.getPlaca().isEmpty()) {
			throw new ValorNuloExpection();
		} else {
			if (Objects.nonNull(findByPlaca(vu.getPlaca()))) {
				throw new PlacaExistenteException();
			} else {

				if (Objects.isNull(findByChassi(vu.getChassi()))) {

					return repositorioVeiculoUsado.save(vu);
				} else {

					throw new ChassiExistenteException();
				}
			}
		}
	}
	
	public VeiculoUsado update(VeiculoUsado entity) {
		return repositorioVeiculoUsado.save(entity);
	}

	public void deleteById(long id) {
		repositorioVeiculoUsado.deleteById(id);
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

	public List<VeiculoUsado> findAllByVendido() {
		boolean vendido = false;
		return repositorioVeiculoUsado.findAllByVendido(vendido);
	}
	
}
