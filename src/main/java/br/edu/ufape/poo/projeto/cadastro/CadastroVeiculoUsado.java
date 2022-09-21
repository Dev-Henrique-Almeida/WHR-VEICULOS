package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorCompraNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@Service
public class CadastroVeiculoUsado {

	@Autowired
	private RepositorioVeiculoUsado repositorioVeiculoUsado;

	public VeiculoUsado save(VeiculoUsado vn) throws ValorVazioExpection, ValorForaRangeException,
			ChassiExistenteException, ValorCompraNegativoException {

		if (vn.getValorCompraVeiculo() < 0 || vn.getValorVenda() < 0 || vn.getPlaca().length() > 7
				|| vn.getPlaca().length() < 7 || vn.getKm() < 0 || vn.getChassi().length() < 17
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
					|| Objects.isNull(vn.getValorVenda()) || vn.getUnicoDono().isEmpty() || vn.getRevisado().isEmpty()
					|| vn.getChassi().isEmpty() || Objects.isNull(vn.getKm()) || vn.getPlaca().isEmpty()) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {
				if (Objects.isNull(findByChassi(vn.getChassi()))) {

					return repositorioVeiculoUsado.save(vn);
				} else {

					throw new ChassiExistenteException(
							"Erro ao cadastrar veículo usado, chassi já existe, por favor informe outro Chassi!");
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

	public List<VeiculoUsado> findAllByVendido() {
		boolean vendido = false;
		return repositorioVeiculoUsado.findAllByVendido(vendido);
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

}
