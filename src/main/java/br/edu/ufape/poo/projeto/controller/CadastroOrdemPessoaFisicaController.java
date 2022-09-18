package br.edu.ufape.poo.projeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaFisicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemPessoaFisica")
	public OrdemVendaPessoaFisica createOrdemPessoaFisica(@RequestBody OrdemVendaPessoaFisica entity)
			throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		return c.save(entity);
	}

	@PutMapping("ordemPessoaFisica/{entity}")
	public OrdemVendaPessoaFisica updateOrdemPessoaFisica(@PathVariable("entity") OrdemVendaPessoaFisica entity)
			throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		return c.save(entity);
	}

	@DeleteMapping("deleteOrdemPessoaFisica/{id}")
	public void deleteOrdemVendaPessoaFisica(@PathVariable("id") long id) { // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByIdOrdemFisica(id);
	}

	@GetMapping("idOrdemPessoaFisica/{id}")
	public OrdemVendaPessoaFisica findById(@PathVariable("id") long id) {
		return c.findByIdOrdemFisica(id);
	}

	@GetMapping("pagoOrdemPessoaFisica/{pago}")
	public List<OrdemVendaPessoaFisica> findByPago(@PathVariable("pago") boolean pago) {
		return c.findByPagoOrdemFisica(pago);
	}

	@GetMapping("allOrdemPessoaFisica")
	public List<OrdemVendaPessoaFisica> findAllOrdemFisica() {
		return c.findAllOrdemFisica();
	}

}
