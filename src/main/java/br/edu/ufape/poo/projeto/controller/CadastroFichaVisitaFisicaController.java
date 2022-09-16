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

import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroFichaVisitaFisicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("fichaVisitaFisica")
	public FichaVisitaFisica createFichaVisitaFisica(@RequestBody FichaVisitaFisica fichaVisitaFisica) {
		return c.save(fichaVisitaFisica);
	}

	@PutMapping("fichaVisitaFisica")
	public FichaVisitaFisica updateFichaVisitaFisica(@RequestBody FichaVisitaFisica fichaVisitaFisica) {
		return c.save(fichaVisitaFisica);
	}

	@DeleteMapping("deleteFichaVisitaFisica")
	public void deleteFichaVisitaFisica(@RequestBody String cpf) { // @PathVariable poder ser usado para remover
																	// diretamente na URL
		c.deleteByCpf(cpf);
	}

	@GetMapping("allFichaVisitaFisica")
	public List<FichaVisitaFisica> findAllFichaVisitaFisica() {
		return c.findAllFichaVisitaFisica();
	}

}
