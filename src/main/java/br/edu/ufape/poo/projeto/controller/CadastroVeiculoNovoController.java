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

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorVazioExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroVeiculoNovoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("veiculoNovo")
	public VeiculoNovo createVeiculoNovo(@RequestBody VeiculoNovo veiculo)
			throws ValorVazioExpection, ValorForaRangeException {
		return c.save(veiculo);
	}

	@PutMapping("veiculoNovo")
	public VeiculoNovo updateVeiculoNovo(@RequestBody VeiculoNovo veiculo)
			throws ValorVazioExpection, ValorForaRangeException {
		return c.save(veiculo);
	}

	@DeleteMapping("deleteVeiculoNovo")
	public void deleteVeiculoNovo(@RequestBody VeiculoNovo veiculo) { // @PathVariable poder ser usado para remover
																		// diretamente na URL
		c.delete(veiculo);
	}

	@GetMapping("valorVeiculoNovo")
	public List<VeiculoNovo> findByValorVendaVeiculoNovo(@RequestBody float valorVenda) {
		return c.findByValorVendaVeiculoNovo(valorVenda);
	}

	@GetMapping("vendidoVeiculoNovo")
	public List<VeiculoNovo> findByVendidoVeiculoNovo(@RequestBody boolean vendido) {
		return c.findByVendidoVeiculoNovo(vendido);
	}

	@GetMapping("garantiaVeiculoNovo")
	public List<VeiculoNovo> findByGarantiaFabricaVeiculoNovo(@RequestBody boolean garantiaFabrica) {
		return c.findByGarantiaFabricaVeiculoNovo(garantiaFabrica);
	}

	@GetMapping("allVeiculoNovo")
	public List<VeiculoNovo> findAllVeiculoNovo() {
		return c.findAllVeiculoNovo();
	}

}
