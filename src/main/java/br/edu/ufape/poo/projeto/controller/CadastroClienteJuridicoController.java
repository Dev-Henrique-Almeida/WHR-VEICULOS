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

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroClienteJuridicoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("clienteJuridico")
	public ClienteJuridico createClienteJuridico(@RequestBody ClienteJuridico cliente)
			throws ClienteJuridicoExistenteException {
		return c.save(cliente);
	}

	@PutMapping("clienteJuridico")
	public ClienteJuridico updateClienteJuridico(@RequestBody ClienteJuridico cliente) throws ClienteJuridicoExistenteException {
		return c.save(cliente);
	}
		
	@DeleteMapping("deleteClienteJuridico")
	public void deleteClienteJuridico(@RequestBody String cnpj) {  // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByCnpj(cnpj);
	}
	
	@GetMapping("cnpjClienteJuridico")
	public ClienteJuridico findByCnpj(@RequestBody String cnpj) {
		return c.findByCnpj(cnpj);
	}
	
	@GetMapping("nomeClienteJuridico")
	public ClienteJuridico findByNomeFantasia(@RequestBody String nomeFantasia) {
		return c.findByNomeFantasia(nomeFantasia);
	}
	
	@GetMapping("allClienteJuridico")
	public List<ClienteJuridico> findAllClienteJuridico() {
		return c.findAllClienteJuridico();
	}

	
}
