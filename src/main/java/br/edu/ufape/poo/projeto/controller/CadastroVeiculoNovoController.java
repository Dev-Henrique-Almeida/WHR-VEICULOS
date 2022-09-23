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

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ChassiExistenteException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorForaRangeException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNegativoException;
import br.edu.ufape.poo.projeto.cadastro.exceptions.ValorNuloExpection;
import br.edu.ufape.poo.projeto.fachada.Concessionaria;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/whr/api/v1")
public class CadastroVeiculoNovoController {

	@Autowired
	private Concessionaria c;

	@PostMapping("veiculoNovo")
	public ResponseEntity<VeiculoNovo> createVeiculoNovo(@RequestBody VeiculoNovo modelo)
			throws ValorNuloExpection, ValorForaRangeException, ChassiExistenteException, ValorNegativoException {
		VeiculoNovo vn = c.save(modelo);
		return new ResponseEntity<VeiculoNovo>(vn, HttpStatus.CREATED);

	}

	@PutMapping("updateVeiculoNovo/{id}")
	public ResponseEntity<VeiculoNovo> updateVeiculoNovo(@PathVariable("id") long id,
			@RequestBody VeiculoNovo veiculoNovo) {
		if (id == veiculoNovo.getId()) {
			return new ResponseEntity<VeiculoNovo>(c.update(veiculoNovo), HttpStatus.OK);
		} else {
			return new ResponseEntity<VeiculoNovo>(HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("deleteVeiculoNovo/{id}")
	public void deleteByIdVeiculoNovo(@PathVariable("id") long id) {
		c.deleteByIdVeiculoNovo(id);
	}

	@DeleteMapping("deleteVeiculoNovo")
	public void deleteVeiculoNovo(@RequestBody VeiculoNovo veiculo) {
		c.delete(veiculo);
	}

	@GetMapping("valorVeiculoNovo/{valorVenda}")
	public List<VeiculoNovo> findByValorVendaVeiculoNovo(@PathVariable("valorVenda") float valorVenda) {
		return c.findByValorVendaVeiculoNovo(valorVenda);
	}

	@GetMapping("idVeiculoNovo/{id}")
	public VeiculoNovo findByIdVeiculoNovo(@PathVariable("id") long id) {
		return c.findByIdVeiculoNovo(id);
	}

	@GetMapping("vendidoVeiculoNovo")
	public List<VeiculoNovo> findAllByVendidoVeiculoNovo() {
		return c.findAllByVendidoVeiculoNovo();
	}

	@GetMapping("garantiaVeiculoNovo/{garantiaFabrica}")
	public List<VeiculoNovo> findByGarantiaFabricaVeiculoNovo(
			@PathVariable("garantiaFabrica") boolean garantiaFabrica) {
		return c.findByGarantiaFabricaVeiculoNovo(garantiaFabrica);
	}

	@GetMapping("allVeiculoNovo")
	public List<VeiculoNovo> findAllVeiculoNovo() {
		return c.findAllVeiculoNovo();
	}

}
