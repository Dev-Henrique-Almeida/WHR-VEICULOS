package br.edu.ufape.poo.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;

@Repository
public interface RepositorioFichaVisitaFisica extends JpaRepository<FichaVisitaFisica, Long> {

}
