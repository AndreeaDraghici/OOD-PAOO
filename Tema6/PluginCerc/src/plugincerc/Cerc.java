package plugincerc;

import plugins.interfaces.IGraphicElement;


public class Cerc implements IGraphicElement{
	

	private double Ox=0;
	private double Oy=0;
	private double raza=0;
	
	public Cerc(double _Ox, double _Oy, double _raza){
		this.Ox = _Ox;
		this.Oy = _Oy;
		this.raza = _raza;
	}
	
	public Cerc() {}
	
	public double getOx() {return Ox;}
	public void setOx(double _Ox) {this.Ox = _Ox;}

	public double getOy() {return Oy;}
	public void setOy(double _Oy) {this.Oy = _Oy;}

	public double getRaza() {return raza;}
	public void setRaza(double _raza) {this.raza = _raza;}

	@Override
	public void draw(){
		System.out.println("Cerc:Ox= " + Ox + ", Oy= " + Oy + ", Raza= " + raza);
	}

}
