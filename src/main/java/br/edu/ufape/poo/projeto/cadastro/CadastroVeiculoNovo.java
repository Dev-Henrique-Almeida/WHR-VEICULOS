package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoNovo;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoNovo;

@Service
@Transactional
public class CadastroVeiculoNovo {

	@Autowired
	private RepositorioVeiculoNovo repositorioVeiculoNovo;

	public VeiculoNovo save(VeiculoNovo vn) {
		return repositorioVeiculoNovo.save(vn);
	}

	public void delete(VeiculoNovo entity) {
		repositorioVeiculoNovo.delete(entity);
	}

	// public void deleteByVeiculoNovo(VeiculoNovo veiculoNovo) {
	// repositorioVeiculoNovo.deleteByVeiculoNovo(veiculoNovo);
	// }

	public List<VeiculoNovo> findByValorVenda(float valorVenda) {
		return repositorioVeiculoNovo.findByValorVenda(valorVenda);
	}

	public List<VeiculoNovo> findByVendido(boolean vendido) {
		return repositorioVeiculoNovo.findByVendido(vendido);
	}

	public List<VeiculoNovo> findByGarantiaFabrica(boolean garantiaFabrica) {
		return repositorioVeiculoNovo.findByGarantiaFabrica(garantiaFabrica);
	}

	public List<VeiculoNovo> findAll() {
		return repositorioVeiculoNovo.findAll();
	}
}
