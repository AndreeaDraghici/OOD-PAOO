package standardioplugin;

import java.util.Scanner;

import iowithplugins.abstractions.IInputDevice;

public class StdInputDevice implements IInputDevice {

	Scanner consoleScanner = new Scanner(System.in);
	@Override
	public String ReadString() {
		return consoleScanner.nextLine();
	}

}
