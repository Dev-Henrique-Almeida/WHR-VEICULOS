package br.edu.ufape.poo.projeto.cadastro;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.VeiculoUsado;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculoUsado;

@Service
public class CadastroVeiculoUsado {
	
	@Autowired
	private RepositorioVeiculoUsado repositorioVeiculoUsado;

	public VeiculoUsado save(VeiculoUsado vn) {
		return repositorioVeiculoUsado.save(vn);
	}

	public void delete(VeiculoUsado entity) {
		repositorioVeiculoUsado.delete(entity);
	}
	
	public List<VeiculoUsado> findByValorVenda(float valorVenda){
		return repositorioVeiculoUsado.findByValorVenda(valorVenda);
	}
	
	public List<VeiculoUsado> findByVendido(boolean vendido){
		return repositorioVeiculoUsado.findByVendido(vendido);
	}

	public List<VeiculoUsado> findAll() {
		return repositorioVeiculoUsado.findAll();
	}
	
	
}
