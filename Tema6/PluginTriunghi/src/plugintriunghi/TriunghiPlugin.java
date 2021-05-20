package plugintriunghi;

import plugins.interfaces.IGraphicElement;
import plugins.interfaces.IPluginsAppPlugin;

public class TriunghiPlugin implements IPluginsAppPlugin {
	  @Override
	    public String getUniqueNameText() {
	        return "TriunghiPlugin";
	    }

	    @Override
	    public String getDisplayText() {
	        return "Triunghi";
	    }

	    @Override
	    public IGraphicElement getShape() {
	        return new Triunghi();
	    }
}
