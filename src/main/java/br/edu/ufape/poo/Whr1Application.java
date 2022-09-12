package br.edu.ufape.poo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Whr1Application { // implements CommandLineRunner

	public static void main(String[] args) {
		SpringApplication.run(Whr1Application.class, args);
	}

	/*
	 * @Autowired private CadastroClienteFisico ccf;
	 * 
	 * 
	 * @Override public void run(String... args) throws Exception { try {
	 * ClienteFisico cf = new ClienteFisico("123454", "Will", null, null, new
	 * Endereco(null, null, "Garanhuns", null, 0)); ccf.save(cf);
	 * }catch(ClienteFisicoExistenteException e) {
	 * System.out.println("Erro ao salvar, " + e.getMessage()); }
	 * 
	 * 
	 * try { ClienteFisico cf2 = new ClienteFisico("12931", "Henrique", null, null,
	 * new Endereco(null, null, "Cachoeirinha", null, 0)); ccf.save(cf2);
	 * }catch(ClienteFisicoExistenteException e) {
	 * System.out.println("Erro ao salvar, " + e.getMessage()); }
	 * 
	 * 
	 * 
	 * try { ClienteFisico cf3 = new ClienteFisico("123", "Robert", null, null, new
	 * Endereco(null, null, "Arcoverde", null, 0)); ccf.save(cf3);
	 * }catch(ClienteFisicoExistenteException e) {
	 * System.out.println("Erro ao salvar, " + e.getMessage()); } }
	 */
}
