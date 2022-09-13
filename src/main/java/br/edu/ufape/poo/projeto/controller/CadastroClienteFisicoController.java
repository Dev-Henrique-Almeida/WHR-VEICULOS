package br.edu.ufape.poo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroClienteFisicoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("clienteFisico")
	public ClienteFisico createClienteFisico(@RequestBody ClienteFisico cliente) throws ClienteFisicoExistenteException {
		return c.save(cliente);
	}

	@PutMapping("clienteFisico")
	public ClienteFisico updateClienteFisico(@RequestBody ClienteFisico cliente) throws ClienteFisicoExistenteException {
		return c.save(cliente);
	}
		
	@DeleteMapping("deleteClienteFisico")
	public void deleteClienteFisico(@RequestBody String cpf) {  // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByCpf(cpf);
	}
	
	@GetMapping("cpfClienteFisico")
	public ClienteFisico findByCpf(@RequestBody String cpf) {
		return c.findByCpf(cpf);
	}
	
	@GetMapping("nomeClienteFisico")
	public ClienteFisico findByNome(@RequestBody String nome) {
		return c.findByNome(nome);
	}
	
	@GetMapping("allClienteFisico")
	public List<ClienteFisico> findAllClienteFisico() {
		return c.findAllClienteFisico();
	}

	
}
