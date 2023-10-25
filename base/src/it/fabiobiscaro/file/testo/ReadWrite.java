package it.fabiobiscaro.file.testo;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class ReadWrite {
	
	public static void main(String[] args) {
		// Scrivere un testo all'interno di un file
		PrintWriter pw = null;
		
		//FileWriter fw = null;
		try {
			pw = new PrintWriter("prova.txt");
			pw.println("ciao");
			pw.println("xxx");
			pw.close();
			
			Logger.log("ciao");
			
			/*
			fw = new FileWriter("prova.txt");
			fw.write("Ciao Ciao");
			fw.close();*/
			
			// Letture			 
			FileReader fileReader = new FileReader("prova.txt");
			System.out.println((char)fileReader.read());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
