package br.edu.ufape.poo.projeto.repositorio;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioClienteJuridico extends JpaRepository<ClienteJuridico, Long>{

	public List<ClienteJuridico> findByCnpj(String cnpj);
	
	public void deleteByCnpj(String cnpj);

	public List<ClienteJuridico> findByNomeFantasia(String nomeFantasia);

	
	
	

}
