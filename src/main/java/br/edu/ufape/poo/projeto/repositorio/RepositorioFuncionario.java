package br.edu.ufape.poo.projeto.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.edu.ufape.poo.projeto.basica.Funcionario;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {


	public List<Funcionario> deleteByCpf(String cpf);
	
	//public void deleteByCnpj(String cnpj);
	
	public List<Funcionario> findByNome(String nome);

	public List<Funcionario> findByCargo(String cargo);

	

}
