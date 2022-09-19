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

import br.edu.ufape.poo.projeto.basica.FichaVisitaFisica;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroFichaVisitaFisicaController {

	@Autowired
	private Concessionaria c;

	@PostMapping("fichaVisitaFisica")
	public ResponseEntity<FichaVisitaFisica> createFichaVisitaFisica(@RequestBody FichaVisitaFisica ficha)
			throws DateForaRangeException, ValorVazioExpection, ValorForaRangeException {
		FichaVisitaFisica fvf = c.save(ficha);
		return new ResponseEntity<FichaVisitaFisica>(fvf, HttpStatus.CREATED);

	}

	@PutMapping("fichaVisitaFisica/{fichaVisitaFisica}")
	public FichaVisitaFisica updateFichaVisitaFisica(
			@PathVariable("fichaVisitaFisica") FichaVisitaFisica fichaVisitaFisica) {
		return c.save(fichaVisitaFisica);
	}

	@DeleteMapping("deleteFichaVisitaFisica/{cpf}")
	public void deleteFichaVisitaFisica(@PathVariable("cpf") String cpf) {
		c.deleteByCpf(cpf);
	}

	@GetMapping("allFichaVisitaFisica")
	public List<FichaVisitaFisica> findAllFichaVisitaFisica() {
		return c.findAllFichaVisitaFisica();
	}

}
