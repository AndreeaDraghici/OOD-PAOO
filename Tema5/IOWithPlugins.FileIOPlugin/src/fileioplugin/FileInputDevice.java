package fileioplugin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import iowithplugins.abstractions.IInputDevice;

public class FileInputDevice implements IInputDevice {
	@SuppressWarnings("hiding")
	@Override
	public String ReadString() {
		FileInputStream file = null;
		String string = "";
		try {
	            file = new FileInputStream("input");
	            @SuppressWarnings("resource")
				Scanner scanner = new Scanner(file);
	            string = scanner.nextLine();
	        
             }catch(FileNotFoundException e){
        	
	        	 System.out.println("Fisierul nu exista " + e.getMessage());
	        	 e.printStackTrace();
        	 
	     	 }catch(IOException e){
			 
	             System.out.println("Fisierul nu poate fi citit" + e.getMessage());
	             e.printStackTrace();
             }
		     catch(Exception e) {
			     System.out.println("Eroare neasteptata");
		     }
			finally {
				
					if(file != null)
					{
						 try 
						 {
						   file.close();	
						 }catch(IOException e)
						  {
						   System.out.println("Fisierul nu este deschis " + e.getMessage());
						  }
					}
		          }  
		return string;
	}
}

