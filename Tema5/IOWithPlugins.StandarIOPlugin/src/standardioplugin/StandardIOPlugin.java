package standardioplugin;

import iowithplugins.abstractions.IIOPlugin;
import iowithplugins.abstractions.IInputDevice;
import iowithplugins.abstractions.IOutputDevice;

public class StandardIOPlugin implements IIOPlugin{

	@Override
	public String getPluginName() {
		return "StandardIO";
	}

	@Override
	public IOutputDevice getOutputDevice() {
		// TODO Auto-generated method stub
		return new StdOutputDevice();
	}

	@Override
	public IInputDevice getInputDevice() {
		// TODO Auto-generated method stub
		return new StdInputDevice();
	}

}
