package IOMainApp;

import iowithplugins.abstractions.*;

public class IOMainApp {

	public static void main(String[] args) {
	
		
		PluginsManager manager = new PluginsManager();
		try
		{
			manager.loadPlugins("/plugins");
		}
		catch(Exception e)
		{
			System.out.println("Modulele nu pot fi incarcate. " + e.getMessage());
		}
		
		if (manager.getPluginsList().size() > 0)
		{
			IIOPlugin selectedPlugin = manager.getPluginsList().get(0);				
			
			IInputDevice inputDevice = selectedPlugin.getInputDevice();
			IOutputDevice outputDevice = selectedPlugin.getOutputDevice();;
			
			String readData = inputDevice.ReadString();
			outputDevice.WriteString(readData);
		}
		else
		{
			System.out.println("Nu exista module compatibile");
		}
	}

}
