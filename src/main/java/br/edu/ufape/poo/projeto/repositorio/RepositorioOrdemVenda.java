package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;
import br.edu.ufape.poo.projeto.basica.Funcionario;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioOrdemVenda extends JpaRepository<OrdemVenda, Long>{
	

}
