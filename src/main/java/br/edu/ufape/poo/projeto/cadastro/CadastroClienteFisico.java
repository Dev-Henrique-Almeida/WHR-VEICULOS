package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class CadastroClienteFisico {
	
	@Autowired
	private RepositorioClienteFisico repositorioClienteFisico;
	

}
