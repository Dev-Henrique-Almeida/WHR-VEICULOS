package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.Veiculo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long>{

	//Veiculo findByVeiculo(Veiculo veiculo);

	//Modelo findByModelo(Modelo modelo);

	//Veiculo findByVeiculoEntre(float a, float b);

	//List<Veiculo> findAllVeiculoUsado();

	//List<Veiculo> findAllVeiculoNovo();

	//List<Modelo> findAllModelo();
		
}
