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

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
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
	public VeiculoUsado createVeiculoUsado(@RequestBody VeiculoUsado veiculo) throws ValorVazioExpection, ValorForaRangeException {
		return c.save(veiculo);
	}

	@PutMapping("VeiculoUsado")
	public VeiculoUsado updateVeiculoUsado(@RequestBody VeiculoUsado veiculo) throws ValorVazioExpection, ValorForaRangeException {
		return c.save(veiculo);
	}

	@DeleteMapping("deleteVeiculoUsado")
	public void deleteVeiculoUsado(@RequestBody VeiculoUsado veiculo) { // @PathVariable poder ser usado para remover
																		// diretamente na URL
		c.delete(veiculo);
	}

	@GetMapping("valorVeiculoUsado")
	public List<VeiculoUsado> findByValorVendaVeiculoUsado(@RequestBody float valorVenda) {
		return c.findByValorVendaVeiculoUsado(valorVenda);
	}

	@GetMapping("vendidoVeiculoUsado")
	public List<VeiculoUsado> findByVendidoVeiculoUsado(@RequestBody boolean vendido) {
		return c.findByVendidoVeiculoUsado(vendido);
	}

	@GetMapping("allVeiculoUsado")
	public List<VeiculoUsado> findAllVeiculoUsado() {
		return c.findAllVeiculoUsado();
	}

}
