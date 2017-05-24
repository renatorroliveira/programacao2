package br.edu.ifc.concordia.inf;

public class CaixaDagua {

	double capacidade = 20000;
	double agua = 0;
	double sujeira = 0;
	
	public void encher(double litros) {
		if (agua + litros > capacidade) {
			agua = capacidade;
		} else {
			agua = agua + litros;
		}
		sujeira += litros * 1.5;
	}
	
	public void retirar(double litros) {
		double retirada;
		if (agua - litros < 0) {
			retirada = agua;
			agua = 0;
		} else {
			retirada = litros;
			agua = agua - litros;
		}
		sujeira -= retirada * 0.4;
	}
	
	public void esvaziar() {
		sujeira -= agua * 0.4;
		agua = 0;
	}
	
	public void limpar() {
		if (agua == 0) {
			sujeira = sujeira * 0.05;
		}
	}
}
