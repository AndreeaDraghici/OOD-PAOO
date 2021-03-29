package tema1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class String {

	public static void main(java.lang.String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Scanner inputScan=new Scanner(System.in);
		java.lang.String readValue=inputScan.next();
		
		FileWriter writer=new FileWriter("Test.txt",true);
	try{
		while(!"end".equals(readValue))
		{
			writer.write(readValue);
			readValue=inputScan.nextLine();
		}
		writer.close();
		
	    }catch(IOException e)
		{
		    e.printStackTrace();
		}
		
	}

}
