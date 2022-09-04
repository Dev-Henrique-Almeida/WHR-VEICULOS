package br.edu.ufape.poo.projeto.repositorio;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {
	
}
