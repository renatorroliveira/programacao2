package br.edu.ifc.concordia.inf.computador;

public abstract class Mouse2D implements Mouse {

	protected int x;
	protected int y;

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public void move(int x, int y) {
		if (this.x + x < 0) {
			this.x = 0;
		} else {
			this.x += x;
		}
		if (this.y + y < 0) {
			this.y = 0;
		} else {
			this.y += y;
		}
	}

}
