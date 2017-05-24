package br.edu.ifc.concordia.inf.ranario;

import java.util.LinkedList;

public class Empresa {
	private LinkedList<Ranario> ranarios = new LinkedList<Ranario>();
	private double dinheiro = 100000;
	private int funcionarios = 50;
	
	public void compra(int ras, double total) {
		dinheiro -= total;
	}
	public void venda(int ras, double total) {
		dinheiro += total;
	}
}
