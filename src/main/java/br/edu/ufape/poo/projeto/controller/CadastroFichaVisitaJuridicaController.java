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

import br.edu.ufape.poo.projeto.basica.FichaVisitaJuridica;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroFichaVisitaJuridicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("fichaVisitaJuridica")
	public FichaVisitaJuridica createFichaVisitaJuridica(@RequestBody FichaVisitaJuridica fichaVisitaJuridica) {
		return c.save(fichaVisitaJuridica);
	}

	@PutMapping("fichaVisitaJuridica/{fichaVisitaJuridica}")
	public FichaVisitaJuridica updateFichaVisitaJuridica(@PathVariable("fichaVisitaJuridica") FichaVisitaJuridica fichaVisitaJuridica) {
		return c.save(fichaVisitaJuridica);
	}

	@DeleteMapping("deleteFichaVisitaJuridica/{cnpj}")
	public void deleteFichaVisitaJuridica(@PathVariable("cnpj") String cnpj) { // @PathVariable poder ser usado para remover diretamente na URL
		c.deleteByCnpj(cnpj);
	}

	@GetMapping("allFichaVisitaJuridica")
	public List<FichaVisitaJuridica> findAllFichaVisitaJuridica() {
		return c.findAllFichaVisitaJuridica();
	}

}
