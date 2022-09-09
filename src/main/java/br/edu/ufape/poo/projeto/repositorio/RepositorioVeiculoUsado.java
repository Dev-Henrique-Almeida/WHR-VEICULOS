package br.edu.ufape.poo.projeto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.VeiculoUsado;


@Repository
public interface RepositorioVeiculoUsado extends JpaRepository<VeiculoUsado, Long>{

	//public VeiculoUsado findByModelo(Modelo modelo);
}