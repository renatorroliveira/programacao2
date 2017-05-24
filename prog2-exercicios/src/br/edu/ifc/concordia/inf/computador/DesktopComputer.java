package br.edu.ifc.concordia.inf.computador;

public class DesktopComputer implements Computer {
	
	private USBDevice[] usbSlots = new USBDevice[4];
	private Monitor monitor;
	
	@Override
	public void connect(USBDevice device, int slot) {
		if (slot < 0 || slot >= usbSlots.length) {
			throw new IllegalArgumentException("Slot inválido.");
		}
		usbSlots[slot] = device;
	}

	@Override
	public void plugMonitor(Monitor monitor) {
		this.monitor = monitor;
	}

}
