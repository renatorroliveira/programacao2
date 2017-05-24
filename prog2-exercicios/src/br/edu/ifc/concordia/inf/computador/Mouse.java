package br.edu.ifc.concordia.inf.computador;

public interface Mouse {
	public boolean isOptical();
	public int getNumberOfButtons();
	public int getX();
	public int getY();
	public void click(int index);
	public void move(int x, int y);
}
