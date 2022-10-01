package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.repositorio.RepositorioModelo;

@Service
@Transactional
public class CadastroModelo {

	@Autowired
	private RepositorioModelo repositorioModelo;

	public Modelo save(Modelo entity) throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException {

		if (entity.getNomeMarca().isEmpty() || entity.getNomeModelo().isEmpty()
				|| entity.getQuantidadePassageiros() == 0 || entity.getCambio().isEmpty()
				|| entity.getCombustivel().isEmpty() || entity.getCor().isEmpty() || entity.getMotor().isEmpty()
				|| entity.getAnoFabricado() == 0 || entity.getCilindradas() == 0 || entity.getPotencia() == 0) {
			throw new ValorNuloExpection();
		} else {
			if (entity.getNomeMarca().equals(entity.getNomeModelo())) {
				throw new NomeUnicoException();
			} else {
				return repositorioModelo.save(entity);
			}
		}
	}

	public Modelo update(Modelo entity) {
		return repositorioModelo.save(entity);
	}
	
	public void delete(Modelo entity) {
		repositorioModelo.delete(entity);
	}

	public void deleteById(long id) {
		repositorioModelo.deleteById(id);
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

	public List<Modelo> findAll() {
		return repositorioModelo.findAll();
	}

	
}
