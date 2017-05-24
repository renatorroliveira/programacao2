package br.edu.ifc.concordia.inf;

import java.util.LinkedList;
import java.util.List;

public class Prova1 {
	public boolean questao3(int[][] matriz) {
		List<Integer> lista = new LinkedList<Integer>();
		for (int[] linha : matriz) {
			for (int elemento : linha) {
				if (lista.contains(elemento)) {
					return true;
				} else {
					lista.add(elemento);
				}
			}
		}
		return false;
	}
	
	public void questao4(int[] array) {
		int menor, segundoMenor;
		menor = segundoMenor = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < menor) {
				segundoMenor = menor;
				menor = array[i];
			} else if (array[i] < segundoMenor) {
				segundoMenor = array[i];
			}
		}
		System.out.printf("Menor: %d\nSegundoMenor: %d\n",
				menor, segundoMenor);
	}

}
