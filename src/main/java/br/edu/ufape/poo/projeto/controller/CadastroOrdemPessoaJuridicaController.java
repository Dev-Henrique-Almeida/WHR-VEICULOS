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

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VendaSemLucroException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaJuridicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemJuridica")
	public ResponseEntity<OrdemVendaPessoaJuridica> createOrdemVendaPessoaJuridica(
			@RequestBody OrdemVendaPessoaJuridica entity)
			throws DateForaRangeException, ValorVazioExpection, ValorForaRangeException, VendaSemLucroException {
		OrdemVendaPessoaJuridica or = c.save(entity);
		return new ResponseEntity<OrdemVendaPessoaJuridica>(or, HttpStatus.CREATED);

	}

	@PutMapping("ordemJuridica")
	public OrdemVendaPessoaJuridica updateOrdemPessoaJuridica(@RequestBody OrdemVendaPessoaJuridica cliente)
			throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException, VendaSemLucroException {
		return c.save(cliente);
	}

	@DeleteMapping("deleteOrdemJuridica/{id}")
	public void deleteOrdemPessoaJuridica(@PathVariable("id") long id) {
		c.deleteByIdOrdemJuridico(id);
	}

	@GetMapping("idOrdemJuridica/{id}")
	public OrdemVendaPessoaJuridica findByIdOrdemFisica(@PathVariable("id") long id) {
		return c.findByIdOrdemJuridico(id);
	}

	@GetMapping("pagoOrdemJuridica/{pago}")
	public List<OrdemVendaPessoaJuridica> findByPagoOrdemFisica(@PathVariable("pago") boolean pago) {
		return c.findByPagoOrdemJuridico(pago);
	}

	@GetMapping("allOrdemJuridica")
	public List<OrdemVendaPessoaJuridica> findAllOrdemFisica() {
		return c.findAllOrdemJuridico();
	}

}
