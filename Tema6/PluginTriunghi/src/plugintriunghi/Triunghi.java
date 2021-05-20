package plugintriunghi;
import plugins.interfaces.IGraphicElement;

public class Triunghi implements IGraphicElement {
	
	private double latura1=0;
	private double latura2=0;
	private double baza=0;

	public Triunghi(double _latura1, double _latura2, double _baza) {
		super();
		this.latura1 = _latura1;
		this.latura2 = _latura2;
		this.baza = _baza;
	}
	public Triunghi() {}
	
	
	public double getLatura1() {return latura1;}
	public void setLatura1(double _latura1) {this.latura1 = _latura1;}

	public double getLatura2() {return latura1;}
	public void setLatura2(double _latura2) {this.latura2= _latura2;}

	public double getBaza() {return baza;}
	public void setBaza(double _baza) {this.baza = _baza;}

	@Override
	public void draw() {
		  System.out.println("Triunghi:Latura1= " + latura1 + ", Latura2= " + latura2 + ", Baza= " + baza);
	}
}