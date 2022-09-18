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

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
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
	public VeiculoUsado createVeiculoUsado(@RequestBody VeiculoUsado veiculo)
			throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {
		return c.save(veiculo);
	}

	@PutMapping("VeiculoUsado/{veiculo}")
	public VeiculoUsado updateVeiculoUsado(@PathVariable("veiculo") VeiculoUsado veiculo)
			throws ValorVazioExpection, ValorForaRangeException, ChassiExistenteException {
		return c.save(veiculo);
	}

	@DeleteMapping("deleteVeiculoUsado/{veiculo}")
	public void deleteVeiculoUsado(@PathVariable("veiculo") VeiculoUsado veiculo) { // @PathVariable poder ser usado para remover diretamente na URL
		c.delete(veiculo);
	}

	@GetMapping("valorVeiculoUsado/{valorVenda}")
	public List<VeiculoUsado> findByValorVendaVeiculoUsado(@PathVariable("valorVenda") float valorVenda) {
		return c.findByValorVendaVeiculoUsado(valorVenda);
	}

	@GetMapping("vendidoVeiculoUsado/{vendido}")
	public List<VeiculoUsado> findByVendidoVeiculoUsado(@PathVariable("vendido") boolean vendido) {
		return c.findByVendidoVeiculoUsado(vendido);
	}

	@GetMapping("allVeiculoUsado")
	public List<VeiculoUsado> findAllVeiculoUsado() {
		return c.findAllVeiculoUsado();
	}

}
