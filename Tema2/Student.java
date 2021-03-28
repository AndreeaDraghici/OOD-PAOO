package tema2;
import java.util.Objects;

public class Student {
	private String nume;
	private String prenume;
	private int anul;
	private String specializare;
	private int grupa;
	private int cnp;
	
	public Student(String nume,String prenume, int anul,String specializare,int grupa,int cnp)
	{
		this.nume=nume;
		this.prenume=prenume;
		this.anul=anul;
		this.specializare=specializare;
		this.grupa=grupa;
		this.cnp=cnp;
	}
	
	public Student(String nume2)
	{
		this.nume=nume2;
	}

	public int getgrupa(){return grupa;}
	
	public void setgrupa(int gr){this.grupa=gr;}
	
	public int getanul(){return anul;}
	
	public void setanul(int an){this.anul=an;}
	
	public String getspecializare (){return specializare;}
	
	public void setspecializare(String sp){this.specializare=sp;}
	
	public String getnume(){return nume;}
	
	public void setnume(String name){this.nume=name;}
	
	public String getprenume(){return prenume;}
	
	public void setprenume(String secondname){this.prenume=secondname;}
	
	public int getcnp() {return cnp;}
	
	public void setcnp(int id) {this.cnp=id;}
	
	@Override
	public boolean equals(Object obj)
	{
		if(this==obj)
		{
			return true;
		}
		if(obj==null || getClass()!=obj.getClass())
		{
			return false;
		}
		Student student1=(Student) obj;
		return nume.equals(student1.nume);
	}
	
   @Override
   public int hashCode()
   {
	   return Objects.hash(nume);
   }
}
