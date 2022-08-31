package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.ClienteFisico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteFisicoArrayList implements RepositorioClienteFisico {
	private List<ClienteFisico> clientes;

	public RepositorioClienteFisicoArrayList() {
		this.clientes = new ArrayList<ClienteFisico>();
	}
	
	@Override
	public void adicionarClienteFisico(ClienteFisico c) {
		this.clientes.add(c);
	}
	
	@Override
	public ClienteFisico procurarClienteFisicoNome(String nome) {
		for(ClienteFisico c: this.clientes) 
			//if(c.getNome().equals(nome))
				return c;
		return null;
	}
	
	@Override
	public ClienteFisico procurarClienteFisicoCpf(String cpf) {
		for(ClienteFisico c: this.clientes) 
			if(c.getCpf().equals(cpf))
				return c;
		return null;
	}
	
	@Override
	public List<ClienteFisico> listarClientesFisico(){
		return this.clientes;
	}
	
	@Override
	public void atualizarClienteFisico(ClienteFisico c) {
		this.clientes.remove(c);
		this.clientes.add(c);
	}
	
	
}