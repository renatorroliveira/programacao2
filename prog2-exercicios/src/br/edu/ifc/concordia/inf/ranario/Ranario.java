package br.edu.ifc.concordia.inf.ranario;

import java.util.*;

public class Ranario {
	private LinkedList<Ra> adultas = new LinkedList<Ra>();
	private LinkedList<Ra> filhotes = new LinkedList<Ra>();
	private int ovos = 0;
	private int maxAdultas = 200;
	private int maxFilhotes = 200;
	private int maxOvos = 200;
	
	public void addAdulta(int idade, double peso) {
		if (adultas.size() < maxAdultas) {
			Ra nova = new Ra(idade, peso);
			adultas.add(nova);
		}
	}
	public void addFilhote(int idade, double peso) {
		if (filhotes.size() < maxFilhotes) {
			Ra nova = new Ra(idade, peso);
			filhotes.add(nova);
		}
	}
	public void addOvo() {
		if (ovos < maxOvos) {
			ovos += 1;
		}
	}
	
	public void removeAdulta() {
		if (!adultas.isEmpty()) {
			adultas.remove(0);
		}
	}
	public void removeFilhote() {
		if (!filhotes.isEmpty()) {
			filhotes.remove(0);
		}
	}
	public void removeOvo() {
		if (ovos > 0) {
			ovos -= 1;
		}
	}
	
}
