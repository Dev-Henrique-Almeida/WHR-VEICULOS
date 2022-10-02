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

import br.edu.ufape.poo.projeto.basica.OrdemVendaPessoaFisica;
import br.edu.ufape.poo.projeto.basica.PreVenda;
import br.edu.ufape.poo.projeto.exceptions.ChassiNaoEncontradoException;
import br.edu.ufape.poo.projeto.exceptions.ClienteNaoEncontradoException;
import br.edu.ufape.poo.projeto.exceptions.DataForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.DataNulaException;
import br.edu.ufape.poo.projeto.exceptions.FuncionarioNaoEncontradoException;
import br.edu.ufape.poo.projeto.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.exceptions.VeiculoVendidoException;
import br.edu.ufape.poo.projeto.exceptions.VendaSemLucroException;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaFisicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemVendaPessoaFisica")
	public ResponseEntity<OrdemVendaPessoaFisica> createOrdemPessoaFisica(@RequestBody OrdemVendaPessoaFisica entity)
			throws ValorNuloExpection, ValorForaRangeException, DataForaRangeException, VendaSemLucroException,
			ValorNegativoException, DataNulaException, VeiculoVendidoException {
		OrdemVendaPessoaFisica or = c.save(entity);
		return new ResponseEntity<OrdemVendaPessoaFisica>(or, HttpStatus.CREATED);

	}

	@PostMapping("ordemPessoaFisica")
	public ResponseEntity<HttpStatus> createPreVenda(@RequestBody PreVenda entity)
			throws ValorNegativoException, ValorNuloExpection, DataNulaException, ValorForaRangeException,
			DataForaRangeException, VendaSemLucroException, ChassiNaoEncontradoException,
			FuncionarioNaoEncontradoException, ClienteNaoEncontradoException {
		c.preVenda(entity);
		return new ResponseEntity<HttpStatus>(HttpStatus.CREATED);

	}

	@PutMapping("updateOrdemVendaPessoaFisica/{id}")
	public ResponseEntity<OrdemVendaPessoaFisica> updateOrdemVendaPessoaFisica(@PathVariable("id") long id,
			@RequestBody OrdemVendaPessoaFisica ordemFisica) {
		if (id == ordemFisica.getId()) {
			return new ResponseEntity<OrdemVendaPessoaFisica>(c.update(ordemFisica), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrdemVendaPessoaFisica>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteOrdemPessoaFisica/{id}")
	public ResponseEntity<HttpStatus> deleteOrdemVendaPessoaFisica(@PathVariable("id") long id) {
		c.deleteByIdOrdemFisica(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@DeleteMapping("cancelarVendaFisica/{id}")
	public ResponseEntity<HttpStatus> cancelarVendaFisica(@PathVariable("id") long id) {
		c.cancelarByIdOrdemFisica(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
	@GetMapping("idOrdemPessoaFisica/{id}")
	public ResponseEntity<OrdemVendaPessoaFisica> findById(@PathVariable("id") long id) {
		if (c.findByIdOrdemFisica(id) != null) {
			return new ResponseEntity<OrdemVendaPessoaFisica>(c.findByIdOrdemFisica(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<OrdemVendaPessoaFisica>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("pagoOrdemPessoaFisica/{pago}")
	public ResponseEntity<List<OrdemVendaPessoaFisica>> findByPago(@PathVariable("pago") boolean pago) {
		if (c.findByPagoOrdemFisica(pago) != null) {
			return new ResponseEntity<List<OrdemVendaPessoaFisica>>(c.findByPagoOrdemFisica(pago), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<OrdemVendaPessoaFisica>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("allOrdemPessoaFisica")
	public ResponseEntity<List<OrdemVendaPessoaFisica>> findAllOrdemFisica() {
		return new ResponseEntity<List<OrdemVendaPessoaFisica>>(c.findAllOrdemFisica(), HttpStatus.OK);
	}

}
