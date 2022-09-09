package br.edu.ufape.poo.projeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;
import br.edu.ufape.poo.projeto.repositorio.RepositorioClienteFisico;


//@CrossOrigin (origins = "http://localhost:8080/")

//@RestController

@RequestMapping("/whr/addClienteFisico/")
@Controller
public class ClienteFisicoController {
	@Autowired
	private RepositorioClienteFisico cf;
	
	@PostMapping("clienteFisico")
	public ClienteFisico createClienteFisico(@RequestBody ClienteFisico clienteFisico) {
		System.out.println(clienteFisico);
		return cf.save(clienteFisico);
	}
	
}
