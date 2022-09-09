package br.edu.ufape.poo.projeto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.Veiculo;

@Repository
public interface RepositorioVeiculo extends JpaRepository<Veiculo, Long>{
/*
	public Veiculo findByVeiculo(Veiculo veiculo);

	public Modelo findByModelo(Modelo modelo);

	public Veiculo findByVeiculoEntre(float a, float b);

	public List<Veiculo> findAllVeiculoUsado();

	public List<Veiculo> findAllVeiculoNovo();

	public List<Modelo> findAllModelo();*/
		
}
