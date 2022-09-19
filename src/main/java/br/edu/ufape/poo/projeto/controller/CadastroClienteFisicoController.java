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
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroClienteFisicoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("clienteFisico")
	public ResponseEntity<ClienteFisico> createClienteFisico(@RequestBody ClienteFisico cliente)
			throws ClienteFisicoExistenteException, DateForaRangeException, ValorVazioExpection,
			ValorForaRangeException {
		ClienteFisico cf = c.save(cliente);
		return new ResponseEntity<ClienteFisico>(cf, HttpStatus.CREATED);

	}

	@PutMapping("clienteFisico/{cliente}")
	public ClienteFisico updateClienteFisico(@PathVariable("cliente") ClienteFisico cliente)
			throws ClienteFisicoExistenteException, DateForaRangeException, ValorVazioExpection,
			ValorForaRangeException {
		return c.save(cliente);
	}

	@DeleteMapping("deleteClienteFisico/{cpf}")
	public void deleteClienteFisico(@PathVariable("cpf") String cpf) {
		c.deleteByCpf(cpf);
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
