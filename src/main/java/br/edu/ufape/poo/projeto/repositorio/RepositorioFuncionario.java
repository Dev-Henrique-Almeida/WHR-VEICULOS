package br.edu.ufape.poo.projeto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.Funcionario;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {


	public void deleteByCpf(String cpf);
	
	public Funcionario findByNome(String nome);

	public Funcionario findByCargo(String cargo);

	

}
