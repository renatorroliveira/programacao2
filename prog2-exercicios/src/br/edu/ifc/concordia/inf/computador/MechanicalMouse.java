package br.edu.ifc.concordia.inf.computador;

public class MechanicalMouse extends Mouse2D implements USBMouse {

	@Override
	public boolean isOptical() {
		return false;
	}

	@Override
	public int getNumberOfButtons() {
		return 3;
	}

	@Override
	public void click(int index) {
		// TODO Auto-generated method stub
		
	}

}
