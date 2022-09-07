package br.edu.ufape.poo.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;

@CrossOrigin (origins = "http://localhost:8080/" )
@RestController
@RequestMapping( "/whr/api/v1/")
public class ClienteFisicoController {
	@Autowired
	private RepositorioClienteFisico repositorioClienteFisico;
	
	@PostMapping("clienteFisico")
	public ClienteFisico createClienteFisico(@RequestBody ClienteFisico cf) {
		return repositorioClienteFisico.save(cf);
	}

}
