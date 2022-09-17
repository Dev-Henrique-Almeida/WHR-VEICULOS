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

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaJuridica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaJuridicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemJuridica")
	public OrdemVendaPessoaFisica createOrdemPessoaJuridica(@RequestBody OrdemVendaPessoaFisica entity)
			throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		return c.save(entity);
	}

	@PutMapping("ordemJuridica")
	public OrdemVendaPessoaFisica updateOrdemPessoaJuridica(@RequestBody OrdemVendaPessoaFisica cliente)
			throws ValorVazioExpection, ValorForaRangeException, DateForaRangeException {
		return c.save(cliente);
	}

	@DeleteMapping("deleteOrdemJuridica")
	public void deleteOrdemPessoaJuridica(@RequestBody long id) { // @PathVariable poder ser usado para remover
																	// diretamente na URL
		c.deleteByIdOrdemJuridico(id);
	}

	@GetMapping("idOrdemJuridica")
	public OrdemVendaPessoaJuridica findByIdOrdemFisica(@RequestBody long id) {
		return c.findByIdOrdemJuridico(id);
	}

	@GetMapping("pagoOrdemJuridica")
	public List<OrdemVendaPessoaJuridica> findByPagoOrdemFisica(@RequestBody boolean pago) {
		return c.findByPagoOrdemJuridico(pago);
	}

	@GetMapping("allOrdemJuridica")
	public List<OrdemVendaPessoaJuridica> findAllOrdemFisica() {
		return c.findAllOrdemJuridico();
	}

}
