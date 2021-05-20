package shape;

import java.util.ArrayList;

import plugins.interfaces.IGraphicElement;

public class Plansa implements IGraphicElement{
	
private ArrayList<IGraphicElement>elements=new ArrayList<IGraphicElement>();
	
	public void addElement(IGraphicElement element){
		elements.add(element);
    }
	
	public void removeElement(int id) {
		elements.remove(id);
	}
	
	public IGraphicElement getElement(int id){
		return elements.get(id);
	}
	
	public IGraphicElement setElement(int id,IGraphicElement element){
		return elements.set(id,element);
	}

	@Override
	public void draw() {
		elements.forEach((element)->{element.draw();});
	}
}
