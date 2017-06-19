package br.edu.ifc.concordia.inf.agenda;

import java.util.LinkedList;
import java.util.List;

public class Contato {
	public String nome;
	public String sobrenome;
	public List<Email> emails;
	
	public Contato(String novoNome, String novoSobrenome) {
		emails = new LinkedList<Email>();
		this.nome = novoNome;
		this.sobrenome = novoSobrenome;
	}
}
