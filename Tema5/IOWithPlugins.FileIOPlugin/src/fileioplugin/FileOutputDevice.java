package fileioplugin;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import iowithplugins.abstractions.IOutputDevice;

public class FileOutputDevice implements IOutputDevice{
	@SuppressWarnings("hiding")
	@Override
	public void WriteString(String s) {
		FileOutputStream fileoutput = null;
		
		 try {
		          fileoutput = new FileOutputStream("output");
		          @SuppressWarnings("resource")
				  PrintWriter writer = new PrintWriter(fileoutput);
		          writer.print(s);
		          writer.flush();
	         
		      }catch(FileNotFoundException e){
		    	 
				   System.out.println("Eroare la deschiderea fisierului " + e.getMessage());
				   e.printStackTrace();
			   
		      }catch (IOException e){
		    	 
		            System.out.println("Eroare la procesarea fisierului " + e.getMessage());
		            e.printStackTrace();
	            
	          } catch(Exception e) {
	        	 
			       System.out.println("Eroare neasteptata");
		      }
		      finally {
		 
					 if(fileoutput != null)
					 {
						 try {
							   fileoutput.close();
						     }catch(IOException e){
						    	 
							 System.out.println("Fisierul nu este deschis "+e.getMessage());
						 }
					 }
		     }
    }
}
