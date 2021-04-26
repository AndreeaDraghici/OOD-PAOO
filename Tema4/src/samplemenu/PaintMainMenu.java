package samplemenu;

public class PaintMainMenu {

	public static void main(String[] args) {
		AppMenu menu = new AppMenu();
	
		menu.load();
		try {
		menu.execute();
		}catch(Exception e){
    		    System.out.println(e.getMessage());
    	        }
	}
}
