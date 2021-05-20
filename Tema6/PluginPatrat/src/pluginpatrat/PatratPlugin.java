package pluginpatrat;

import plugins.interfaces.IPluginsAppPlugin;
import plugins.interfaces.IGraphicElement;


public class PatratPlugin implements IPluginsAppPlugin{

    @Override
    public String getUniqueNameText() {
        return "PatratPlugin";
    }

    @Override
    public String getDisplayText() {
        return "Patrat";
    }

    @Override
    public IGraphicElement getShape() {
        return new Patrat();
    }
}
