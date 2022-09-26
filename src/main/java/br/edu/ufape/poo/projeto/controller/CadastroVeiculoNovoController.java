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
	public ResponseEntity<HttpStatus> deleteByIdVeiculoNovo(@PathVariable("id") long id) {
		c.deleteByIdVeiculoNovo(id);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@DeleteMapping("deleteVeiculoNovo")
	public ResponseEntity<HttpStatus> deleteVeiculoNovo(@RequestBody VeiculoNovo veiculo) {
		c.delete(veiculo);
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}

	@GetMapping("valorVeiculoNovo/{valorVenda}")
	public ResponseEntity<List<VeiculoNovo>> findByValorVendaVeiculoNovo(@PathVariable("valorVenda") float valorVenda) {
		if (c.findByValorVendaVeiculoNovo(valorVenda) != null) {
			return new ResponseEntity<List<VeiculoNovo>>(c.findByValorVendaVeiculoNovo(valorVenda), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<VeiculoNovo>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("idVeiculoNovo/{id}")
	public ResponseEntity<VeiculoNovo> findByIdVeiculoNovo(@PathVariable("id") long id) {
		if (c.findAllByVendidoVeiculoNovo() != null) {
			return new ResponseEntity<VeiculoNovo>(c.findByIdVeiculoNovo(id), HttpStatus.OK);
		} else {
			return new ResponseEntity<VeiculoNovo>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("AllVeiculoNovoVendido")
	public ResponseEntity<List<VeiculoNovo>> findAllByVendidoVeiculoNovo() {
		if (c.findAllByVendidoVeiculoNovo() != null) {
			return new ResponseEntity<List<VeiculoNovo>>(c.findAllByVendidoVeiculoNovo(), HttpStatus.OK);
		} else {
			return new ResponseEntity<List<VeiculoNovo>>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("garantiaVeiculoNovo/{garantiaFabrica}")
	public ResponseEntity<List<VeiculoNovo>> findByGarantiaFabricaVeiculoNovo(
			@PathVariable("garantiaFabrica") String garantiaFabrica) {
		if (c.findByGarantiaFabricaVeiculoNovo(garantiaFabrica) != null) {
			return new ResponseEntity<List<VeiculoNovo>>(c.findByGarantiaFabricaVeiculoNovo(garantiaFabrica),
					HttpStatus.OK);
		} else {
			return new ResponseEntity<List<VeiculoNovo>>(HttpStatus.NOT_FOUND);
		}

	}

	@GetMapping("allVeiculoNovo")
	public ResponseEntity<List<VeiculoNovo>> findAllVeiculoNovo() {
		return new ResponseEntity<List<VeiculoNovo>>(c.findAllVeiculoNovo(), HttpStatus.OK);
	}

}
