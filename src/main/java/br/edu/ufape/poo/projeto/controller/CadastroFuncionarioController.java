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

import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroFuncionarioController {

	@Autowired
	private Concessionaria c;

	@PostMapping("funcionario")
	public ResponseEntity<Funcionario> createFuncionario(@RequestBody Funcionario funcionario)
			throws DateForaRangeException, ValorVazioExpection, ValorForaRangeException, FuncionarioExistenteException {
		Funcionario f = c.save(funcionario);
		return new ResponseEntity<Funcionario>(f, HttpStatus.CREATED);

	}

	@PutMapping("funcionario/{funcionario}")
	public Funcionario updateFuncionario(@PathVariable("funcionario") Funcionario funcionario)
			throws FuncionarioExistenteException, DateForaRangeException, ValorForaRangeException, ValorVazioExpection {
		return c.save(funcionario);
	}

	@DeleteMapping("deleteFuncionario/{cpf}")
	public void deleteFuncionario(@PathVariable("cpf") String cpf) { // @PathVariable poder ser usado para remover
																		// diretamente na URL
		c.deleteByCpf(cpf);
	}

	@GetMapping("cpfFuncionario/{cpf}")
	public Funcionario findByCpf(@PathVariable("cpf") String cpf) {
		return c.findByNomeFuncionario(cpf);
	}

	@GetMapping("idFuncionario/{id}")
	public Funcionario findByIdFuncionario(@PathVariable("id") long id) {
		return c.findByIdFuncionario(id);
	}

	@GetMapping("nomeFuncionario/{nome}")
	public Funcionario findByNome(@PathVariable("nome") String nome) {
		return c.findByNomeFuncionario(nome);
	}

	@GetMapping("allFuncionario")
	public List<Funcionario> findAllFuncionario() {
		return c.findAllFuncionario();
	}

}
