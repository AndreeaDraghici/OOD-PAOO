package standardioplugin;

import iowithplugins.abstractions.IOutputDevice;

public class StdOutputDevice implements IOutputDevice {

	@Override
	public void WriteString(String s) {
		System.out.println(s);
	}

}
