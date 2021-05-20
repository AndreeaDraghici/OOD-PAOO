package menu;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import plugincerc.Cerc;
import plugindreptunghi.Dreptunghi;
import pluginpatrat.Patrat;
import plugins.PluginManager;
import plugins.interfaces.IGraphicElement;
import plugintriunghi.Triunghi;
import shape.Plansa;

public class ApplicationMenu {
	
	private Scanner scan=new Scanner(System.in);
	private static  Plansa elementsList = new Plansa();
	
    private Menu mainMenu = null;
    
    private PluginManager pluginMan;
    private Plansa shape = null;
    
    public ApplicationMenu(PluginManager pluginMan, Plansa shape)
    {
        this.pluginMan = pluginMan;        
        this.shape = shape;
    }
    
   
    private void uiAddElement( ArrayList<IMenuItem> ElementsOptions) {
    	try {
		for(IMenuItem option:ElementsOptions){
			System.out.println(option.getText());
		}
		System.out.print("\nIntroduceti optiunea dvs: ");
		ElementsOptions.get(scan.nextInt()).execute(); 	
		
    	}catch(Exception e) {
    		System.out.println(e.getMessage());
    	}
    	System.out.print("\nAdaugare efectuata!\n\n");
	}
    
   
	private void display() {
   		elementsList.draw();
   	}
    
    private void uiDeleteElement() {
    
		System.out.print("Introduceti id-ul formei pe care doriti sa o stergeti: ");
		try {
			int id = scan.nextInt();
			elementsList.removeElement(id);
		} catch (Exception e) {
			
			System.out.println(e.getMessage());
		} 	
		System.out.print("\nStergere efectuata!\n\n");
	 }
    
    
    public void addCerc(){
    	System.out.println("---Adauga informatii cerc---");
    	
		System.out.print("Ox= ");
		double Ox = scan.nextDouble();
		
		System.out.print("Oy= ");
		double Oy = scan.nextDouble();
		
		System.out.print("Raza= ");
		double Raza = scan.nextDouble();
		
		elementsList.addElement(new Cerc(Ox, Oy, Raza));
	}
    
    public void addTriunghi(){
    	System.out.println("---Adauga informatii triunghi--");
    	
		System.out.print("Latura 1= ");
		double l1 = scan.nextDouble();
		
		System.out.print("Latura2= ");
		double l2 = scan.nextDouble();
		
		System.out.print("Baza= ");
		double baza = scan.nextDouble();
		
		elementsList.addElement(new Triunghi(l1, l2, baza));
	}
    
    public void addDreptunghi(){
    	System.out.println("---Adauga informatii dreptunghi--");
    	
		System.out.print("Lungimea= ");
		double l= scan.nextDouble();
		
		System.out.print("Inaltimea= ");
		double h = scan.nextDouble();
		
		elementsList.addElement(new Dreptunghi(l,h));	
	}
    
    public void addPatrat(){
    	System.out.println("---Adauga informatii patrat---");

    	System.out.print("Latura= ");
		double lat = scan.nextDouble();
		
		elementsList.addElement(new Patrat(lat));
	}
    
    public void ModificareCerc(int id){

    	System.out.println("---Modifica informatii cerc---");
    	
		System.out.print("Noul Ox= ");
		double Ox = scan.nextDouble();
		
		System.out.print("Noul Oy= ");
		double Oy = scan.nextDouble();
		
		System.out.print("Noua raza= ");
		double Raza = scan.nextDouble();
		
		elementsList.setElement(id, new Cerc(Ox, Oy, Raza));
	}
    
     public void ModificareTriunghi(int id){

    	 System.out.println("---Modifica informatii triunghi---");
    	 
		System.out.print("Noua Latura1= ");
		double l1 = scan.nextDouble();
		
		System.out.print("Noua Latura2= ");
		double l2 = scan.nextDouble();
		
		System.out.print("Noua Baza= ");
		double baza = scan.nextDouble();
		
		elementsList.setElement(id,new Triunghi(l1, l2, baza));
	}
     
