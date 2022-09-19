package br.edu.ufape.poo.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;

@Repository
public interface RepositorioClienteJuridico extends JpaRepository<ClienteJuridico, Long> {

	public void deleteByCnpj(String cnpj);

	public ClienteJuridico findByCnpj(String cnpj);

	public ClienteJuridico findById(long id);

	public ClienteJuridico findByNomeFantasia(String nomeFantasia);

}
