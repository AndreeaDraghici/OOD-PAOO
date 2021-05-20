package plugincerc;
import plugins.interfaces.IGraphicElement;
import plugins.interfaces.IPluginsAppPlugin;

public class CercPlugin implements IPluginsAppPlugin  {

    @Override
    public String getUniqueNameText() {
        return "CercPlugin";
    }

    @Override
    public String getDisplayText() {
        return "Cerc";
    }

    @Override
    public IGraphicElement getShape() {
        return new Cerc();
    }
}
