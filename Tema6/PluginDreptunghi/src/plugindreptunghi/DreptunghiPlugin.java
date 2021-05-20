package plugindreptunghi;

import plugins.interfaces.IGraphicElement;
import plugins.interfaces.IPluginsAppPlugin;

public class DreptunghiPlugin implements IPluginsAppPlugin {
	  @Override
	    public String getUniqueNameText() {
	        return "DreptunghiPlugin";
	    }

	    @Override
	    public String getDisplayText() {
	        return "Dreptunghi";
	    }

	    @Override
	    public IGraphicElement getShape() {
	        return new Dreptunghi();
	    }
}
