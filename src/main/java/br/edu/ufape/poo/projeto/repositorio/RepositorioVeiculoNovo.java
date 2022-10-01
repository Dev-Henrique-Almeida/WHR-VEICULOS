package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;

@Repository
public interface RepositorioVeiculoNovo extends JpaRepository<VeiculoNovo, Long> {

	public VeiculoNovo findByChassi(String chassi);

	public VeiculoNovo findById(long id);

	public VeiculoNovo findByKm(float km);

	public VeiculoNovo findByVendido(boolean vendido);

	public VeiculoNovo findByValorCompraVeiculo(float valorCompraVeiculo);
	
	public List<VeiculoNovo> findByValorVenda(float valorVenda);

	public List<VeiculoNovo> findByGarantiaFabrica(String garantiaFabrica);

	public List<VeiculoNovo> findAllByVendido(boolean vendido);
	
}