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
	public void deleteClienteFisico(@PathVariable("id") long id) {
		c.deleteById(id);
	}

	@GetMapping("idClienteFisico/{id}")
	public ClienteFisico findByIdClienteFisico(@PathVariable("id") long id) {
		return c.findByIdClienteFisico(id);
	}

	@GetMapping("cpfClienteFisico/{cpf}")
	public ClienteFisico findByCpf(@PathVariable("cpf") String cpf) {
		return c.findByCpf(cpf);
	}

	@GetMapping("nomeClienteFisico/{nome}")
	public ClienteFisico findByNome(@PathVariable("nome") String nome) {
		return c.findByNome(nome);
	}

	@GetMapping("allClienteFisico")
	public List<ClienteFisico> findAllClienteFisico() {
		return c.findAllClienteFisico();
	}

}
