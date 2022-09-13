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

import br.edu.ufape.poo.projeto.basica.Funcionario;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroFuncionarioController {

	@Autowired
	private Concessionaria c;

	@PostMapping("funcionario")
	public Funcionario createFuncionario(@RequestBody Funcionario cliente){
		return c.save(cliente);
	}

	@PutMapping("funcionario")
	public Funcionario updateFuncionario(@RequestBody Funcionario cliente){
		return c.save(cliente);
	}
		
	@DeleteMapping("deleteFuncionario")
	public void deleteFuncionario(@RequestBody String cpf) {  // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByCpf(cpf);
	}
	
	@GetMapping("cpfClienteFuncionario")
	public Funcionario findByCpf(@RequestBody String cpf) {
		return c.findByNomeFuncionario(cpf);
	}
	
	@GetMapping("nomeClienteFuncionario")
	public Funcionario findByNome(@RequestBody String nome) {
		return c.findByNomeFuncionario(nome);
	}
	
	@GetMapping("allClienteFuncionario")
	public List<Funcionario> findAllFuncionario() {
		return c.findAllFuncionario();
	}

	
}
