package fileioplugin;

import iowithplugins.abstractions.IIOPlugin;
import iowithplugins.abstractions.IInputDevice;
import iowithplugins.abstractions.IOutputDevice;

public class FileIOPlugin implements IIOPlugin{
	
	@Override
	public String getPluginName() {
		return "FileIO" ;
	} 

	@Override
	public IOutputDevice getOutputDevice() {
		return new FileOutputDevice();
	}

	@Override
	public IInputDevice getInputDevice() {
		return new FileInputDevice();
	}
}
