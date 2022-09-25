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

import br.edu.ufape.poo.projeto.basica.Modelo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.NomeUnicoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroModeloController {

	@Autowired
	private Concessionaria c;

	@PostMapping("modelo")
	public ResponseEntity<Modelo> createModelo(@RequestBody Modelo modelo)
			throws ValorNuloExpection, ValorForaRangeException, NomeUnicoException {
		Modelo m = c.save(modelo);
		return new ResponseEntity<Modelo>(m, HttpStatus.CREATED);

	}

	@PutMapping("updateModelo/{id}")
	public ResponseEntity<Modelo> updateModelo(@PathVariable("id") long id, @RequestBody Modelo modelo) {
		if (id == modelo.getId()) {
			return new ResponseEntity<Modelo>(c.update(modelo), HttpStatus.OK);
		} else {
			return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteModelo/{id}")
	public ResponseEntity<HttpStatus> deleteByIdModelo(@PathVariable("id") long id) {
		c.deleteByIdModelo(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("anoModelo/{anoFabricado}")
	public ResponseEntity<List<Modelo>> findByAnoFabricado(@PathVariable("anoFabricado") int anoFabricado) {
		if(c.findByAnoFabricado(anoFabricado) != null) {
			return new ResponseEntity<List<Modelo>>(c.findByAnoFabricado(anoFabricado), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Modelo>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("idModelo/{id}")
	public ResponseEntity<Modelo> findById(@PathVariable("id") long id) {
		if(c.findById(id) != null) {
			return new ResponseEntity<Modelo>(c.findById(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<Modelo>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("nomeModelo/{nomeModelo}")
	public ResponseEntity<List<Modelo>> findByNomeModelo(@PathVariable("nomeModelo") String nomeModelo) {
		if(c.findByNomeModelo(nomeModelo) != null) {
			return new ResponseEntity<List<Modelo>>(c.findByNomeModelo(nomeModelo), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<Modelo>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/allModelo")
	public ResponseEntity<List<Modelo>> findAllModelo() {
		return new ResponseEntity<List<Modelo>>(c.findAllModelo(), HttpStatus.OK);
	}
	

}
