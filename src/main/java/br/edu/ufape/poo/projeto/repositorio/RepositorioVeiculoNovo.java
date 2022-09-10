package br.edu.ufape.poo.projeto.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;


@Repository
public interface RepositorioVeiculoNovo extends JpaRepository<VeiculoNovo, Long>{

	public List<VeiculoNovo> findByValorVenda(float valorVenda);

	public List<VeiculoNovo> findByVendido(boolean vendido);
	
	public List<VeiculoNovo> findByGarantiaFabrica(boolean garantiaFabrica);
	
	//public void deleteByVeiculoNovo(VeiculoNovo veiculoNovo);

}