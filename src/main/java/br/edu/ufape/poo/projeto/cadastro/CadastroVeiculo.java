package br.edu.ufape.poo.projeto.cadastro;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.repositorio.RepositorioVeiculo;


@Service
public class CadastroVeiculo {

	@Autowired
	private RepositorioVeiculo repositorioveiculo;
	
	public Veiculo save(Veiculo entity) {
		return repositorioveiculo.save(entity);
	}

	public void delete(Veiculo entity) {
			repositorioveiculo.delete(entity);
	}

	public List<Veiculo> findAll() {
		return repositorioveiculo.findAll();
	}
	
	/*
	public List<Veiculo> findByModelo(Modelo modelo) {
		return repositorioveiculo.findByModelo(modelo);
	}
	
		
	public Veiculo findByVeiculo(Veiculo veiculo) {
		return repositorioveiculo.findByVeiculo(veiculo);
	}
	
	
	
	public Veiculo findByVeiculoEntre(float a, float b) {
		return repositorioveiculo.findByVeiculoEntre(a,b);
	}
	
	public List<Veiculo> findAllVeiculoUsado() {
		return repositorioveiculo.findAllVeiculoUsado();
	}
	
	public List<Veiculo> findAllVeiculoNovo() {
		return repositorioveiculo.findAllVeiculoNovo();
	}
	
	public List<Modelo> findAllModelo() {
		return repositorioveiculo.findAllModelo();
	}

	*/
	
	
	
	
}
