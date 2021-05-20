package plugins;
import plugins.interfaces.IPluginsAppPlugin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

@SuppressWarnings("unused")
public class PluginManager {
	 @SuppressWarnings({ "unchecked", "rawtypes" })
	private ArrayList<IPluginsAppPlugin> pluginsList = new ArrayList();
	    
	    @SuppressWarnings("unchecked")
		private IPluginsAppPlugin loadPlugin(File jarFile)
	    {
	        IPluginsAppPlugin retPlugin = null;
	        try
	        {    
	            var currentLoader = this.getClass().getClassLoader();           
	            System.out.println("Looking for plugins in: " + jarFile.getAbsolutePath());
	            System.out.println("current path" + Paths.get("").toAbsolutePath().toString());
	            URI jarURI = jarFile.toURI();            
	            ClassLoader loader = URLClassLoader.newInstance(new URL[]{ jarURI.toURL()}, currentLoader);
	            List<String> classesInJar = getJARClasses(jarFile.getAbsolutePath());
	            for(String currentClassName : classesInJar)
	            {
	                System.out.println("Checking class: " + currentClassName);
	                @SuppressWarnings("rawtypes")
					Class currentClass = Class.forName(currentClassName, true, loader);
	                //if the class implements our plugin interface
	                if (!currentClass.isInterface() && IPluginsAppPlugin.class.isAssignableFrom(currentClass))
	                {
	                    System.out.println("Seems like class " + currentClassName + " is a plugin");
	                    //we create an instance for the plugin
	                    retPlugin = (IPluginsAppPlugin)currentClass.getConstructor().newInstance();
	                    break;
	                }                    
	            }

	        }
	        catch(Exception  e)
	        {
	            retPlugin = null;
	            System.out.println("Failed to load plugin from: " + jarFile.getAbsolutePath() + "; " + e.getMessage());
	        }
	        return retPlugin;
	    }
	    
	    private List<String> getJARClasses(String jarPath) throws FileNotFoundException, IOException
	    {
	        @SuppressWarnings({ "rawtypes", "unchecked" })
			List<String> classNames = new ArrayList();
	        @SuppressWarnings("resource")
			ZipInputStream zip = new ZipInputStream(new FileInputStream(jarPath));
	        for (ZipEntry entry = zip.getNextEntry(); entry != null; entry = zip.getNextEntry()) 
	        {
	            if (!entry.isDirectory() && entry.getName().endsWith(".class")) 
	            {            
	                String className = entry.getName().replace('/', '.'); // including ".class"
	                classNames.add(className.substring(0, className.length() - ".class".length()));
	            }
	        }
	        
	        return classNames;
	    }
	    
	    
	    public void loadPlugins(String directory)
	    {
	        File pluginsDir = new File(System.getProperty("user.dir") + directory);
	        FilenameFilter fileFilter = new FilenameFilter(){
	            @Override
	            public boolean accept(File dir, String name) 
	            {
	                if (name.endsWith(".jar"))
	                    return true;
	                return false;
	            }
	        };
	        
	        
	        for (File jar : pluginsDir.listFiles(fileFilter)) 
	        {
	           IPluginsAppPlugin plugin = loadPlugin(jar);
	           if (plugin != null)
	           {
	                pluginsList.add(plugin);
	           }            
	        }
	    }
	    
	    public ArrayList<IPluginsAppPlugin> getPlugins()
	    {
	        return this.pluginsList;
	    }
}
