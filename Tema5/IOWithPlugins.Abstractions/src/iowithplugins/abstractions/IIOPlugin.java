package iowithplugins.abstractions;

public interface IIOPlugin {

	String getPluginName();
	IOutputDevice getOutputDevice();
	IInputDevice getInputDevice();
}
