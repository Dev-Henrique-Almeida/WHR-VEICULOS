package br.edu.ufape.poo.projeto.repositorio;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioFuncionario extends JpaRepository<Funcionario, Long> {

	public Funcionario findByNome(String nome);

	public Funcionario findByCargo(String cargo);

	public void deleteByCpf(String cpf);

	//public Veiculo findByVeiculo(Veiculo v);

	public ClienteFisico save(ClienteFisico entity);

	public ClienteJuridico save(ClienteJuridico entity);

}
