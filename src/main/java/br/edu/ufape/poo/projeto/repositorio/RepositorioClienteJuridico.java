package br.edu.ufape.poo.projeto.repositorio;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepositorioClienteJuridico extends JpaRepository<ClienteJuridico, Long>{

	//ClienteJuridico findBycnpj(String cnpj);

	//void deleteByCnpj(String cnpj);
	
	//ClienteJuridico findByNomeCnpj(String cnpj);

	//ClienteJuridico findByNomeFantasia(String nomeFantasia);

}
