package br.edu.ufape.poo.projeto.basica;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class ClienteFisico extends Pessoa {
	
	//private String idCompras[];

	public ClienteFisico(String cpf, String nome, Date dataNascimento, 
			String telefone, long id, Endereco endereco) {
		super(cpf, nome, dataNascimento, telefone, id, endereco);
		//this.idCompras = new idCompras[];
		
	}
	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}
	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteFisico other = (ClienteFisico) obj;
		return getId() == other.getId();
	}
	
	@Override
	public String toString() {
		return "ClienteFisico [getId()=" + getId() + ", getCpf()=" + getCpf()+ ", getNome()=" + getNome() + ", getEndereco()=" + getEndereco() + ", getDataNascimento()="
				+ getDataNascimento() + ", getTelefone()=" + getTelefone()+ "]";
	}
	
}
