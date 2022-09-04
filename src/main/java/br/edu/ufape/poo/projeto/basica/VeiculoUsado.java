package br.edu.ufape.poo.projeto.basica;

import javax.persistence.Entity;

@Entity
public class VeiculoUsado extends Veiculo {
	private String km;
	private boolean revisado;
	private boolean unicoDono;

	public VeiculoUsado(float valorCompraVeiculo, float valorVenda, boolean vendido, Modelo modelo, long id, String km,
			boolean revisado, boolean unicoDono) {
		super(valorCompraVeiculo, valorVenda, vendido, modelo, id);
		this.km = km;
		this.revisado = revisado;
		this.unicoDono = unicoDono;
	}
	

	

	

}
