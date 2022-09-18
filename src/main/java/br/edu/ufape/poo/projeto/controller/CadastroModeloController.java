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

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroModeloController {

	@Autowired
	private Concessionaria c;

	@PostMapping("modelo")
	public Modelo createModelo(@RequestBody Modelo modelo) throws ValorVazioExpection, ValorForaRangeException {
		return c.save(modelo);
	}

	@PutMapping("modelo/{modelo}")
	public Modelo updateModelo(@PathVariable("modelo") Modelo modelo) throws ValorVazioExpection, ValorForaRangeException {
		return c.save(modelo);
	}

	@DeleteMapping("deleteModelo/{modelo}")
	public void deleteModelo(@PathVariable("modelo") Modelo modelo) { // @PathVariable poder ser usado para remover diretamente na // URL
		c.delete(modelo);
	}

	@GetMapping("anoModelo/{anoFabricado}")
	public List<Modelo> findByAnoFabricado(@PathVariable("anoFabricado") int anoFabricado) {
		return c.findByAnoFabricado(anoFabricado);
	}


	@GetMapping("idModelo/{id}")
	public Modelo findById(@PathVariable("id") long id) {
		return c.findById(id);
	}
	
	@GetMapping("nomeModelo/{nomeModelo}")
	public List<Modelo> findByNomeModelo(@PathVariable("nomeModelo") String nomeModelo) {
		return c.findByNomeModelo(nomeModelo);
	}

	@GetMapping("/allModelo")
	public List<Modelo> findAllModelo() {
		return c.findAllModelo();
	}

}
