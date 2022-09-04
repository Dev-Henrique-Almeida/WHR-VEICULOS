package br.edu.ufape.poo.projeto.basica;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class ClienteFisico extends Pessoa {
	
	private String idCompras[];

	public ClienteFisico(String cpf, String nome, Date dataNascimento, 
			String telefone, long id, Endereco endereco) {
		super(cpf, nome, dataNascimento, telefone, id, endereco);
		//this.idCompras = new idCompras[];
		
	}
	

	
	
}
