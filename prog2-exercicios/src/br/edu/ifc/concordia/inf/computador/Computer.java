package br.edu.ifc.concordia.inf.computador;

public interface Computer {

	public void connect(USBDevice device, int slot);
	public void plugMonitor(Monitor monitor);
}
