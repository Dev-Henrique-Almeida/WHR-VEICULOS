package br.edu.ufape.poo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteJuridicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroClienteJuridicoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("clienteJuridico")
	public ResponseEntity<ClienteJuridico> createClienteJuridico(@RequestBody ClienteJuridico cliente)
			throws ClienteJuridicoExistenteException, ValorNuloExpection, ValorForaRangeException {
		ClienteJuridico cf = c.save(cliente);
		return new ResponseEntity<ClienteJuridico>(cf, HttpStatus.CREATED);

	}

	@PutMapping("clienteJuridico/{cliente}")
	public ClienteJuridico updateClienteJuridico(@PathVariable("cliente") ClienteJuridico cliente)
			throws ClienteJuridicoExistenteException, ValorNuloExpection, ValorForaRangeException {
		return c.save(cliente);
	}

	@DeleteMapping("deleteClienteJuridico/{cnpj}")
	public void deleteClienteJuridico(@PathVariable("cnpj") String cnpj) {
		c.deleteByCnpj(cnpj);
	}

	@GetMapping("cnpjClienteJuridico/{cnpj}")
	public ClienteJuridico findByCnpj(@PathVariable("cnpj") String cnpj) {
		return c.findByCnpj(cnpj);
	}

	@GetMapping("idClienteJuridico/{id}")
	public ClienteJuridico findByIdClienteJuridico(@PathVariable("id") long id) {
		return c.findByIdClienteJuridico(id);
	}

	@GetMapping("nomeClienteJuridico/{nomeFantasia}")
	public ClienteJuridico findByNomeFantasia(@PathVariable("nomeFantasia") String nomeFantasia) {
		return c.findByNomeFantasia(nomeFantasia);
	}

	@GetMapping("allClienteJuridico")
	public List<ClienteJuridico> findAllClienteJuridico() {
		return c.findAllClienteJuridico();
	}

}
