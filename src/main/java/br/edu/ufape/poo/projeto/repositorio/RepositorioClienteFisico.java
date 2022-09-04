package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioClienteFisico extends JpaRepository<ClienteFisico, Long>{

}