     public void ModificareDreptunghi(int id){
	     
    	  System.out.println("---Modifica informatii dreptunghi---");
    	 
 		System.out.print("Noua Lungime= ");
 		double l= scan.nextDouble();
 		
 		System.out.print("Noua Inaltime= ");
 		double h = scan.nextDouble();
 		
 		elementsList.setElement(id,new Dreptunghi(l,h));	
 	}
     public void ModificarePatrat(int id){

    	 System.out.println("---Modifica informatii patrat---");
    	 
 		System.out.print("Noua Latura= ");
 		double lat = scan.nextDouble();
 		
 		elementsList.setElement(id,new Patrat(lat));
 	}
     
    
 	private void uiModificareElement() {
		
 		System.out.println("Introduceti id-ul formei pe care doriti sa o modificati: ");
 		try {
 			int id= scan.nextInt();
 			
 			if (elementsList.getElement(id).getClass() == Cerc.class) {
 				ModificareCerc(id);
 				
 			} else if (elementsList.getElement(id).getClass() == Triunghi.class) {
 				ModificareTriunghi(id);
 				
 			} else if (elementsList.getElement(id).getClass() == Dreptunghi.class) {
 				ModificareDreptunghi(id);
 				
 			} else {
 				ModificarePatrat(id);
 			}
 		} catch (Exception e) {
 			System.out.println(e.getMessage());
 		}
 		System.out.print("\nModificare efectuata!\n\n");
 	}
     
    
    @SuppressWarnings("unused")
	public void loadMain() {
    	
    	//manager.loadPlugins("/plugins");
    	
    	ArrayList<IMenuItem> menuItems = new ArrayList<IMenuItem>();
 	    ArrayList<IMenuItem> showElementsOptions = new ArrayList<IMenuItem>();
 	    ArrayList<IMenuItem> ElementsOptions=new ArrayList<IMenuItem>();
 	    
 	    int shortCut = 1;
 	   System.out.print("--- Gestionarea formelor geometrice ---\n\n");
 	    
 	   IMenuItem currentItem = new MenuItem("Adauga forma", shortCut++, (parameters)->{
           uiAddElement( ElementsOptions);
       });       
       menuItems.add(currentItem);
 	
      ElementsOptions.add(new MenuItem("0.Exit.", 0, (parameters) -> {
      }));
      
      ElementsOptions.add(new MenuItem("1.Adauga cerc", 1, (parameters) -> {
   	   addCerc();
      }));
      
      ElementsOptions.add(new MenuItem("2.Adauga triunghi", 2, (parameters) -> {
   	   addTriunghi();
      }));
      
      ElementsOptions.add(new MenuItem("3.Adauga dreptunghi ", 3, (parameters) -> {
   	   addDreptunghi();
      }));
   
      ElementsOptions.add(new MenuItem("4.Adauga patrat ", 4, (parameters) -> {
   	   addPatrat();
      }));
	    
      currentItem = new MenuItem("Sterge forma", shortCut++, (parameters)->{
  	   	uiDeleteElement();
      });       
      menuItems.add(currentItem); 
      
      currentItem = new MenuItem("Modifica forma", shortCut++, (parameters)->{
     	   	uiModificareElement();
      });       
      menuItems.add(currentItem); 
      
      currentItem = new MenuItem("Vizualizare plansa de lucru", shortCut++, (parameters)->{
    	   	display();
       });       
       menuItems.add(currentItem); 
      
       mainMenu = new Menu("Main Menu", -1, menuItems);
      
    }	
    	 
    @SuppressWarnings("unchecked")
	public void load()
    {
        pluginMan.loadPlugins("/plugins");
        ArrayList<IMenuItem> menuItems = new ArrayList();
        
        int shortCut = 1;
        var plugins = pluginMan.getPlugins();
        
        for (int i = 0 ; i < plugins.size(); i++)
        {      
           var currentPlugin = plugins.get(i); 
           
           MenuItem currentItem = new MenuItem(plugins.get(i).getDisplayText(), shortCut++, (parameters)->{
        	   
        	   @SuppressWarnings("unused")
			IGraphicElement shape = currentPlugin.getShape();
        	   
               //shape.addShape(shape);
           });
           menuItems.add(currentItem);
        }
    }
    public void execute() throws Exception{ mainMenu.execute(); }
}