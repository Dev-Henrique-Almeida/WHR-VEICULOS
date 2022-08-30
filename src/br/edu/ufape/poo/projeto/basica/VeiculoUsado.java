package br.edu.ufape.poo.projeto.basica;

public class VeiculoUsado extends Veiculo {
	private String km;
	private boolean revisado;
	private boolean unicoDono;
	
	public VeiculoUsado(float valorCompraVeiculo,float valorVenda, boolean vendido,
			Modelo modelo, String km,
			boolean revisado, boolean unicoDono) {
		
		super(valorCompraVeiculo,valorVenda, vendido,
				 modelo);
		this.km = km;
		this.revisado = revisado;
		this.unicoDono = unicoDono;
	}
	
	

	

}
