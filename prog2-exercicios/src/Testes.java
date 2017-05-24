import br.edu.ifc.concordia.inf.computador.Computer;
import br.edu.ifc.concordia.inf.computador.DesktopComputer;
import br.edu.ifc.concordia.inf.computador.LG29UM58;
import br.edu.ifc.concordia.inf.computador.Monitor;
import br.edu.ifc.concordia.inf.computador.OpticalMouse;
import br.edu.ifc.concordia.inf.computador.USBMouse;

public class Testes {
	public static void main(String[] args) {
		USBMouse meuMouse = new OpticalMouse();
		Monitor meuMonitor = new LG29UM58();
		Computer meuPc = new DesktopComputer();
		meuPc.connect(meuMouse, 0);
		meuPc.plugMonitor(meuMonitor);
	}
}
