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

import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteFisicoExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroClienteFisicoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("clienteFisico")
	public ResponseEntity<ClienteFisico> createClienteFisico(@RequestBody ClienteFisico cliente)
			throws ClienteFisicoExistenteException, ValorNuloExpection, ValorForaRangeException, DataNulaException,
			DataForaRangeException {
		ClienteFisico cf = c.save(cliente);
		return new ResponseEntity<ClienteFisico>(cf, HttpStatus.CREATED);

	}

	@PutMapping("updateClienteFisico/{id}")
	public ResponseEntity<ClienteFisico> updateClienteFisico(@PathVariable("id") long id,
			@RequestBody ClienteFisico cliente) {
		if (id == cliente.getId()) {
			return new ResponseEntity<ClienteFisico>(c.update(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteFisico>(HttpStatus.NOT_FOUND);
		}
	}
	

	@DeleteMapping("deleteClienteFisico/{id}")
	public ResponseEntity<HttpStatus> deleteClienteFisico(@PathVariable("id") long id) {
		if(c.findByIdClienteFisico(id) != null) {
			c.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
		}else {
			return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
		}
		
	}

	@GetMapping("idClienteFisico/{id}")
	public ResponseEntity<ClienteFisico> findByIdClienteFisico(@PathVariable("id") long id) {
		if(c.findByIdClienteFisico(id) != null) {
			return new ResponseEntity<ClienteFisico>(c.findByIdClienteFisico(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteFisico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("cpfClienteFisico/{cpf}")
	public ResponseEntity<ClienteFisico> findByCpf(@PathVariable("cpf") String cpf) {
		if(c.findByCpf(cpf) != null) {
			return new ResponseEntity<ClienteFisico>(c.findByCpf(cpf), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteFisico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("nomeClienteFisico/{nome}")
	public ResponseEntity<ClienteFisico> findByNome(@PathVariable("nome") String nome) {
		if(c.findByNome(nome) != null) {
			return new ResponseEntity<ClienteFisico>(c.findByNome(nome), HttpStatus.OK);
		} else {
			return new ResponseEntity<ClienteFisico>(HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("allClienteFisico")
	public ResponseEntity<List<ClienteFisico>> findAllClienteFisico() {
			return new ResponseEntity<List<ClienteFisico>>(c.findAllClienteFisico(), HttpStatus.OK);

	}


}
