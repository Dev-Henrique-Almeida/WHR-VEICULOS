package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioModelo;

@Service
public class CadastroModelo {

	@Autowired
	private RepositorioModelo repositorioModelo;

	public Modelo save(Modelo entity) throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException {
		if (entity.getNomeMarca().equals(entity.getNomeModelo())) {
			throw new NomeUnicoException("Erro ao cadastrar, nomes devem ser diferentes!");
		} else {
			if (entity.getNomeMarca().isEmpty() || entity.getNomeModelo().isEmpty()
					|| Objects.isNull(entity.getQuantidadePassageiros()) || entity.getCambio().isEmpty()
					|| Objects.isNull(entity.getCombustivel().isEmpty()) || entity.getCor().isEmpty() || entity.getMotor().isEmpty()
					|| Objects.isNull(entity.getAnoFabricado()) || Objects.isNull(entity.getCilindradas())
					|| Objects.isNull(entity.getPotencia())) {
				throw new ValorNuloExpection("Erro ao cadastrar, informações inválidas");
			} else {
				return repositorioModelo.save(entity);
			}
		}
	}

	public void delete(Modelo entity) {
		repositorioModelo.delete(entity);
	}

	public Modelo update(Modelo entity) {
		return repositorioModelo.save(entity);
	}

	public void deleteById(long id) {
		repositorioModelo.deleteById(id);
	}

	public List<Modelo> findAll() {
		return repositorioModelo.findAll();
	}

	public Modelo findById(long id) {
		return repositorioModelo.findById(id);
	}

	public Modelo findByCilindradas(float cilindradas) {
		return repositorioModelo.findByCilindradas(cilindradas);
	}
	
	public Modelo findByPotencia(int potencia) {
		return repositorioModelo.findByPotencia(potencia);
	}
	
	public Modelo findByQuantidadePassageiros(int quantidadePassageiros) {
		return repositorioModelo.findByQuantidadePassageiros(quantidadePassageiros);
	}
	
	public List<Modelo> findByNomeModelo(String nomeModelo) {
		return repositorioModelo.findByNomeModelo(nomeModelo);
	}

	public List<Modelo> findByAnoFabricado(int anoFabricado) {
		return repositorioModelo.findByAnoFabricado(anoFabricado);
	}

}
