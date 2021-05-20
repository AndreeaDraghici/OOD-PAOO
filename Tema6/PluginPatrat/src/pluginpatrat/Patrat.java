package pluginpatrat;

import plugins.interfaces.IGraphicElement;

public class Patrat implements IGraphicElement{
	private double latura=0;
	
	public Patrat(double _latura){
		this.latura = _latura;
	}
	
	public Patrat() {}

	public double getLatura() {return latura;}
	public void setLatura(double _latura) {this.latura = _latura;}
	
	@Override
	 public void draw() {
	        System.out.println("Patrat:Latura=" + latura);
	 }
	
}