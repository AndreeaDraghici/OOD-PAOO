package tema2;

import java.util.ArrayList;
import java.util.Scanner;

public class SimpleMenu {
	private Scanner inputScan=new Scanner(System.in);
	private ArrayList<Student>StudentList=new ArrayList<Student>();

	protected void DisplayMenu()
	{ 
			System.out.println("----- GESTIONARE GRUPA STUDENTI -----");
			System.out.println("0.Iesire");
			System.out.println("1.Adaugare");
			System.out.println("2.Modificare");
			System.out.println("3.Stergere");
			System.out.println("4.Vizualizare");
			System.out.println("\nIntroduceti optiunea dvs...");
    }	
public void Run()
{
	int choice=0;	
do
{
  try {

			DisplayMenu();
			choice=inputScan.nextInt();	
			switch(choice)
			{
			case 1:
				uiAdaugareDateStudent();
				break;
			case 2:
				uiModificareDateStudent();
				break;
			case 3:
				uiStergereDateStudent();
				break;
			case 4:
				uiVizualizareDateStudent();
				break;
				default:
					System.out.println("\nAlegeti o optiune valida");
			}
			
      }catch(Exception e)
            {
               System.out.println(e.getMessage());
               continue; 
            }
      finally
       {
	       System.out.println("\n");
       }
   }while(choice!=0);
		 
	   System.out.println("Aplicatia se inchide.... ");
}
	
private void uiVizualizareDateStudent() {
	System.out.println("---Afiseaza date studenti---");
	System.out.println("Nume \tPrenume\tAn\tSpecializare\tGrupa\tCNP");

		for(Student currentStudent:StudentList)
		{
			listStudent(currentStudent);
		}
		inputScan.nextLine();
		inputScan.nextLine();
	System.out.println("Afisare efectuata.... ");
}

private void listStudent(Student currentStudent){

	System.out.println( currentStudent.getnume()
					    +"\t"+currentStudent.getprenume()
					    +"\t"+currentStudent.getanul()
					    +"\t"+currentStudent.getspecializare()
					    +"\t"+currentStudent.getgrupa()
					    +"\t"+currentStudent.getcnp() );
}
private void uiStergereDateStudent() {
	try {
			for(Student currentStudent:StudentList)
			{
				StudentList.remove(currentStudent);
			}
	}catch(Exception e)
		{
			System.out.println("Stergere efectuata");
		}
}

private void uiModificareDateStudent() {
	System.out.println("---Modifica date studenti---");
	do {
         try { 
				String nume=inputScan.nextLine();
				Student student1 = StudentList.get(StudentList.indexOf(new Student(nume)));
				{
					    student1.setanul(inputScan.nextInt());
					    student1.setcnp(inputScan.nextInt());
					    student1.setgrupa(inputScan.nextInt());
					    student1.setprenume(inputScan.nextLine());
					    student1.setspecializare(inputScan.nextLine());
				}
		 
			}catch(Exception e)
			{
				System.out.println("Mesaj: "+e.getMessage());
				break;
			}
			finally{
				       System.out.println("\n");
			       }
         System.exit(0);
	 }while(!true);
	
	System.out.println("Nume \tPrenume\tAn\tSpecializare\tGrupa\tCNP");
	String nume=inputScan.next();
	String prenume=inputScan.next();
	int an=inputScan.nextInt();
	String specializarea=inputScan.next();
	int grupa=inputScan.nextInt();
	int cnp=inputScan.nextInt();
	
	Student student1=new Student(nume,prenume,an,specializarea,grupa,cnp);
	for(Student currentStudent:StudentList)
	{
		StudentList.set(0, student1);
		StudentList.set(1, student1);
	}
}

private void uiAdaugareDateStudent() {
      System.out.println("---Adauga date studenti---");
	  System.out.println("Nume\tPrenume\tAn\tSpecializare\tGrupa\tCNP");

	 try { 
			String nume=inputScan.next();
			String prenume=inputScan.next();
			int anul =inputScan.nextInt();
			String specializare=inputScan.next();
			int grupa=inputScan.nextInt();
			int cnp=inputScan.nextInt();
			
			Student student1=new Student(nume,prenume,anul,specializare,grupa,cnp);
			StudentList.add(student1);
			
			}catch(Exception e)
			   {
					System.out.println("Mesaj: "+e.getMessage());
					System.exit(0);
			   }
			 finally
		     {
			      System.out.println("Optiune finalizata....");
		     }
	   
     }
}
