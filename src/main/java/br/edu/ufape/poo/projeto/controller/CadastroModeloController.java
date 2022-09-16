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

	@PutMapping("modelo")
	public Modelo updateModelo(@RequestBody Modelo modelo) throws ValorVazioExpection, ValorForaRangeException {
		return c.save(modelo);
	}

	@DeleteMapping("deleteModelo")
	public void deleteModelo(@RequestBody Modelo modelo) { // @PathVariable poder ser usado para remover diretamente na
															// URL
		c.delete(modelo);
	}

	@GetMapping("anoModelo")
	public List<Modelo> findByAnoFabricado(@RequestBody int anoFabricado) {
		return c.findByAnoFabricado(anoFabricado);
	}

	@GetMapping("nomeModelo")
	public List<Modelo> findByNomeModelo(@RequestBody String nomeModelo) {
		return c.findByNomeModelo(nomeModelo);
	}

	@GetMapping("idModelo")
	public List<Modelo> findById(@RequestBody long id) {
		return c.findById(id);
	}

	@GetMapping("allModelo")
	public List<Modelo> findAllModelo() {
		return c.findAllModelo();
	}

}
