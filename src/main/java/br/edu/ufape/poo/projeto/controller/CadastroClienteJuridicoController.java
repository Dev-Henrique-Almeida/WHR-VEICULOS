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

	@PutMapping("updateClienteJuridico/{id}")
	public ResponseEntity<ClienteJuridico> updateClienteJuridico(@PathVariable("id") long id,
			@RequestBody ClienteJuridico cliente) {
		if (id == cliente.getId()) {
			return new ResponseEntity<ClienteJuridico>(c.update(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteJuridico>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteClienteJuridico/{id}")
	public ResponseEntity<HttpStatus> deleteClienteJuridico(@PathVariable("id") long id) {
		c.deleteByIdClienteJuridico(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("deleteClienteJuridicoCnpj/{cnpj}")
	public ResponseEntity<HttpStatus> deleteClienteJuridico(@PathVariable("cnpj") String cnpj) {
		c.deleteByCnpj(cnpj);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("cnpjClienteJuridico/{cnpj}")
	public ResponseEntity<ClienteJuridico> findByCnpj(@PathVariable("cnpj") String cnpj) {
		if(c.findByCnpj(cnpj) != null) {
			return new ResponseEntity<ClienteJuridico>(c.findByCnpj(cnpj), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteJuridico>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("idClienteJuridico/{id}")
	public ResponseEntity<ClienteJuridico> findByIdClienteJuridico(@PathVariable("id") long id) {
		if(c.findByIdClienteJuridico(id) != null) {
			return new ResponseEntity<ClienteJuridico>(c.findByIdClienteJuridico(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteJuridico>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("nomeClienteJuridico/{nomeFantasia}")
	public ResponseEntity<ClienteJuridico> findByNomeFantasia(@PathVariable("nomeFantasia") String nomeFantasia) {
		if(c.findByNomeFantasia(nomeFantasia) != null) {
			return new ResponseEntity<ClienteJuridico>(c.findByNomeFantasia(nomeFantasia), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteJuridico>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("allClienteJuridico")
	public ResponseEntity<List<ClienteJuridico>> findAllClienteJuridico() {
		return new ResponseEntity<List<ClienteJuridico>>(c.findAllClienteJuridico(), HttpStatus.OK);
	}

}
