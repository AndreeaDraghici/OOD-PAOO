package reusablemenu.sample;

import java.util.ArrayList;
import java.util.Collections;

public class Student implements Comparable<Student>{

	private String Nume;
	private String Prenume;
	private int Anul;
	private String Specializare;
	private int Grupa;
	private int Cnp;
	
	public Student(String nume,String prenume, int anul,String specializare,int grupa,int cnp){
		this.Nume=nume;
		this.Prenume=prenume;
		this.Anul=anul;
		this.Specializare=specializare;
		this.Grupa=grupa;
		this.Cnp=cnp;
	}
	
	public int getGrupa(){return Grupa;}
	public void setGrupa(int gr){this.Grupa=gr;}
	
	public int getAnul(){return Anul;}
	public void setAnul(int an){this.Anul=an;}
	
	public String getSpecializare (){return Specializare;}
	public void setSpecializare(String sp){this.Specializare=sp;}
	
	public String getNume(){return Nume;}
	public void setNume(String name){this.Nume=name;}
	
	public String getPrenume(){return Prenume;}
	public void setPrenume(String secondname){this.Prenume=secondname;}
	
	public int getCnp() {return Cnp;}
	public void setCnp(int id) {this.Cnp=id;}

	@Override     
	public int compareTo(Student student1) {
		
	    if (this.getCnp() < student1.getCnp()) {
	    	return -1; }
		else if(this.getCnp()> student1.getCnp()) {
			return 1; }
	    else {
	    	return 0; }
	 }       
	
	@Override     
	 public String toString() {         
	     return  this.Nume + " " + this.Prenume + " " + this.Anul + " " + this.Specializare + " " + this.Grupa + " " + this.Cnp;     
	 } 
	
	 ArrayList<Student>StudentList = new ArrayList<>();
	
	 public Student( ArrayList<Student> StudentList) {
		 this.StudentList=StudentList;
	 }
	 public ArrayList<Student> getSortedStudentByid() {         
		    Collections.sort(StudentList);       
		    return StudentList;    
	 } 
	 public ArrayList<Student> sortDescending() {         
		    Collections.sort(this.StudentList, Collections.reverseOrder());         
		    return this.StudentList;     
	 } 
	 public void setStudent(String string) {}
 	
}


