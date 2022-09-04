package br.edu.ufape.poo.projeto.cadastro;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteJuridico;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroClienteJuridico {
	
	@Autowired
	private RepositorioClienteJuridico repositorioClienteJuridico;

}
