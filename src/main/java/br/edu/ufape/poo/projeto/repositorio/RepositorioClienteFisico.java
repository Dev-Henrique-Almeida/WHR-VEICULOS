package br.edu.ufape.poo.projeto.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;

@Repository
public interface RepositorioClienteFisico extends JpaRepository<ClienteFisico, Long> {

	public void deleteByCpf(String cpf);
	
	public ClienteFisico findByCpf(String cpf);

	public ClienteFisico findByNome(String nome);

	public ClienteFisico findById(long id);

}
