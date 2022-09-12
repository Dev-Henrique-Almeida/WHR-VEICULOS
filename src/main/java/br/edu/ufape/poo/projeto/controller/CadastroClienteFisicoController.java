package br.edu.ufape.poo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "http://localhost:8080/")
@Controller
public class CadastroClienteFisicoController {

	@Autowired
	private Concessionaria c;

	@RequestMapping("/cadastro/cliente")
	public String cadastroCliente() {
		return "cadastroCliente";
	}

	@PostMapping("cliente")
	public ClienteFisico createClienteFisico(@RequestBody ClienteFisico cliente)
			throws ClienteFisicoExistenteException {
		return c.save(cliente);
	}

	@GetMapping("pegaCliente")
	public List<ClienteFisico> findCliente() {
		return c.findAll();
	}

	@GetMapping("cpfCliente")
	public ClienteFisico findByCpf(String cpf) {
		return c.findByCpf("123");
	}
}
