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
import br.edu.ufape.poo.projeto.basica.PreVenda;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ClienteNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.FuncionarioNaoEncontradoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.cadastro.exceptions.VendaSemLucroException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaJuridicaController {

	@Autowired
	private Concessionaria c;

	@PutMapping("updateOrdemVendaPessoaJuridica/{id}")
	public ResponseEntity<OrdemVendaPessoaJuridica> updateOrdemVendaPessoaJuridica(@PathVariable("id") long id,
			@RequestBody OrdemVendaPessoaJuridica ordemJuridica) {
		if (id == ordemJuridica.getId()) {
			return new ResponseEntity<OrdemVendaPessoaJuridica>(c.update(ordemJuridica), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrdemVendaPessoaJuridica>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("ordemJuridica")
	public ResponseEntity<OrdemVendaPessoaJuridica> createOrdemVendaPessoaJuridica(
			@RequestBody OrdemVendaPessoaJuridica entity) throws DataForaRangeException, ValorForaRangeException,
			ValorNuloExpection, VendaSemLucroException, DataNulaException {
		OrdemVendaPessoaJuridica or = c.save(entity);
		return new ResponseEntity<OrdemVendaPessoaJuridica>(or, HttpStatus.CREATED);

	}
	
	@DeleteMapping("cancelarVendaJuridica/{id}")
	public ResponseEntity<HttpStatus> cancelarVendaFisica(@PathVariable("id") long id) {
		c.cancelarByIdOrdemJurica(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@PostMapping("ordemPessoaJuridica")
	public ResponseEntity<HttpStatus> createPreVenda(@RequestBody PreVenda entity)
			throws ValorNegativoException, ValorNuloExpection, DataNulaException, ValorForaRangeException,
			DataForaRangeException, VendaSemLucroException, ChassiNaoEncontradoException,
			FuncionarioNaoEncontradoException, ClienteNaoEncontradoException {
		c.preVenda(entity);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);

	}

	@DeleteMapping("deleteOrdemJuridica/{id}")
	public ResponseEntity<HttpStatus> deleteOrdemPessoaJuridica(@PathVariable("id") long id) {
		c.deleteByIdOrdemJuridico(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("idOrdemJuridica/{id}")
	public ResponseEntity<OrdemVendaPessoaJuridica> findByIdOrdemJuridica(@PathVariable("id") long id) {
		if (c.findByIdOrdemJuridico(id) != null) {
			return new ResponseEntity<OrdemVendaPessoaJuridica>(c.findByIdOrdemJuridico(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrdemVendaPessoaJuridica>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("pagoOrdemJuridica/{pago}")
	public ResponseEntity<List<OrdemVendaPessoaJuridica>> findByPagoOrdemJuridica(@PathVariable("pago") boolean pago) {
		if (c.findByPagoOrdemJuridico(pago) != null) {
			return new ResponseEntity<List<OrdemVendaPessoaJuridica>>(c.findByPagoOrdemJuridico(pago), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<OrdemVendaPessoaJuridica>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("allOrdemJuridica")
	public ResponseEntity<List<OrdemVendaPessoaJuridica>> findAllOrdemJuridica() {
		return new ResponseEntity<List<OrdemVendaPessoaJuridica>>(c.findAllOrdemJuridico(), HttpStatus.OK);
	}

}
