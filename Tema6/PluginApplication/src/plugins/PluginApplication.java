package plugins;

import menu.ApplicationMenu;
import shape.Plansa;

public class PluginApplication {

	public static void main(String[] args) {
		
		  PluginManager pluginMan = new PluginManager();
	      Plansa shape = new Plansa();
	     
		  ApplicationMenu menu = new ApplicationMenu(pluginMan, shape);
		  
		  menu.loadMain();
		  
			try {
				
			  menu.execute();
			
			}catch(Exception e){
	    		    
				      System.out.println(e.getMessage());
				      e.printStackTrace();
	    	   }	
	    }
}