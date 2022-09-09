package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.basica.Veiculo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long>{
	public List<Veiculo> findByModelo(Modelo modelo);
/*
	public Veiculo findByVeiculo(Veiculo veiculo);

	public Modelo findByModelo(Modelo modelo);

	public Veiculo findByVeiculoEntre(float a, float b);

	public List<Veiculo> findAllVeiculoUsado();

	public List<Veiculo> findAllVeiculoNovo();

	public List<Modelo> findAllModelo();*/
		
}
