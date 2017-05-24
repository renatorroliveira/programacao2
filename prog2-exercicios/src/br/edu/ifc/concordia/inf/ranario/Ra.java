package br.edu.ifc.concordia.inf.ranario;

public class Ra {
	private int idade;
	private double peso;
	
	public Ra(int idade, double peso) {
		this.idade = idade;
		this.peso = peso;
	}
	public Ra() {
		this.idade = 1;
		this.peso = 0.5;
	}
	
	public void crescimento() {
		idade += 1;
		peso = peso * 1.05;
	}
	
	public int getIdade() {
		return idade;
	}
	public double getPeso() {
		return peso;
	}
}
