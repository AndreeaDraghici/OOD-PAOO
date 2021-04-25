package forme_geometrice;

import abstractions.IGraphicElement;

public class Dreptunghi implements IGraphicElement {
	
	private double lungimea=0;
	private double inaltimea=0;
	
	public Dreptunghi(double _lungimea, double _inaltimea){
		this.lungimea = _lungimea;
		this.inaltimea = _inaltimea;	
	}
	public double getLungime() {return lungimea;}
	public void setLungime(double _lungimea) {this.lungimea = _lungimea;}
	
	public double getInaltime() {return inaltimea;}
	public void setInaltime(double _inaltime) {this.inaltimea = _inaltime;}
	
	@Override
    public void draw() {
        System.out.println("Dreptunghi: Lungimea=" + lungimea + ", Inaltimea=" + inaltimea);
    }
	
}
