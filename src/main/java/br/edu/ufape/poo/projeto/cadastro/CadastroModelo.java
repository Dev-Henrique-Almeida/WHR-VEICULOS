package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioModelo;

@Service
public class CadastroModelo {

	@Autowired
	private RepositorioModelo repositorioModelo;

	public Modelo save(Modelo entity) throws ValorVazioExpection, ValorForaRangeException {
		if (entity.getQuantidadePassageiros() < 0 || entity.getAnoFabricado() < 1900 || entity.getAnoFabricado() > 2023
				|| entity.getCilindradas() < 0 || entity.getKm() < 0 || entity.getPotencia() < 0) {
			throw new ValorForaRangeException("Erro ao cadastrar, informações inválidas");
		} else {
			if (entity.getNomeMarca().isEmpty() || entity.getNomeModelo().isEmpty()
					|| Objects.isNull(entity.getQuantidadePassageiros()) || entity.getCambio().isEmpty()
					|| entity.getCombustivel().isEmpty() || entity.getCor().isEmpty() || entity.getMotor().isEmpty()
					|| Objects.isNull(entity.getAnoFabricado()) || Objects.isNull(entity.getCilindradas())
					|| Objects.isNull(entity.getKm()) || Objects.isNull(entity.getPotencia())) {
				throw new ValorVazioExpection("Erro ao cadastrar, informações inválidas");
			} else {
				return repositorioModelo.save(entity);
			}
		}
	}

	public void delete(Modelo entity) {
		repositorioModelo.delete(entity);
	}

	public List<Modelo> findAll() {
		return repositorioModelo.findAll();
	}

	public List<Modelo> findById(long id) {
		return repositorioModelo.findById(id);
	}

	public List<Modelo> findByNomeModelo(String nomeModelo) {
		return repositorioModelo.findByNomeModelo(nomeModelo);
	}

	public List<Modelo> findByAnoFabricado(int anoFabricado) {
		return repositorioModelo.findByAnoFabricado(anoFabricado);
	}

}
