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
public class CadastroOrdemPessoaFisicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemVendaPessoaFisica")
	public ResponseEntity<OrdemVendaPessoaFisica> createOrdemPessoaFisica(@RequestBody OrdemVendaPessoaFisica entity)
			throws ValorNuloExpection, ValorForaRangeException, DataForaRangeException, VendaSemLucroException,
			ValorNegativoException, DataNulaException {
		OrdemVendaPessoaFisica or = c.save(entity);
		return new ResponseEntity<OrdemVendaPessoaFisica>(or, HttpStatus.CREATED);

	}

	@PostMapping("ordemPessoaFisica")
	public void createPreVenda(@RequestBody PreVenda entity) throws ValorNegativoException, ValorNuloExpection,
			DataNulaException, ValorForaRangeException, DataForaRangeException, VendaSemLucroException,
			ChassiNaoEncontradoException, FuncionarioNaoEncontradoException, ClienteNaoEncontradoException {
		c.preVenda(entity);

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
	public void deleteOrdemVendaPessoaFisica(@PathVariable("id") long id) {
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
