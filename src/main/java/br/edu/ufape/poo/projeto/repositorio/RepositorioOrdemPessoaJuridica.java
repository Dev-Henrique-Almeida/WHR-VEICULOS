package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;

public interface RepositorioOrdemPessoaJuridica extends JpaRepository<OrdemVendaPessoaJuridica, Long> {

	OrdemVendaPessoaJuridica findById(long id);

	List<OrdemVendaPessoaJuridica> findByPago(boolean pago);

}
