package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.OrdemVenda;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long>{

	List<Veiculo> findByVeiculo(Veiculo veiculo);

	List<Modelo> findByModelo(Modelo modelo);

	List<Veiculo> findByVeiculoEntre(float a, float b);

	List<Veiculo> findAllVeiculoUsado();

	List<Veiculo> findAllVeiculoNovo();

	List<Modelo> findAllModelo();
		
}
