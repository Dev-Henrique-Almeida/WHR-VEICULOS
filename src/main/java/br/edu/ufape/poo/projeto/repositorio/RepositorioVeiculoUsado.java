package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;

@Repository
public interface RepositorioVeiculoUsado extends JpaRepository<VeiculoUsado, Long> {

	public List<VeiculoUsado> findByValorVenda(float valorVenda);

	public List<VeiculoUsado> findByVendido(boolean vendido);

	public VeiculoUsado findByChassi(String chassi);

}