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

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.DateForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroVeiculoUsadoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("VeiculoUsado")
	public ResponseEntity<VeiculoUsado> createVeiculoUsado(@RequestBody VeiculoUsado modelo)
			throws DateForaRangeException, ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {
		VeiculoUsado vn = c.save(modelo);
		return new ResponseEntity<VeiculoUsado>(vn, HttpStatus.CREATED);

	}

	@PutMapping("VeiculoUsado/{veiculo}")
	public VeiculoUsado updateVeiculoUsado(@PathVariable("veiculo") VeiculoUsado veiculo)
			throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {
		return c.save(veiculo);
	}

	@DeleteMapping("deleteVeiculoUsado/{veiculo}")
	public void deleteVeiculoUsado(@PathVariable("veiculo") VeiculoUsado veiculo) { // para remover diretamente na URL
		c.delete(veiculo);
	}

	@GetMapping("valorVeiculoUsado/{valorVenda}")
	public List<VeiculoUsado> findByValorVendaVeiculoUsado(@PathVariable("valorVenda") float valorVenda) {
		return c.findByValorVendaVeiculoUsado(valorVenda);
	}

	@GetMapping("idVeiculoUsado/{id}")
	public VeiculoUsado findByIdVeiculoUsado(@PathVariable("id") long id) {
		return c.findByIdVeiculoUsado(id);
	}

	@GetMapping("vendidoVeiculoUsado")
	public List<VeiculoUsado> findAllByVendidoUsado() {
		return c.findAllByVendidoUsado();
	}

	@GetMapping("allVeiculoUsado")
	public List<VeiculoUsado> findAllVeiculoUsado() {
		return c.findAllVeiculoUsado();
	}

}
