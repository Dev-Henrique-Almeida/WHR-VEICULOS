package br.edu.ufape.poo.projeto.repositorio;
import br.edu.ufape.poo.projeto.basica.ClienteJuridico;
import java.util.ArrayList;
import java.util.List;

public class RepositorioClienteJuridicoArrayList implements RepositorioClienteJuridico {
	private List<ClienteJuridico> clientes;

	public RepositorioClienteJuridicoArrayList() {
		this.clientes = new ArrayList<ClienteJuridico>();
	}
	
	@Override
	public void adicionarClienteJuridico(ClienteJuridico c) {
		this.clientes.add(c);
	}
	
	@Override
	public ClienteJuridico procurarClienteJuridicoNome(String nome) {
		for(ClienteJuridico c: this.clientes) 
			if(c.getNomeEmpresarial().equals(nome))
				return c;
		return null;
	}
	
	@Override
	public ClienteJuridico procurarClienteJuridicoCnpj(String cnpj) {
		for(ClienteJuridico c: this.clientes) 
			if(c.getCnpj().equals(cnpj))
				return c;
		return null;
	}
	
	@Override
	public List<ClienteJuridico> listarClientesJuridico(){
		return this.clientes;
	}
	
	@Override
	public void atualizarClienteJuridico(ClienteJuridico c) {
		this.clientes.remove(c);
		this.clientes.add(c);
	}

	
}