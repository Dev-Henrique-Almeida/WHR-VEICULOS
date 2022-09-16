package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.Modelo;

@Repository
public interface RepositorioModelo extends JpaRepository<Modelo, Long> {

	public List<Modelo> findByAnoFabricado(int anoFabricado);

	public List<Modelo> findByNomeModelo(String nomeModelo);

	public List<Modelo> findById(long id);

}
