package br.edu.ufape.poo.projeto.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;

public interface RepositorioOrdemPessoaFisica extends JpaRepository<OrdemVendaPessoaFisica, Long> {

	public List<OrdemVendaPessoaFisica> findByPago(boolean pago);

	OrdemVendaPessoaFisica findById(long id);

	public OrdemVendaPessoaFisica findByNovo(boolean novo);

	public OrdemVendaPessoaFisica findByVendaConcluida(boolean vendaConcluida);

	public OrdemVendaPessoaFisica findByValor(float valor);

}
