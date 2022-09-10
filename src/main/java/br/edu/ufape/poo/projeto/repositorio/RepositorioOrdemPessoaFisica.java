package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;

public interface RepositorioOrdemPessoaFisica extends JpaRepository<OrdemVendaPessoaFisica, Long> {

	List<OrdemVendaPessoaFisica> findByCodVenda(String codVenda);

	List<OrdemVendaPessoaFisica> findByPago(boolean pago);

	void deleteByCodVenda(String codVenda);
	
	
}
