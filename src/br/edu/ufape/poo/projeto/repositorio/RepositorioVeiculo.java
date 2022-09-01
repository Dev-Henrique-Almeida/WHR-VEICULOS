package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.Veiculo;
import br.edu.ufape.poo.projeto.basica.Modelo;

import java.util.Date;
import java.util.List;

public interface RepositorioVeiculo {
	public void adicionarVeiculo(Veiculo v);
	public Veiculo procurarModeloVeiculo(String modelo);
	public float procurarVeiculoEntre(float a, float b);
	public void removerVeiculo(Veiculo v);
	public Veiculo consultarVeiuclo (Veiculo [] veiculos);
	public void agendarVisita ( Veiculo v, Date d);
	public List<Veiculo> listarVeiculosNovos();
	public List<Veiculo> listarVeiculosUsados();
	public List<Modelo> listarModelos();
	public List<Veiculo> findByModelo(Modelo modelo);
	
	
}
