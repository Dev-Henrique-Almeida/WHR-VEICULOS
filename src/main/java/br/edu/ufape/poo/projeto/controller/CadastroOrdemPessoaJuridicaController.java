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
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroOrdemPessoaJuridicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("ordemJuridico")
	public OrdemVendaPessoaFisica createOrdemPessoaJuridica(@RequestBody OrdemVendaPessoaFisica entity) {
		return c.save(entity);
	}

	@PutMapping("ordemJuridico")
	public OrdemVendaPessoaFisica updateOrdemPessoaJuridica(@RequestBody OrdemVendaPessoaFisica cliente){
		return c.save(cliente);
	}
		
	@DeleteMapping("deleteOrdemJuridico")
	public void deleteOrdemPessoaJuridica(@RequestBody long id) {  // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByIdOrdemJuridico(id);
	}
	
	@GetMapping("idOrdemJuridico")
	public OrdemVendaPessoaJuridica findByIdOrdemFisica(@RequestBody long id) {
		return c.findByIdOrdemJuridico(id);
	}
	
	@GetMapping("pagoOrdemJuridico")
	public List<OrdemVendaPessoaJuridica> findByPagoOrdemFisica(@RequestBody boolean pago) {
		return c.findByPagoOrdemJuridico(pago);
	}
	
	@GetMapping("allOrdemJuridico")
	public List<OrdemVendaPessoaJuridica> findAllOrdemFisica() {
		return c.findAllOrdemJuridico();
	}
	


	
}
