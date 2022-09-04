package br.edu.ufape.poo.projeto.repositorio;
import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Veiculo;

import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {

	Funcionario findbyNome(String nome);

	Funcionario findByCargo(String cargo);

	void deleteByCpf(String cpf);

	Veiculo findbyVeiculo(Veiculo v);

	ClienteFisico save(ClienteFisico entity);

	ClienteJuridico save(ClienteJuridico entity);
	
}
