/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reusablemenu.sample;
import java.util.ArrayList;
import java.util.Scanner;
import reusablemenu.abstractions.IMenuItem;
import reusablemenu.implementation.Menu;
import reusablemenu.implementation.MenuItem;

public class ApplicationMenu {
    
	private ArrayList<Student>StudentList=new ArrayList<Student>();
	private Scanner consoleScanner=new Scanner(System.in);
    private Menu mainMenu = null;
    public ApplicationMenu(){}
    
	private void uiDeleteStudent() {
	try {
		    System.out.println("Sterge date student");
		    System.out.println("Nume\tPrenume\tAn\tSpecializare\tGrupa\tCNP");
			for(Student currentStudent:StudentList)
			{
				StudentList.remove(currentStudent);
			}
				
	    }catch(Exception e)
			{
				System.out.println(e.getMessage());
			}
		System.out.println("Stergere efectuata");
	}
	
	private void uiAfisareDescrescatoare() {
	try {
			 System.out.println("---Afisare Descrescatoare dupa CNP--");
		   	 System.out.println("Nume\tPrenume\tAn\tSpecializare\tGrupa\tCNP");
		   	 
			 Student student1=new Student(StudentList);
			 ArrayList<Student> sortedArrayListDescending = student1.sortDescending(); 
				 for (Student StudentList : sortedArrayListDescending)
				  { 
				      System.out.println(""+ StudentList);         
				  }       
				consoleScanner.nextLine();
				consoleScanner.nextLine();
		}catch(Exception e)
		  {
			 System.out.println(e.getMessage());
		  }
	   System.out.println("Afisare efectuata.... ");
	}
	
	private void uiAfisareCrescatoare() {	
    try {	 
    	    System.out.println("---Afisare Crescatoare dupa CNP---");
  	        System.out.println("Nume\tPrenume\tAn\tSpecializare\tGrupa\tCNP");

			Student student1=new Student(StudentList);
			ArrayList<Student> sortedStudent = student1.getSortedStudentByid();  
			
			for (Student StudentList : sortedStudent)
			  { 
			      System.out.println(""+ StudentList);         
			  }       
				
			consoleScanner.nextLine();
			consoleScanner.nextLine();
			
       }catch(Exception e)
		  {
			 System.out.println(e.getMessage());
		  }
	  System.out.println("Afisare efectuata.... ");
   }
   
    private void uiAddStudent() {
    	
      System.out.println("---Adauga date studenti---");
   	  System.out.println("Nume\tPrenume\tAn\tSpecializare\tGrupa\tCNP");
   	  
   do {
   	  try { 
	   			String nume=consoleScanner.next();
	   			String prenume=consoleScanner.next();
	   			int anul =consoleScanner.nextInt();
	   			String specializare=consoleScanner.next();
	   			int grupa=consoleScanner.nextInt();
	   			int cnp=consoleScanner.nextInt();
	   			
	   			Student student1=new Student(nume,prenume,anul,specializare,grupa,cnp);
	   			StudentList.add(student1);
	   			
   			}catch(Exception e)
   			   {
   					System.out.println(e.getMessage());
   					System.exit(0);
   			   }
     }while(!true);
   
   }
	public void load()
    {
	   ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
	   ArrayList<IMenuItem> showStudentsOptions = new ArrayList<IMenuItem>();
	    
	   int shortCut = 1;    
	    
       IMenuItem currentItem = new MenuItem("Adaugare studenti", shortCut++, (parameters)->{
           uiAddStudent();
       });       
       menuItems.add(currentItem);
       
       currentItem = new MenuItem("Sterge studenti", shortCut++, (parameters)->{
    	   	uiDeleteStudent();
       });       
       menuItems.add(currentItem);   
              
       showStudentsOptions.add(new MenuItem("Ordonat crescator", 1, (parameters) -> { uiAfisareCrescatoare();  
       System.out.println("Ordonare crescatoare executata");   
       }));
       
       showStudentsOptions.add(new MenuItem("Ordonat descrescator", 2, (parameters) -> { uiAfisareDescrescatoare();
       	System.out.println("Ordonare descrescatoare executata");   
        }));
       
       currentItem = new Menu("Afisaza studenti", shortCut++, showStudentsOptions);       
       menuItems.add(currentItem);
       
        mainMenu = new Menu("Main Menu", -1, menuItems);    
    }
    public void execute(){mainMenu.execute();}
    
}
