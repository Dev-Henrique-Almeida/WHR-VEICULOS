package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioOrdemVenda extends JpaRepository<OrdemVenda, Long>{
	/*
	public OrdemVenda findbyCodigoVenda(String codigoVenda);

	public void deleteBycodigoVenda(String codigoVenda);*/

}
