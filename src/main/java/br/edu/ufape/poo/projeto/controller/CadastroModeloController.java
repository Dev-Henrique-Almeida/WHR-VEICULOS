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
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroModeloController {

	@Autowired
	private Concessionaria c;

	@PostMapping("modelo")
	public Modelo createModelo(@RequestBody Modelo modelo){
		return c.save(modelo);
	}

	@PutMapping("modelo")
	public Modelo updateModelo(@RequestBody Modelo modelo){
		return c.save(modelo);
	}
		
	@DeleteMapping("deleteModelo")
	public void deleteModelo(@RequestBody Modelo modelo) {  // @PathVariable poder ser usado para remover diretamente na URL
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
	
	@GetMapping("allModelo")
	public List<Modelo> findAllModelo() {
		return c.findAllModelo();
	}

}
